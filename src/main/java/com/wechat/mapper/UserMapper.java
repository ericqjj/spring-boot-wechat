package com.wechat.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.wechat.entity.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * Created by hztps on 2017/5/11.
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {
}
