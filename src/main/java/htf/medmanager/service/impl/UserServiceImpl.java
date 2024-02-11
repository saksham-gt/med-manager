package htf.medmanager.service.impl;

import htf.medmanager.adapter.UserAdapter;
import htf.medmanager.model.dto.UserDto;
import htf.medmanager.model.request.UpdateUserRequest;
import htf.medmanager.repository.dao.IUserDao;
import htf.medmanager.repository.entity.TimerEntity;
import htf.medmanager.repository.entity.UserEntity;
import htf.medmanager.service.IUserService;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements IUserService {

    private final IUserDao userDao;

    @Override
    public UserDto createUser(String mobileNumber) {
        UserEntity userEntity = UserEntity.builder()
                .mobileNumber(mobileNumber)
                .defaultTimers(TimerEntity.builder()
                        .breakfastTime(getMealTime(9, 0))
                        .dinnerTime(getMealTime(20, 30))
                        .lunchTime(getMealTime(14, 0))
                        .build())
                .enableReminder(Boolean.TRUE)
                .build();
        UserEntity entity = userDao.save(userEntity);
        return UserAdapter.toUserDto(entity);
    }

    @Override
    public UserDto updateUser(String userId, UpdateUserRequest request) {
        UserDto userDto = UserAdapter.toUserDto(userDao.findById(userId));
        UserEntity userEntity = UserEntity.builder()
                .mobileNumber(userDto.getMobileNumber())
                .age(Objects.isNull(request.getAge()) ? userDto.getAge() : request.getAge())
                .enableReminder(Objects.isNull(request.getEnableReminder()) ? userDto.getEnableReminder() : request.getEnableReminder())
                .name(StringUtils.isBlank(request.getName()) ? userDto.getName() : request.getName())
                .defaultTimers(Objects.isNull(request.getDefaultTimers()) ?
                        UserAdapter.toTimerEntity(userDto.getDefaultTimers()) : UserAdapter.toTimerEntity(request.getDefaultTimers()))
                .build();
        UserEntity entity = userDao.update(userId, userEntity);
        return UserAdapter.toUserDto(entity);
    }

    @Override
    public UserDto getUserById(String userId) {
        return UserAdapter.toUserDto(userDao.findById(userId));
    }

    @Override
    public UserDto getUserByMobileNumber(String mobileNumber) {
        return UserAdapter.toUserDto(userDao.findByMobileNumber(mobileNumber));
    }

    private Long getMealTime(int hour, int minute) {
        LocalDateTime dateTime = LocalDateTime.now().withHour(hour).withMinute(minute);
        return dateTime.toEpochSecond(ZoneOffset.ofHoursMinutes(5, 30));
    }
}
