package com.becky.demo.config;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.apache.ibatis.mapping.VendorDatabaseIdProvider;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.mybatis.spring.boot.autoconfigure.MybatisProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.env.Environment;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.support.TransactionTemplate;
import org.springframework.util.ObjectUtils;

import javax.sql.DataSource;
import java.util.Properties;

@Configuration
@MapperScan(basePackages = "com.becky.demo.model.mapper.mysql")
public class MysqlDataSourceConfig {
    public static final String MYSQL_TX_MANGER = "mysqlTxManager";
    @Autowired
    private Environment env;
    @Autowired
    private  MybatisProperties mybatisProperties;
    @Bean
    @Primary
    public DataSource mysqlDataSource() {
        HikariConfig config = new HikariConfig();
        config.setDriverClassName(env.getProperty("jdbc.mysql.driver"));
        config.setJdbcUrl(env.getProperty("jdbc.mysql.url"));
        config.setUsername(env.getProperty("jdbc.mysql.username"));
        config.setPassword(env.getProperty("jdbc.mysql.password"));
        config.setMaximumPoolSize(8);
        return new HikariDataSource(config);
    }

    @Bean
    public VendorDatabaseIdProvider databaseIdProvider() {
        Properties vendors = new Properties();
        vendors.setProperty("MYSQL", "mysql");
        vendors.setProperty("HQL Databse Engine", "hsql");
        VendorDatabaseIdProvider idProvider = new VendorDatabaseIdProvider();
        idProvider.setProperties(vendors);
        return idProvider;
    }

    @Bean
    public SqlSessionFactory mysqlSqlSessionFactory() {
        SqlSessionFactoryBean factory = new SqlSessionFactoryBean();
        factory.setDataSource(mysqlDataSource());
        factory.setDatabaseIdProvider(databaseIdProvider());
        // 设置mapperLocations属性，指定XML映射文件的位置
        try {
//            factory.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath:**/mapperxml/*.xml"));
            return factory.getObject();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Bean
    public SqlSessionTemplate mySqlSessionTemplate() {
        return new SqlSessionTemplate(mysqlSqlSessionFactory());
    }

    @Bean(name = "MYSQL_TX_MANGER")
    public DataSourceTransactionManager mysqlTxManager() {
        return new DataSourceTransactionManager(mysqlDataSource());
    }

    @Bean
    public TransactionTemplate mysqlTxTemplate(DataSourceTransactionManager mysqlTxManager) {
        return new TransactionTemplate(mysqlTxManager);
    }
}
