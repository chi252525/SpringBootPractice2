package com.becky.demo.exception.constants;


import org.apache.commons.lang3.StringUtils;

public enum ErrorEnum {

    /*
     * =============================== General Purpose ===============================
     */
    REQUIRED("{}為必填"),
    CANNOT_BE_EMPTY("{}不能為空"),
    NOT_FOUND("查無{}資料"),
    EXPIRED("{}已過期"),
    FORBIDDEN_ACTION("操作被禁止"),
    UNAUTHORIZED_ACTION("無權限操作"),
    INVALID_PARAMETER("輸入的參數有錯誤或不合法！"),
    INVALID_PARAMETER_DETAIL("輸入的參數有錯誤或不合法！{}"),
    INVALID_DATA("{}為不合法的資料"),
    INVALID_IMAGE("圖片格式錯誤或不合法"),
    INVALID_URL("{}URL為無效的"),
    INVALID_CHARACTER("{}不可包含特殊符號"),
    CONTAIN_INVALID_CHARACTER("{}包含了不合法的字元"),
    INVALID_FORMAT("{}格式錯誤"),
    INVALID_EMAIL("EMAIL格式錯誤"),
    INVALID_ORDER_STATUS("此訂單狀態有誤"),
    LENGTH_CANNOT_LESS_THAN("{}長度不可小於{}"),
    LENGTH_CANNOT_GREATER_THAN("{}長度不可大於{}"),
    CANNOT_OVER_THAN("{}不可超過{}"),
    CANNOT_SMALLER_THAN("{}不可小於{}"),
    DUPLICATED("{}不可重複"),
    NOT_SUPPORTED("{}不支援"),
    UPDATE_NOT_ALLOW("{}不能修改"),
    INTERNAL_SERVER_ERROR("發生未預期的錯誤，請聯絡網站管理員", 5000),
    UNEXPECTED_ERROR("發生未預期的錯誤！ {}"),
    INVALID_MOBILE_NUMBER("請輸入10位半型數字"),
    // add more here...

    /*
     * =============================== Business Logic Specific ===============================
     */
    VERIFY_TOKEN_FAILED("認證錯誤，請確認認證信是否有效"),
    ADMIN_IS_UNIQUE_ROLE("管理員不可兼職其他角色"),
    WRONG_CONFIRM_PASSWORD("新密碼不一致，請重新輸入"),
    NEW_PASSWORD_EQUALS_OLD_PASSWORD("不可與舊密碼相同"),
    PASSWORD_MIN_LENGTH("密碼長度至少要{}碼"),
    DUPLICATE_EMAIL("電子郵件地址已經被使用"),
    NO_LOG_IN("尚未登入"),
    GAME_TOKEN_EXPIRED("你的遊戲入場券過期了，請回首頁"),
    PAYMENT_FAILURE("付款失敗，請聯繫客服"),
    REFUND_FAILURE("退款失敗，請聯繫客服"),
    NOT_REFUNDABLE("不符合退款條件"),
    UNAUTHORIZED("尚未授權", 4001),
    SESSION_EXPIRED("登入時間逾期", 4002),
    ACCESS_DENIED("訪問被拒，權限不足", 4003),
    FILE_SIZE_LIMIT_EXCEEDED("檔案大小超過限制", 4028),
    MAX_REQUEST_REACHED("請求數量已達上限，請稍後再試", 4029),
    ADMIN_CANNOT_EDIT_YOURSELF("ADMIN使用者不能修改自己"),
    ENCRYPT_DECRYPT_FAIL("加密/解密 失敗"),
    ;

    private String message;
    private String formattedMessage;

    /**
     * Error code, if this value is not null, it will be shown on the CommonPayload. It's ok to have the same error code, as long as the client side is able to distinguish the error.
     * <p>
     * The error code format must be four digit integer, e.g. 4001
     * <p>
     * Not all error needs the code, so it's also ok to leave default value.
     * <p>
     * error code must be unique.
     * <p>
     * Please do not use 5000, reserved to Internal Server Exception.
     */
    private Integer code;

    private ErrorEnum(String message) {
        this.message = message;
    }

    private ErrorEnum(String message, Integer code) {
        this.message = message;
        this.code = code;
    }

    /**
     * Format message string by replacing placeholder "{}" with the parameters
     *
     * @param params
     * @return this
     */
    public ErrorEnum format(Object... params) {
        this.formattedMessage = String.format(message, params);
        return this;
    }

    public String getMessage() {
        return message;
    }

    public String getFormattedMessage() {
        return (StringUtils.contains(message, "{}") && formattedMessage!="") ? formattedMessage : message;
    }

    public Integer getCode() {
        return code;
    }

    @Override
    public String toString() {
        return getFormattedMessage();
    }
}

