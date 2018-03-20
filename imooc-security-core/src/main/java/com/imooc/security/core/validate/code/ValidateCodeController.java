package com.imooc.security.core.validate.code;

import com.imooc.security.core.validate.code.sms.SmsCodeSender;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.social.connect.web.HttpSessionSessionStrategy;
import org.springframework.social.connect.web.SessionStrategy;
import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.ServletWebRequest;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@RestController
public class ValidateCodeController {

    public static final String SESSION_KEY = "SESSION_KEY_IMAGE_CODE";

    @Autowired
    private ValidateCodeGenerator imageCodeGenerator;

    @Autowired
    private ValidateCodeGenerator smsCodeGenerator;

    @Autowired
    private SmsCodeSender smsCodeSender;

    private SessionStrategy sessionStrategy = new HttpSessionSessionStrategy();

    @GetMapping("/code/image")
    public void createCode(HttpServletRequest request, HttpServletResponse response) throws IOException {
        ImageCode imageCode = (ImageCode) imageCodeGenerator.generate(new ServletWebRequest(request));
        sessionStrategy.setAttribute(new ServletWebRequest(request), SESSION_KEY, imageCode);
        ImageIO.write(imageCode.getImage(), "JPEG", response.getOutputStream());
    }

    @GetMapping("/code/sms")
    public void createSmsCode(HttpServletRequest request, HttpServletResponse response) throws ServletRequestBindingException {
        ValidateCode validateCode = smsCodeGenerator.generate(new ServletWebRequest(request));
        sessionStrategy.setAttribute(new ServletWebRequest(request), SESSION_KEY, validateCode);
        // 发送短信
        String mobile = ServletRequestUtils.getRequiredStringParameter(request, "mobile");
        smsCodeSender.send(mobile, validateCode.getCode());
    }

}
