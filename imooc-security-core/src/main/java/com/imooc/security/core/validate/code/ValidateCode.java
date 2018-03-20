package com.imooc.security.core.validate.code;

import java.time.LocalDateTime;

public class ValidateCode {

    /**
     * 随机数
     */
    private String code;

    /**
     * 过期时间
     */
    private LocalDateTime expireTime;

    /**
     *
     * @param code 随机数
     * @param expireInt 有效时间（秒）
     */
    public ValidateCode(String code, int expireInt) {
        this(code, LocalDateTime.now().plusSeconds(expireInt));

    }

    /**
     *
     * @param code 随机数
     * @param expireTime 过期时间
     */
    public ValidateCode(String code, LocalDateTime expireTime) {
        this.code = code;
        this.expireTime = expireTime;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public LocalDateTime getExpireTime() {
        return expireTime;
    }

    public void setExpireTime(LocalDateTime expireTime) {
        this.expireTime = expireTime;
    }

    public boolean isExpried() {
        return LocalDateTime.now().isAfter(expireTime);
    }

}
