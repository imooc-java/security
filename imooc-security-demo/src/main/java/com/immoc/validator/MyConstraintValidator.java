package com.immoc.validator;

import com.immoc.service.HelloService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class MyConstraintValidator implements ConstraintValidator<MyConstraint, Object> {

    @Autowired
    private HelloService helloService;

    private static final Logger logger = LoggerFactory.getLogger(MyConstraintValidator.class);

    @Override
    public void initialize(MyConstraint constraintAnnotation) {
        logger.info("initialize");
    }

    @Override
    public boolean isValid(Object value, ConstraintValidatorContext context) {
        logger.info(helloService.hello(value.toString()));
        logger.info("isValid value={}", value);
        return true;
    }

}
