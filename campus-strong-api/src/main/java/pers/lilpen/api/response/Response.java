package pers.lilpen.api.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.io.Serializable;

/**
 * @author : penghuaishun
 * @version : 1.0
 **/
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Response<T> implements Serializable {
    @Serial
    private static final long serialVersionUID = 7000723935764546321L;

    private String code;
    private String info;
    private T data;

    public static <T> Response<T> success(ResponseStatus responseStatus, T data) {
        return new Response<>(responseStatus.getCode(), responseStatus.getInfo(), data);
    }

    public static <T> Response<T> fail(ResponseStatus responseStatus, T data) {
        return new Response<>(responseStatus.getCode(), responseStatus.getInfo(), data);
    }
}
