package org.xjydev.train.member.req;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

/**
 * 登录或注册请求参数类
 */
public class MemberLoginOrRegisterReq {

    @NotBlank(message = "【手机号】不能为空")
    @Pattern(regexp = "^1[3-9]\\d{9}$", message = "【手机号】格式不正确")
    private String mobile;

    @NotBlank(message = "【手机验证码】不能为空")
    @Pattern(regexp = "^\\d{6}$", message = "【手机验证码】格式不正确")
    private String phoneCode;

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getPhoneCode() {
        return phoneCode;
    }

    public void setPhoneCode(String phoneCode) {
        this.phoneCode = phoneCode;
    }

    @Override
    public String toString() {
        return "MemberLoginOrRegisterReq{" +
                "mobile='" + mobile + '\'' +
                ", phoneCode='" + phoneCode + '\'' +
                '}';
    }
}
