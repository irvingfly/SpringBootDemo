package com.icourt.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import jdk.nashorn.internal.objects.annotations.Getter;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 根据这个Controller可以查看swagger接口文档
 * @author Zhangtengfei
 * @date 2017-8-23
 */
@RestController
@Api("查看文档路径为：http://127.0.0.1:8099/swagger")
public class HomeController {

    @GetMapping("/swagger")
    @ApiOperation("获取swagger接口文档")
    public void index(HttpServletResponse response) {
        System.out.println("");
        try {
            response.sendRedirect("swagger-ui.html");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}