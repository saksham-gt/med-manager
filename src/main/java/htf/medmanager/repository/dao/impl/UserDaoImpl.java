package htf.medmanager.repository.dao.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import htf.medmanager.client.INeureloClient;
import htf.medmanager.repository.dao.IUserDao;
import htf.medmanager.repository.entity.MedicineListEntity;
import htf.medmanager.repository.entity.UserEntity;
import htf.medmanager.repository.entity.UserListEntity;
import htf.medmanager.repository.entity.response.UserResponseEntity;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import java.net.http.HttpResponse;
import java.util.Map;

@Repository
@AllArgsConstructor
public class UserDaoImpl implements IUserDao {

    private final INeureloClient neureloClient;
    private final String userURI = "/rest/user";
    private final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public UserEntity save(UserEntity entity) {
        Long epoch = System.currentTimeMillis();
        entity.setCreatedAt(epoch);
        entity.setUpdatedAt(epoch);
        try {
            String requestString = objectMapper.writeValueAsString(entity);
            System.out.println("USER TO BE SAVED - " + requestString);
            return neureloClient.post(requestString, userURI, UserResponseEntity.class).getData();
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public UserEntity update(String userId, UserEntity entity) {
        Long epoch = System.currentTimeMillis();
        entity.setUpdatedAt(epoch);
        try {
            String requestString = objectMapper.writeValueAsString(entity);
            return neureloClient.patch(userId, userURI, requestString, UserResponseEntity.class).getData();
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public UserEntity findById(String userId) {
        return neureloClient.get(userId, userURI, UserResponseEntity.class).getData();
    }

    @Override
    public UserEntity findByMobileNumber(String mobileNumber) {
        UserListEntity users =  neureloClient.get(userURI, UserListEntity.class,
                Map.of("mobileNumber.equals", mobileNumber));
        if(users.getData().size() > 1) {
            throw new RuntimeException("Multiple Users with Same Mobile Number");
        }
        return users.getData().get(0);
    }
}
