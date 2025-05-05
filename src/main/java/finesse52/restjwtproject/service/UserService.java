package finesse52.restjwtproject.service;

import finesse52.restjwtproject.domain.User;
import finesse52.restjwtproject.dto.UserDto;
import finesse52.restjwtproject.dto.UserRegistrationDto;
import java.util.List;

public interface UserService {

    User getUserByUsername(String username);

    void save(UserRegistrationDto userRegistrationDto);

    boolean isUserExist(String username);

    void setRoleAdmin(Long id);

    List<UserDto> getAllUsers();
}