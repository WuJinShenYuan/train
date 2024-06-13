package org.xjydev.train.member.service;

import org.xjydev.train.member.domain.Member;
import org.xjydev.train.member.resp.MemberLoginOrRegisterResp;

/**
 * Member服务层接口
 */
public interface MemberService {

    int count();

    long register(String mobile);

    String sendPhoneCode(String mobile);

    MemberLoginOrRegisterResp loginOrRegister(String mobile, String phoneCode);

    Member getByMobile(String mobile);
}
