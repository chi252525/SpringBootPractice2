 CREATE TABLE user (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    create_timeStamp TIMESTAMP,
    update_timeStamp TIMESTAMP,
    name VARCHAR(255) NOT NULL,
    password VARCHAR(255) NOT NULL,
    email_address VARCHAR(255),
    enabled BIGINT,
    last_login_at TIMESTAMP
);