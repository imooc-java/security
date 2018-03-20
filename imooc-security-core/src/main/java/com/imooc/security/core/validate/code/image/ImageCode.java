package com.imooc.security.core.validate.code.image;

import com.imooc.security.core.validate.code.ValidateCode;

import java.awt.image.BufferedImage;
import java.time.LocalDateTime;

public class ImageCode extends ValidateCode {

    /**
     * 根据随机数生成的图片
     */
    private BufferedImage image;

    /**
     * @param image     根据随机数生成的图片
     * @param code      随机数
     * @param expireInt 有效时间（秒）
     */
    public ImageCode(BufferedImage image, String code, int expireInt) {
        this(image, code, LocalDateTime.now().plusSeconds(expireInt));
    }

    /**
     * @param image      根据随机数生成的图片
     * @param code       随机数
     * @param expireTime 过期时间
     */
    public ImageCode(BufferedImage image, String code, LocalDateTime expireTime) {
        super(code, expireTime);
        this.image = image;
    }

    public BufferedImage getImage() {
        return image;
    }

    public void setImage(BufferedImage image) {
        this.image = image;
    }

}
