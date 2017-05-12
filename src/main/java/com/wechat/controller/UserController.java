package com.wechat.controller;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.wechat.common.constants.PathRoute;
import com.wechat.common.util.ResultResponse;
import com.wechat.entity.User;
import com.wechat.service.UserService;
import org.hibernate.validator.constraints.NotBlank;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

/**
 * Created by hztps on 2017/5/11.
 */
@RestController
@RequestMapping(PathRoute.USER)
public class UserController {

    private Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserService userService;

    /**
     * 查询用户列表
     * @return
     */
    @GetMapping(PathRoute.USER_LIST)
    public Object userList(@ModelAttribute User user) {
        List<User> userList = userService.selectList(new EntityWrapper<>(user));
        return ResultResponse.success("查询用户列表成功", userList);
    }

    /**
     * 添加用户
     *
     * @param userName
     * @param userPassword
     * @return
     */
    @PostMapping(PathRoute.USER_ADD)
    public Object addUser(@RequestParam("userName") @NotBlank(message = "用户名不能为空") String userName,
                          @RequestParam("userPassword") @NotBlank(message = "用户密码不能为空") String userPassword) {
        try {
            User user = new User();
            user.setUserName(userName);
            user.setUserPassword(userPassword);
            user.setCreateTime(new Date());
            user.setUpdateTime(new Date());
            user.setIsdelete(0);
            userService.insertAllColumn(user);
            return ResultResponse.success("添加用户成功", user.getId());
        } catch (Exception e) {
            logger.error("添加用户失败", e);
        }
        return ResultResponse.error("添加用户失败");
    }
}
