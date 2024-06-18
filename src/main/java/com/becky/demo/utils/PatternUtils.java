package com.becky.demo.utils;

import java.util.regex.Pattern;

public class PatternUtils {
    /**
     * 英文 數字 空白字元 中文
     */
    public static final Pattern VALID_CHARACTER = Pattern.compile("^[\\w\\s\\u4e00-\\u9fa5]+$");

    /**
     * 英文 空白字元 中文
     */
    public static final Pattern VALID_CHARACTER_NO_NUMBER = Pattern.compile("^[A-Za-z\\s\\u4e00-\\u9fa5]+$");

    /**
     * 英文 數字 空白字元 中文 常用全形半形標點符號
     */
    public static final Pattern WORD_PUNCTUATION = Pattern.compile("^[\\w\\s\\u4e00-\\u9fa5\\p{Punct}~!@?()\\-+=;:,\\.{}～！？＄％＆（）−＋＝：；，。、＜＞「」『』【】〈〉《》※\\n ]+$");

    public static final Pattern EMAIL = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);

    public static final Pattern SHOP_URL = Pattern.compile("^[\\w\\-_]{1,20}$");

    public static final Pattern MEMBER_ID = Pattern.compile("^[\\w\\-_]{1,50}$");

    public static final Pattern MOBILE_NUMBER = Pattern.compile("^\\d{10}$");

    public static boolean isMatch(Pattern pattern, String input) {
        return pattern.matcher(input).find();
    }

    public static void main(String[] args) {
        String test = "aA zZ 059 中文	~!@?()-+=;:{},.～！？＄％＆（）−＋＝：；，。、＜＞「」『』【】[] ";
        System.out.println(isMatch(WORD_PUNCTUATION, test));

        test = "rhenus-vero_";
        System.out.println(isMatch(SHOP_URL, test));

    }

}