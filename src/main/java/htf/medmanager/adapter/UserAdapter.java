package htf.medmanager.adapter;

import htf.medmanager.model.dto.TimerDto;
import htf.medmanager.model.dto.UserDto;
import htf.medmanager.model.response.UserDetailsResponse;
import htf.medmanager.repository.entity.TimerEntity;
import htf.medmanager.repository.entity.UserEntity;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.Objects;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class UserAdapter {

    public static UserDto toUserDto(UserEntity userEntity) {
        if(Objects.isNull(userEntity)) {
            throw new RuntimeException("UserEntity Not Found!");
        }
        return UserDto.builder()
                .userId(userEntity.getUserId())
                .name(userEntity.getName())
                .age(userEntity.getAge())
                .defaultTimers(toTimerDto(userEntity.getDefaultTimers()))
                .enableReminder(userEntity.getEnableReminder())
                .mobileNumber(userEntity.getMobileNumber())
                .build();
    }

    public static UserEntity toUserEntity(UserDto userDto) {
        return UserEntity.builder()
                .userId(userDto.getUserId())
                .name(userDto.getName())
                .age(userDto.getAge())
                .defaultTimers(toTimerEntity(userDto.getDefaultTimers()))
                .enableReminder(userDto.getEnableReminder())
                .mobileNumber(userDto.getMobileNumber())
                .build();
    }

    public static UserDetailsResponse toUserDetailsResponse(UserDto userDto) {
        return UserDetailsResponse.builder()
                .userId(userDto.getUserId())
                .name(userDto.getName())
                .age(userDto.getAge())
                .defaultTimers(userDto.getDefaultTimers())
                .enableReminder(userDto.getEnableReminder())
                .mobileNumber(userDto.getMobileNumber())
                .build();
    }

    public static TimerEntity toTimerEntity(TimerDto timerDto) {
        return TimerEntity.builder()
                .breakfastTime(timerDto.getBreakfastTime())
                .dinnerTime(timerDto.getDinnerTime())
                .lunchTime(timerDto.getLunchTime())
                .build();
    }

    public static TimerDto toTimerDto(TimerEntity timerEntity) {
        return TimerDto.builder()
                .breakfastTime(timerEntity.getBreakfastTime())
                .dinnerTime(timerEntity.getDinnerTime())
                .lunchTime(timerEntity.getLunchTime())
                .build();
    }

}
