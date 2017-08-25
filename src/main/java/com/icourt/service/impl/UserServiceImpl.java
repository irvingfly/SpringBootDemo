package com.icourt.service.impl;

import com.icourt.entity.UserDO;
import com.icourt.repository.IUserReposity;
import com.icourt.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

/**
 * 用户增删改查业务逻辑层实现
 * @author Zhangtengfei
 * @date 2017-8-23
 */
@Service
public class UserServiceImpl implements IUserService {
    @Autowired
    private IUserReposity userReposity;
    @Override
    public UserDO insertUser(UserDO user) {

        return userReposity.save(user);
    }

    @Override
    public void deleteUser(Integer userId) {
        userReposity.delete(userId);
    }

    @Override
    @Transactional
    public int updateUser(UserDO user) {
        int a=userReposity.updateUserById(user.getUserName(),user.getAge(),user.getId());
        System.out.println(a+"asasasass");
        return a;
    }

    @Override
    public List<UserDO> listUser() {
        return userReposity.findAll();
    }

    @Override
    public UserDO findUserById(Integer id) {

        return userReposity.findOne(id);
    }
}
