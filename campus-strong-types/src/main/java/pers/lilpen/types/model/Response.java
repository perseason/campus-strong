package pers.lilpen.types.model;

import lombok.*;

import java.io.Serializable;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Response<T> implements Serializable {

    private static final long serialVersionUID = 5130392244064623509L;

    private String code;
    private String info;
    private T data;

    @Getter
    public enum ResponseCode {
        SUCCESS("200", "success"),
        DENIED("403", "access denied"),
        ERROR("500", "server error");

        private String code;
        private String info;

        ResponseCode(String code, String info) {
            this.code = code;
            this.info = info;
        }

        public String getCode() {
            return code;
        }

        public String getInfo() {
            return info;
        }
    }
}