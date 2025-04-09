package pers.lilpen.domain.user.model.valobj;

/**
 * @author : penghuaishun
 * @version : 1.0
 **/
public enum AuthTypeEnum {

    /**
     * 用户名密码登录
     */
    USERNAME_PASSWORD(1, "用户名密码登录"),

    /**
     * 短信验证码登录
     */
    SMS_CODE(2, "短信验证码登录"),

    /**
     * 邮箱验证码登录
     */
    EMAIL_CODE(3, "邮箱验证码登录"),

    /**
     * 微信登录
     */
    WECHAT(4, "微信登录"),

    /**
     * QQ登录
     */
    QQ(5, "QQ登录");

    private final int code;
    private final String desc;

    AuthTypeEnum(int code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public int getCode() {
        return code;
    }

    public String getDesc() {
        return desc;
    }
}
