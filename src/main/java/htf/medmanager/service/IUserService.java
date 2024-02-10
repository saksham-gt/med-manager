package htf.medmanager.service;

import htf.medmanager.model.dto.UserDto;
import htf.medmanager.model.request.UpdateUserRequest;

public interface IUserService {

    UserDto createUser(String mobileNumber);

    UserDto updateUser(String userId, UpdateUserRequest request);

    UserDto getUserById(String userId);

    UserDto getUserByMobileNumber(String mobileNumber);
}
