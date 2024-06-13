package org.xjydev.train.member.service.impl;

import cn.hutool.core.util.RandomUtil;
import jakarta.annotation.Resource;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.xjydev.train.common.exception.BusinessException;
import org.xjydev.train.common.exception.BusinessExceptionEnum;
import org.xjydev.train.common.util.SnowflakeUtil;
import org.xjydev.train.member.domain.Member;
import org.xjydev.train.member.domain.MemberExample;
import org.xjydev.train.member.mapper.MemberMapper;
import org.xjydev.train.member.resp.MemberLoginOrRegisterResp;
import org.xjydev.train.member.service.MemberService;

import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Member服务层实现类
 */
@Service
public class MemberServiceImpl implements MemberService {

    @Resource
    private MemberMapper memberMapper;

    @Resource
    private RedisTemplate<String, Object> redisTemplate;

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

    /**
     * 发送手机验证码
     *
     * @param mobile 手机号
     * @return 手机验证码
     */
    @Override
    public String sendPhoneCode(String mobile) {

        // 生成手机验证码
        String phoneCode = RandomUtil.randomNumbers(6);

        // 保存手机验证码到缓存
        String RedisKey = "phoneCode:" + mobile;
        redisTemplate.opsForValue().set(RedisKey, phoneCode, 5, TimeUnit.MINUTES);

        // TODO: 发送手机验证码到手机

        return phoneCode;
    }

    /**
     * 登录或者注册会员
     *
     * @param mobile    手机号
     * @param phoneCode 手机验证码
     * @return 是否登录或注册成功
     */
    @Override
    public MemberLoginOrRegisterResp loginOrRegister(String mobile, String phoneCode) {

        // 从缓存中获取手机验证码
        String RedisKey = "phoneCode:" + mobile;
        // TODO: 查看redis中是否有该手机号的验证码
//        if (Boolean.FALSE.equals(redisTemplate.hasKey(RedisKey))) {
//
//        }
        String redisPhoneCode = (String) redisTemplate.opsForValue().get(RedisKey);

        if (phoneCode.equals(redisPhoneCode)) {   // 比较手机验证码
            // 从数据库中查询会员
            Member member = getByMobile(mobile);

            // 如果会员不存在则注册会员
            if (member == null) {
                member = new Member();
                member.setId(SnowflakeUtil.getSnowflakeNextId());
                member.setMobile(mobile);
                memberMapper.insert(member);
            }

            // 返回会员ID
            MemberLoginOrRegisterResp resp = new MemberLoginOrRegisterResp();
            resp.setId(member.getId());
            resp.setMobile(member.getMobile());
            return resp;
        } else {
            throw new BusinessException(BusinessExceptionEnum.MEMBER_PHONE_CODE_ERROR);
        }
    }

    /**
     * 根据手机号查询会员
     *
     * @param mobile 手机号
     * @return 会员
     */
    @Override
    public Member getByMobile(String mobile) {
        MemberExample memberExample = new MemberExample();
        memberExample.createCriteria().andMobileEqualTo(mobile);
        List<Member> members = memberMapper.selectByExample(memberExample);
        if (members.isEmpty()) {
            return null;
        } else {
            return members.get(0);
        }
    }


}
