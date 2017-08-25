package com.icourt.service;

import com.icourt.DemoApplication;
import com.icourt.entity.UserDO;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;

/**
 * 业务逻辑层功能测试类
 * @author Zhangtengfei
 * @date 2017-8-24
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = DemoApplication.class)
public class IUserServiceTest {
    @Autowired
    private IUserService iUserService;

    /**
     * 测试添加用户方法是否能添加成功
     * @throws Exception
     */
    @Test
    public void insertUser() throws Exception {
        UserDO userDO=new UserDO();
        userDO.setUserName("ZhangTengfei");
        userDO.setAge(12);
        UserDO newUserDO=iUserService.insertUser(userDO);
        boolean flag1=newUserDO.getAge().equals(userDO.getAge());
        boolean flag2=newUserDO.getUserName().equals(userDO.getUserName());
        assertTrue("添加成功",flag1&&flag2);
        assertFalse(" 添加失败",!flag1&&flag2);
    }

    /**
     * 测试删除用户的方法
     * @throws Exception
     */
    @Test
    public void deleteUser() throws Exception {
        iUserService.deleteUser(31);
    }

    /**
     * 测试更新用户信息的方法
     * @throws Exception
     */
    @Test
    public void updateUser() throws Exception {
        UserDO userDO=new UserDO();
        userDO.setId(30);
        userDO.setUserName("change");
        userDO.setAge(21);
        int index =iUserService.updateUser(userDO);
        System.out.println(index+"UserID");
        assertTrue("更新成功",index>0);
    }

    /**
     * 测试获取用户列表的方法
     * @throws Exception
     */
    @Test
    public void listUser() throws Exception {
        List<UserDO>  userDOList=iUserService.listUser();
        Assert.assertTrue("有数据返回"+userDOList.size(),userDOList.size()>0);
    }

    /**
     * 测试根据Id查找用户信息的方法
     * @throws Exception
     */
    @Test
    public void findUserById() throws Exception {
        UserDO userDO=iUserService.findUserById(30);
        assertTrue("查到数据",userDO!=null);
    }

}