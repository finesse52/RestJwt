package finesse52.restjwtproject.service.impl;


import finesse52.restjwtproject.domain.User;
import finesse52.restjwtproject.repository.UserRepository;
import finesse52.restjwtproject.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private UserRepository userRepository;

    @Override
    public User getUserByUsername(String username) {
        return userRepository.findByUsername(username).orElseThrow(() -> new UsernameNotFoundException("Username " + username + " not found"));
    }

    @Override
    public void save(UserRegistrationDto userRegistrationDto) {

    }

    @Override
    public boolean isUserExist(String username) {
        return false;
    }

    @Override
    public void setRoleAdmin(Long id) {

    }

    @Override
    public List<UserDto> getAllUsers() {
        return List.of();
    }
}
