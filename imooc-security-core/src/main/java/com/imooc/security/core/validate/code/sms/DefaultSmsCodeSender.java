package com.imooc.security.core.validate.code.sms;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DefaultSmsCodeSender implements SmsCodeSender {

    private static final Logger logger = LoggerFactory.getLogger(DefaultSmsCodeSender.class);

    @Override
    public void send(String mobile, String msg) {
        logger.info("向手机 {} 发送短信: {}", mobile, msg);
    }
}
