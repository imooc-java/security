package com.imooc.web.controller;

import com.imooc.DemoApplication;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.nio.charset.Charset;
import java.time.LocalDateTime;
import java.util.Date;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = DemoApplication.class)
public class UserControllerTest {

    private static final Logger logger = LoggerFactory.getLogger(UserControllerTest.class);

    @Autowired
    private WebApplicationContext wac;

    private MockMvc mockMvc;

    @Before
    public void setup() {
        mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
    }

    @Test
    public void whenQuerySeccuss() throws Exception {
        MockHttpServletRequestBuilder request = get("/user")
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .param("username", "user1")
                .param("size", "15")
                .param("page", "1")
                .param("sort", "username,desc");

        logger.info(mockMvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.length()").value(3))
                .andReturn().getResponse().getContentAsString())
        ;
    }

    @Test
    public void whenGetInfoSuccess() throws Exception {
        MockHttpServletRequestBuilder request = get("/user/1")
                .contentType(MediaType.APPLICATION_JSON_UTF8);

        logger.info(mockMvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.username").value("user1"))
                .andReturn().getResponse().getContentAsString())
        ;
    }

    @Test
    public void whenGetInfoFail() throws Exception {
        MockHttpServletRequestBuilder request = get("/user/a")
                .contentType(MediaType.APPLICATION_JSON_UTF8);

        mockMvc.perform(request)
                .andExpect(status().is4xxClientError())
        ;
    }

    @Test
    public void whenCreateSuccess() throws Exception {

        Date date = new Date();
        String content = "{\"username\":\"user1\",\"password\":\"1\",\"birthday\":" + date.getTime() + "}";

        logger.info("content={}", content);

        MockHttpServletRequestBuilder request = post("/user")
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .content(content);

        logger.info(mockMvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(1))
                .andReturn().getResponse().getContentAsString())
        ;

    }


    @Test
    public void whenUpdateSuccess() throws Exception {

        Date date = new Date(System.currentTimeMillis() + 100000);
        String content = "{\"id\":\"1\",\"username\":\"user1\",\"password\":\"1\",\"birthday\":" + date.getTime() + "}";

        logger.info("content={}", content);

        MockHttpServletRequestBuilder request = put("/user/1")
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .content(content);

        logger.info(mockMvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(1))
                .andReturn().getResponse().getContentAsString())
        ;

    }

    @Test
    public void whenDeleteSuccess() throws Exception {

        MockHttpServletRequestBuilder request = delete("/user/1")
                .contentType(MediaType.APPLICATION_JSON_UTF8);

        mockMvc.perform(request)
                .andExpect(status().isOk())
        ;

    }

    @Test
    public void whenUploadSuccess() throws Exception {
        MockHttpServletRequestBuilder request = fileUpload("/file")
                .file(new MockMultipartFile("file", "test.txt", "multipart/form-data", "hello upload".getBytes(Charset.forName("UTF-8"))));

        String result = mockMvc.perform(request)
                .andExpect(status().isOk())
                .andReturn().getResponse().getContentAsString();
        logger.info(result);
    }
}
