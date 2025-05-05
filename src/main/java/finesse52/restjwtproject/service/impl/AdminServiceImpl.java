package finesse52.restjwtproject.service.impl;

import finesse52.restjwtproject.dto.UserDto;
import finesse52.restjwtproject.service.AdminService;
import finesse52.restjwtproject.service.UserService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AdminServiceImpl implements AdminService {

    private final UserService userService;

    @Override
    public void setAdmin(Long id) {
        userService.setRoleAdmin(id);
    }

    @Override
    public List<UserDto> getAllUsers() {
        return userService.getAllUsers();
    }
}