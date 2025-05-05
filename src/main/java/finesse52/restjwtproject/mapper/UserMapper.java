package finesse52.restjwtproject.mapper;

import finesse52.restjwtproject.domain.User;
import finesse52.restjwtproject.dto.UserDto;
import finesse52.restjwtproject.dto.UserRegistrationDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE, uses = BaseMapper.class)
public interface UserMapper {

    User convertToDomain(UserRegistrationDto userRegistrationDto);

    @Mapping(target = "role", source = "user.role.name")
    UserDto convertToDto(User user);
}