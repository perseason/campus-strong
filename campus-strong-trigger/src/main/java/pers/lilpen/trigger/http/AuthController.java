package pers.lilpen.trigger.http;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import pers.lilpen.api.IUserService;
import pers.lilpen.api.dto.LoginRequestDto;
import pers.lilpen.api.dto.LoginResponseDto;
import pers.lilpen.api.dto.RegisterRequestDto;
import pers.lilpen.api.dto.RegisterResponseDto;
import pers.lilpen.api.response.Response;
import pers.lilpen.api.response.ResponseStatus;
import pers.lilpen.domain.common.model.valobj.IdGeneratorType;
import pers.lilpen.domain.common.service.id.IdGenerator;
import pers.lilpen.domain.user.model.entity.UserEntity;
import pers.lilpen.domain.user.model.valobj.RoleTypeEnum;
import pers.lilpen.domain.user.service.auth.IAuthService;
import pers.lilpen.types.common.Result;

/**
 * @author : penghuaishun
 * @version : 1.0
 **/
@RestController("/auth")
public class AuthController implements IUserService {
    @Autowired
    public IdGenerator idGenerator;
    @Autowired
    public IAuthService authService;

    @Override
    @PostMapping("/register")
    public Response<RegisterResponseDto> register(RegisterRequestDto registerRequestDto) {
        String idStr = idGenerator.generateId(IdGeneratorType.SNOWFLAKE);
        long id = Long.parseLong(idStr);
        UserEntity userEntity = UserEntity.builder()
                .id(id)
                .userId(registerRequestDto.getUserId())
                .username(registerRequestDto.getUsername())
                .password(registerRequestDto.getPassword())
                .roles(registerRequestDto.getRoles().stream().map(RoleTypeEnum::valueOf).toList())
                .build();
        Result<UserEntity> registerRes = authService.register(userEntity);
        if (!registerRes.isSuccess()) {
            return Response.fail(ResponseStatus.INTERNAL_SERVER_ERROR, null);
        }
        RegisterResponseDto registerResponseDto = RegisterResponseDto.builder()
//                .userId()
                .build();
        return Response.success(ResponseStatus.SUCCESS, registerResponseDto);
    }

    @Override
    @PostMapping("/login")
    public Response<LoginResponseDto> login(LoginRequestDto loginRequestDto) {
        Result<UserEntity> loginRes = authService.login(loginRequestDto.getUserId(), loginRequestDto.getPassword());
        if (!loginRes.isSuccess()) {
            return Response.fail(ResponseStatus.INTERNAL_SERVER_ERROR, null);
        }
        UserEntity userEntity = loginRes.getData();
        return Response.success(ResponseStatus.SUCCESS, new LoginResponseDto(userEntity.getUserId(), userEntity.getUsername()));
    }
}
