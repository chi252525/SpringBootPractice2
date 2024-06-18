package com.becky.demo.utils;

import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;

import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Paths;

public class StringFormatters {

    /**
     * Format string by replacing placeholder "{}" with the parameters
     * @param str original string
     * @param params parameters
     * @return
     */
    public static String format(String str, Object... params) {
        if (str == null) {
            return null;
        } else if (ArrayUtils.isEmpty(params)) {
            return str;
        } else {
            for (int i = 0; i < params.length; i++) {
                String param = params[i] == null ? "null" : String.valueOf(params[i]);
                str = str.replaceFirst("\\{\\}", param);
            }
            return str;
        }
    }

    /**
     * Replace all back slash to slash.
     * @param str
     * @return
     */
    public static String formatSlash(String str) {
        return str.replaceAll("\\\\", "/");
    }


    /**
     * Return an valid url.
     * <ul>
     * <li>http://domain.com/		--> 	http://domain.com</li>
     * <li>http:\\domain.com			-->		http://domain.com</li>
     * <li>domain.com				-->		error</li>
     * <li>http://domain.com:8080	-->		http://domain.com:8080</li>
     * <li>http://domain.com/hi		-->		http://domain.com/hi</li>
     * </ul>
     *
     * @param url
     * @throws MalformedURLException
     */
    public static String formatUrl(String url) throws MalformedURLException {
        url = formatSlash(url);
        if (url.endsWith("/")) {
            url = url.substring(0, url.length() - 1);
        }
        new URL(url); // validate url string by using URL object
        return url;
    }



    /**
     * Format bucket. A valid bucket format should looks like "/bucket/name" Start with "/", no ending "/". validated by {@link Paths#get(String, String...)}
     *
     * @param bucket
     * @return
     */
    public static String formatBucket(String bucket) {
        // use Paths#get to validate, this will return path without ending '/'
        bucket = Paths.get(bucket).normalize().toString();
        bucket = bucket.replaceAll("\\\\", "/");
        if (StringUtils.isEmpty(bucket)) {
            bucket = "/";
        }
        return bucket;
    }
}