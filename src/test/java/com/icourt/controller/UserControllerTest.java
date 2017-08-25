package com.icourt.controller;

import com.fasterxml.jackson.databind.util.JSONPObject;
import com.icourt.DemoApplication;
import com.icourt.entity.UserDO;
import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = DemoApplication.class)
@AutoConfigureMockMvc
public class UserControllerTest {
    @Autowired
    private MockMvc mvc;

    /**
     * 添加用户请求测试
     *
     * @throws Exception
     */
    @Test
    public void insertUser() throws Exception {

        JSONObject jsonObject=new JSONObject();
        jsonObject.put("userName","wangwu");
        jsonObject.put("age",12);

        MvcResult mvcResult = mvc.perform(
                MockMvcRequestBuilders.post("/v1/users/")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(jsonObject.toString()))
                        .andReturn();

        int status = mvcResult.getResponse().getStatus();
        String content = mvcResult.getResponse().getContentAsString();
        Assert.assertTrue("正确", status == 200);
        Assert.assertFalse("错误", status != 200);
        System.out.println("返回结果：" + status);
        System.out.println(content);
        System.out.println(jsonObject.toString());
    }

    /**
     * 删除用户请求
     *
     * @throws Exception
     */
    @Test
    public void deleteUser() throws Exception {
        //删除id为33的用户
        MvcResult result = mvc.perform(MockMvcRequestBuilders.delete("/v1/users/33")).andReturn();
        System.out.println(result.getResponse().getContentAsString());
        assertTrue("删除成功", result.getResponse().getStatus() == 200);
        assertFalse("删除失败", result.getResponse().getStatus() != 200);

    }

    /**
     * 更新用户请求
     *
     * @throws Exception
     */
    @Test
    public void updateUser() throws Exception {
        JSONObject jsonObject=new JSONObject();
        jsonObject.put("id",32);
        jsonObject.put("userName","asasas");
        jsonObject.put("age",12);
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders
                .put("/v1/users/")
                .content(jsonObject.toString())
                .contentType(MediaType.APPLICATION_JSON))
                .andReturn();
        System.out.println(mvcResult.getResponse().getContentAsString());
        assertTrue("更新成功", mvcResult.getResponse().getStatus() == 200);
        assertFalse("更新失败", mvcResult.getResponse().getStatus() != 200);

    }

    /**
     * 获取用户列表请求
     *
     * @throws Exception
     */

    @Test
    public void listUser() throws Exception {
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get("/v1/users/list")).andReturn();
        System.out.println(mvcResult.getResponse().getContentAsString());
        assertTrue("查询成功",mvcResult.getResponse().getStatus()==200);
        assertFalse("查询失败",mvcResult.getResponse().getStatus()!=200);
    }

    /**
     * 获取单个用户信息请求
     *
     * @throws Exception
     */
    @Test
    public void findUserById() throws Exception {
        MvcResult result = mvc.perform(MockMvcRequestBuilders.get("/v1/users/10"))
                .andExpect(MockMvcResultMatchers.status()
                .isOk())
                .andReturn();
        System.out.println(result.getResponse().getContentAsString());
        assertTrue(" 查询成功", result.getResponse().getStatus() == 200);
        assertFalse(" 查询失败", result.getResponse().getStatus() != 200);
    }

}