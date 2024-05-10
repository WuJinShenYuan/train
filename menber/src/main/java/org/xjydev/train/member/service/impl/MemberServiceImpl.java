package org.xjydev.train.member.service.impl;

import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import org.xjydev.train.member.mapper.MemberMapper;
import org.xjydev.train.member.service.MemberService;

@Service
public class MemberServiceImpl implements MemberService {

    @Resource
    private MemberMapper memberMapper;

    public int count() {
        return memberMapper.count();
    }

}
