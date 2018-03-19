package com.imooc.web.controller;

import com.fasterxml.jackson.annotation.JsonView;
import com.imooc.dto.User;
import com.imooc.exception.UserNotExistException;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.apache.commons.lang.builder.ReflectionToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    @PostMapping
    public User create(@Valid @RequestBody User user) {
        logger.info(ReflectionToStringBuilder.toString(user, ToStringStyle.MULTI_LINE_STYLE));

//        if (errors.hasErrors()) {
//            errors.getAllErrors().forEach(e -> logger.error(e.getDefaultMessage()));
//        }

        return user.setId("1");
    }

    @PutMapping("/{id:\\d+}")
    public User update(@Valid @RequestBody User user, BindingResult errors) {
        logger.info(ReflectionToStringBuilder.toString(user, ToStringStyle.MULTI_LINE_STYLE));

        if (errors.hasErrors()) {
            errors.getAllErrors().forEach(e -> logger.error(e.getDefaultMessage()));
        }

        return user;
    }

    @GetMapping
    @JsonView(User.UserSimpleView.class)
    @ApiOperation(value = "用户查询服务")
    public List<User> query(User user, @PageableDefault(size = 10, page = 0) Pageable pageable) {

        // 通过反射方法，打印查询参数对象
        logger.info(ReflectionToStringBuilder.toString(user, ToStringStyle.MULTI_LINE_STYLE));
        logger.info(ReflectionToStringBuilder.toString(pageable, ToStringStyle.MULTI_LINE_STYLE));

        ArrayList<User> users = new ArrayList<>();
        users.add(new User().setUsername("user1").setPassword("1"));
        users.add(new User().setUsername("user2").setPassword("2"));
        users.add(new User().setUsername("user3").setPassword("3"));
        return users;
    }

    @GetMapping("/{id:\\d+}")
    @JsonView(User.UserDetailView.class)
    public User getInfo(@ApiParam(value = "用户ID") @PathVariable String id) {
//        throw new UserNotExistException(id);

        logger.info("getInfo user_id = {}", id);
        return new User().setUsername("user1").setPassword("1");

    }

    @DeleteMapping("/{id:\\d+}")
    public void delete(@PathVariable String id) {
        logger.info("delete user_id = {}", id);
    }

}
