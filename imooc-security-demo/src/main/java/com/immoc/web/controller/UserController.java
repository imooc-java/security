package com.immoc.web.controller;

import com.immoc.dto.User;
import org.apache.commons.lang.builder.ReflectionToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class UserController {

    @RequestMapping(value = "/user", method = RequestMethod.GET)
    public List<User> query(User user, @PageableDefault(size = 10, page = 0) Pageable pageable) {

        // 通过反射方法，打印查询参数对象
        System.out.println(ReflectionToStringBuilder.toString(user, ToStringStyle.MULTI_LINE_STYLE));
        System.out.println(ReflectionToStringBuilder.toString(pageable, ToStringStyle.MULTI_LINE_STYLE));

        ArrayList<User> users = new ArrayList<>();
        users.add(new User().setUsername("user1").setPassword("1"));
        users.add(new User().setUsername("user2").setPassword("2"));
        users.add(new User().setUsername("user3").setPassword("3"));
        return users;
    }

}
