package com.icourt.controller;

import com.icourt.entity.UserDO;
import com.icourt.service.IUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.models.auth.In;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * 针对用户操作请求做处理
 * @author irvingfly
 * @data 2017-8-23
 */
@RestController
@RequestMapping("/v1/users")
@Api("实现用户的增删该查操作")
public class UserController {

    @Autowired
    private IUserService iUserService;

    /**
     * 添加一个用户
     */
    @PostMapping("/")
    @ApiOperation(value = "实现用户的新增操作",notes = "简单的SpringBoot操作")
    public void insertUser(@RequestBody UserDO userDO){
        if(userDO != null){
            iUserService.insertUser(userDO);
        }
    }


    /**
     * 删除用户
     * @param userId  用户Id
     */
    @DeleteMapping("/{userId}")
    @ApiOperation("根据用户userId删除用户信息")
    public void deleteUser(@PathVariable("userId") Integer userId){
        if(userId != null) {
            iUserService.deleteUser(userId);
        }

    }

    /**
     * 修改用户信息
     * @param userDO  更新用户信息的实体类
     */
    @PutMapping("/")
    @ApiOperation("更新用户信息")
    public void updateUser(@RequestBody UserDO userDO){
    if(userDO != null){
        iUserService.updateUser(userDO);
        }
    }

    /**
     * 获取用户列表
     * @return 返回获取到的用户列表userDO
     */
    @GetMapping("/list")
    @ApiOperation("获取用户信息列表")
    public List<UserDO> listUser(){
        return iUserService.listUser();

    }

    /**
     * 获取单个用户
     * @return 返回根据Id获取的的那个用户信息
     */
    @ApiOperation("根据用户Id获取单个用户信息")
    @GetMapping("/{userId}")
    public UserDO findUserById(@PathVariable("userId") Integer userId){
        if(userId != null){
           return  iUserService.findUserById(userId);
        }
        return null;
    }
}
