package finesse52.restjwtproject.service;

import finesse52.restjwtproject.dto.UserDto;
import java.util.List;

public interface AdminService {

    void setAdmin(Long id);

    List<UserDto> getAllUsers();
}