package pers.lilpen.trigger.http;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import pers.lilpen.api.IUserService;
import pers.lilpen.api.dto.RegisterRequestDto;
import pers.lilpen.api.response.Response;
import pers.lilpen.domain.common.model.valobj.IdGeneratorType;
import pers.lilpen.domain.common.service.id.IdGenerator;

/**
 * @author : penghuaishun
 * @version : 1.0
 **/
@RestController("/user")
public class UserController implements IUserService {
    @Autowired
    public IdGenerator idGenerator;

    @Override
    @PostMapping("/register")
    public Response<RegisterRequestDto> register(RegisterRequestDto registerRequestDto) {
        String userId = idGenerator.generateId(IdGeneratorType.SNOWFLAKE);

        return null;
    }
}
