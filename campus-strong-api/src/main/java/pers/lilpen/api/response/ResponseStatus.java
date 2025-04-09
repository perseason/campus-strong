package pers.lilpen.api.response;

import lombok.Getter;

@Getter
public enum ResponseStatus {
    SUCCESS("200", "操作成功"),
    BAD_REQUEST("400", "请求参数错误"),
    UNAUTHORIZED("401", "未授权"),
    FORBIDDEN("403", "禁止访问"),
    NOT_FOUND("404", "资源未找到"),
    INTERNAL_SERVER_ERROR("500", "服务器内部错误");

    private final String code;
    private final String info;

    ResponseStatus(String code, String info) {
        this.code = code;
        this.info = info;
    }
}
