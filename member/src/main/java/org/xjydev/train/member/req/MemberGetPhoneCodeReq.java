package org.xjydev.train.member.req;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

/**
 * 获取手机验证码请求参数类
 */
public class MemberGetPhoneCodeReq {

    @NotBlank(message = "【手机号】不能为空")
    @Pattern(regexp = "^1[3-9]\\d{9}$", message = "【手机号】格式不正确")
    private String mobile;

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    @Override
    public String toString() {
        return "MemberRegisterReq{" +
                "mobile='" + mobile + '\'' +
                '}';
    }
}
