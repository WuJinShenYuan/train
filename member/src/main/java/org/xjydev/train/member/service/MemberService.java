package org.xjydev.train.member.service;

/**
 * Member服务层接口
 */
public interface MemberService {

    int count();

    long register(String mobile);

    String createPhoneCode(String mobile);
}
