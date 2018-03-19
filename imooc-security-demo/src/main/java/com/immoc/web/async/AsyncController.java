package com.immoc.web.async;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.Callable;

@RestController
public class AsyncController {

    private static final Logger logger = LoggerFactory.getLogger(AsyncController.class);

    @RequestMapping("/order")
    public Callable<String> order() throws InterruptedException {
        logger.info("主线程开始");

        Callable<String> result = () -> {
            logger.info("副线程开始");
            Thread.sleep(1000);
            logger.info("副线程返回");
            return null;
        };

        logger.info("主线程返回");
        return result;
    }

}
