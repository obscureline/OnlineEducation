package com.atguigu.eduservice.controller;

import com.atguigu.commonutils.R;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@Api(description = "教师登录管理")
@RequestMapping("/eduservice/user")
@CrossOrigin//解决跨域
public class EduLoginController {

    //登录
    @PostMapping("login")
    public R login() {
        return R.ok().data("token","admin");
    }

    //获取信息
    @GetMapping("info")
    public R info() {
        return R.ok()
                .data("roles","[admin]")
                .data("name","admin")
                .data("avatar","https://wpimg.wallstcn.com/f778738c-e4f8-4870-b634-56703b4acafe.gif");
    }
}