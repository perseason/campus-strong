package pers.lilpen.api.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author : penghuaishun
 * @version : 1.0
 **/
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RegisterRequestDto {
    private String userId;
    private String username;
    private String password;
    private List<String> roles;
    private String location;
}
