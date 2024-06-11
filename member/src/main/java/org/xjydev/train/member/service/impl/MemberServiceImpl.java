package org.xjydev.train.member.service.impl;

import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import org.xjydev.train.common.exception.BusinessException;
import org.xjydev.train.common.exception.BusinessExceptionEnum;
import org.xjydev.train.common.util.SnowflakeUtil;
import org.xjydev.train.member.domain.Member;
import org.xjydev.train.member.domain.MemberExample;
import org.xjydev.train.member.mapper.MemberMapper;
import org.xjydev.train.member.service.MemberService;

/**
 * Member服务层实现类
 */
@Service
public class MemberServiceImpl implements MemberService {

    @Resource
    private MemberMapper memberMapper;


    /**
     * 统计会员数量
     *
     * @return 会员数量
     */
    @Override
    public int count() {
        return (int) memberMapper.countByExample(null);
    }

    /**
     * 注册会员
     *
     * @param mobile 手机号
     * @return 会员ID
     */
    @Override
    public long register(String mobile) {
        MemberExample memberExample = new MemberExample();
        memberExample.createCriteria().andMobileEqualTo(mobile);
        if (memberMapper.countByExample(memberExample) > 0) {
            throw new BusinessException(BusinessExceptionEnum.MEMBER_MOBILE_EXIST);
        }

        Member member = new Member();
        member.setId(SnowflakeUtil.getSnowflakeNextId());
        member.setMobile(mobile);
        memberMapper.insert(member);
        return member.getId();
    }

}
