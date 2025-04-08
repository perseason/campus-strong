package pers.lilpen.api;

import pers.lilpen.api.dto.RegisterRequestDto;
import pers.lilpen.api.response.Response;

public interface IUserService {
    Response<RegisterRequestDto> register(RegisterRequestDto registerRequestDto);
}