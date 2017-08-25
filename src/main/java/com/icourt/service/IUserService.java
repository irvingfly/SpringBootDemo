package com.icourt.service;

import com.icourt.entity.UserDO;

import java.util.List;

/**
 * @author  Zhangtengfei
 * @date 2017-8-23
 * 用户数据增删改查业务逻辑层接口
 */
public interface IUserService {
    /**
     * 新增用户
     * @param user 表示用户的一个实体
     */
    UserDO insertUser(UserDO user);
    /**
     * 删除🈷️用户
     * @param userId 根据用户Id删除用户
     */
     void deleteUser(Integer userId);
    /**
     * 修改用户信息
     * @param  user 根据user对象去更新用户信息
     */
    int updateUser(UserDO user);
    /**
     * 获取用户列表
     */
    List<UserDO> listUser();
    /**
     * 根据id查找用户信息
     * @param userId 根据用户Id查找一个用户信息
     */
    UserDO findUserById(Integer userId);
}
