package htf.medmanager.adapter;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import htf.medmanager.model.dto.UserDto;
import htf.medmanager.model.response.UserDetailsResponse;
import htf.medmanager.repository.entity.UserEntity;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class UserAdapter {

    public static UserDto toUserDto(UserEntity userEntity) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        String json = objectMapper.writeValueAsString(userEntity);
        return objectMapper.readValue(json, UserDto.class);
    }

    public static UserEntity toUserEntity(UserDto userDto) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        String json = objectMapper.writeValueAsString(userDto);
        return objectMapper.readValue(json, UserEntity.class);
    }

    public static UserDetailsResponse toUserDetailsResponse(UserDto userDto) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        String json = objectMapper.writeValueAsString(userDto);
        return objectMapper.readValue(json, UserDetailsResponse.class);
    }

}
