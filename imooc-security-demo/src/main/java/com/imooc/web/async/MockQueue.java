package com.imooc.web.async;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class MockQueue {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    private String placeOrder;
    private String completedOrder;

    public String getPlaceOrder() {
        return placeOrder;
    }

    public void setPlaceOrder(String placeOrder) throws InterruptedException {
        new Thread(() -> {
            logger.info("接到下单请求");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                logger.error(e.getMessage(), e);
            }
            this.completedOrder = placeOrder;
            logger.info("下单请求处理完毕,{}", completedOrder);
        }).start();
    }

    public String getCompletedOrder() {
        return completedOrder;
    }

    public void setCompletedOrder(String completedOrder) {
        this.completedOrder = completedOrder;
    }
}
