package org.xjydev.train.member.controller;

import jakarta.annotation.Resource;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.xjydev.train.common.resp.CommonResp;
import org.xjydev.train.common.util.ReturnUtil;
import org.xjydev.train.member.req.MemberGetPhoneCodeReq;
import org.xjydev.train.member.req.MemberLoginOrRegisterReq;
import org.xjydev.train.member.req.MemberRegisterReq;
import org.xjydev.train.member.resp.MemberLoginOrRegisterResp;
import org.xjydev.train.member.service.MemberService;

/**
 * Member控制层
 */
@RestController
@RequestMapping("/member")
public class MemberController {

    @Resource
    private MemberService memberService;

    /**
     * 统计会员数量
     *
     * @return 会员数量
     */
    @GetMapping("/count")
    public CommonResp<Integer> count() {
        int count = memberService.count();
        return ReturnUtil.success("查询成功", count);
    }

    /**
     * 注册会员
     *
     * @param req 注册会员请求参数
     * @return 会员ID
     */
    @PostMapping("/register")
    public CommonResp<Long> register(@Valid MemberRegisterReq req) {
        Long memberId = memberService.register(req.getMobile());
        return ReturnUtil.success("注册成功", memberId);
    }

    /**
     * 获取手机验证码
     *
     * @param req 获取手机验证码请求参数
     * @return 手机验证码
     */
    @PostMapping("/get-phone-code")
    public CommonResp<String> getPhoneCode(@Valid MemberGetPhoneCodeReq req) {
        String phoneCode = memberService.sendPhoneCode(req.getMobile());
        return ReturnUtil.success("获取成功", phoneCode);
    }

    /**
     * 登录或者注册会员
     *
     * @param req 登录或注册请求参数
     * @return 验证结果
     */
    @PostMapping("/login-or-register")
    public CommonResp<MemberLoginOrRegisterResp> loginOrRegister(@Valid MemberLoginOrRegisterReq req) {
        MemberLoginOrRegisterResp result = memberService.loginOrRegister(req.getMobile(), req.getPhoneCode());
        return ReturnUtil.success("登录或注册成功", result);

    }

}
