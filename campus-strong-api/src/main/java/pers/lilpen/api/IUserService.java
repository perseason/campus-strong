package pers.lilpen.api;

import pers.lilpen.api.dto.LoginRequestDto;
import pers.lilpen.api.dto.LoginResponseDto;
import pers.lilpen.api.dto.RegisterRequestDto;
import pers.lilpen.api.dto.RegisterResponseDto;
import pers.lilpen.api.response.Response;

public interface IUserService {
    Response<RegisterResponseDto> register(RegisterRequestDto registerRequestDto);

    Response<LoginResponseDto> login(LoginRequestDto loginRequestDto);
}