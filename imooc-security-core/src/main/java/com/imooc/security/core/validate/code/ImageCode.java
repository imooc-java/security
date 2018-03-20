package com.imooc.security.core.validate.code;

import java.awt.image.BufferedImage;
import java.time.LocalDateTime;

public class ImageCode {

    /**
     * 根据随机数生成的图片
     */
    private BufferedImage image;

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
     * @param image 根据随机数生成的图片
     * @param code 随机数
     * @param expireInt 有效时间（秒）
     */
    public ImageCode(BufferedImage image, String code, int expireInt) {
        this(image, code, LocalDateTime.now().plusSeconds(expireInt));

    }

    /**
     *
     * @param image 根据随机数生成的图片
     * @param code 随机数
     * @param expireTime 过期时间
     */
    public ImageCode(BufferedImage image, String code, LocalDateTime expireTime) {
        this.image = image;
        this.code = code;
        this.expireTime = expireTime;
    }

    public BufferedImage getImage() {
        return image;
    }

    public void setImage(BufferedImage image) {
        this.image = image;
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
