package com.icourt.dao;

import com.icourt.entity.UserDO;

import java.util.List;

/**
 * 对数据库的操作
 * @autor Zhangtengfei
 * @date 2017-8-23
 */
public interface IUserDAO {

    /**
     * 增加用户
     */
    void insertUser(UserDO user);
    /**
     * 删除🈷️用户
     */
    void deleteUser(Integer id);
    /**
     * 修改用户信息
     */
    void updateUser(UserDO user);
    /**
     * 获取用户列表
     */
    List<UserDO> listUser();
    /**
     * 根据id查找用户信息
     */
    UserDO findUserById(Integer id);

}
