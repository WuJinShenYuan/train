package org.xjydev.train.member.resp;

/**
 * 登录或注册响应参数类
 */
public class MemberLoginOrRegisterResp {

    private Long id;

    private String mobile;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    @Override
    public String toString() {
        return "MemberLoginOrRegisterResp{" +
                "id=" + id +
                ", mobile='" + mobile + '\'' +
                '}';
    }
}
