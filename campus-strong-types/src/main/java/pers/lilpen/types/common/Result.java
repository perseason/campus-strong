package pers.lilpen.types.common;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author : penghuaishun
 * @version : 1.0
 **/
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Result<T> {
    private boolean success;
    private T data;

    public static <T> Result<T> success(T data) {
        return new Result<>(Boolean.TRUE, data);
    }

    public static <T> Result<T> fail(T data) {
        return new Result<>(Boolean.TRUE, data);
    }
}
