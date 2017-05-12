package com.wechat.entity;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by hztps on 2017/5/11.
 */
@SuppressWarnings("serial")
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("wechat_user")
public class User extends Model<User> {

    @TableId
    private String id;

    private String userName;

    private String userPassword;

    private Date createTime;

    private Date updateTime;

    private Integer isdelete;

    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", userName='" + userName + '\'' +
                ", userPassword='" + userPassword + '\'' +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                ", isdelete=" + isdelete +
                '}';
    }

    @Override
    protected Serializable pkVal() {
        return null;
    }
}
