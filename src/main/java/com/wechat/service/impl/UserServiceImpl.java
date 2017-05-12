package com.wechat.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.wechat.entity.User;
import com.wechat.mapper.UserMapper;
import com.wechat.service.UserService;
import org.springframework.stereotype.Service;

/**
 * Created by hztps on 2017/5/11.
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
}
