package pers.lilpen.trigger.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * @author : penghuaishun
 * @version : 1.0
 **/
@Mapper
public class UserMapper {
    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    
}
