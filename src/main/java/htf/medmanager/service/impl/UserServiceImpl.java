package htf.medmanager.service.impl;

import htf.medmanager.model.dto.UserDto;
import htf.medmanager.model.request.UpdateUserRequest;
import htf.medmanager.repository.dao.IUserDao;
import htf.medmanager.service.IUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements IUserService {

    private final IUserDao userDao;

    public UserDto createUser(String mobileNumber) {
        return UserDto.builder().build();
    }

    public UserDto updateUser(String userId, UpdateUserRequest request) {
        return UserDto.builder().build();
    }

    public UserDto getUserById(String userId) {
        return UserDto.builder().build();
    }

    public UserDto getUserByMobileNumber(String mobileNumber) {
        return UserDto.builder().build();
    }
}
