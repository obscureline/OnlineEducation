package com.atguigu.educenter.service;

import com.atguigu.educenter.entity.UcenterMember;
import com.atguigu.educenter.entity.vo.RegisterVo;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 会员表 服务类
 */
public interface UcenterMemberService extends IService<UcenterMember> {

    //登录的方法
    String login(UcenterMember member);
    //注册的方法
    void register(RegisterVo registerVo);
    //根据openid判断
    UcenterMember getOpenIdMember(String openid);
}