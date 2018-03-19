package com.imooc.wiremock;

import org.apache.commons.io.FileUtils;
import org.springframework.core.io.ClassPathResource;

import java.io.IOException;
import java.nio.charset.Charset;

import static com.github.tomakehurst.wiremock.client.WireMock.*;

public class MockServer {

    public static void main(String[] args) throws IOException {
        // 绑定本地服务器
        configureFor(8062);
        // 清理配置
        removeAllMappings();

        mock("/order/1", "mock/response/order_1.txt");

    }

    private static void mock(String url, String file) throws IOException {
        ClassPathResource order1 = new ClassPathResource(file);
        String order1Content = FileUtils.readFileToString(order1.getFile(), Charset.defaultCharset());

        stubFor(get(urlPathEqualTo(url))
                .willReturn(aResponse()
                        .withBody(order1Content)
                        .withStatus(200))
        );

    }

}
