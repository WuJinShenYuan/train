package org.xjydev.train.member.controller;

import jakarta.annotation.Resource;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.xjydev.train.common.resp.CommonResp;
import org.xjydev.train.common.util.ReturnUtil;
import org.xjydev.train.member.req.MemberRegisterReq;
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

}
