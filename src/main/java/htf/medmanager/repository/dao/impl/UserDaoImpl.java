package htf.medmanager.repository.dao.impl;

import htf.medmanager.repository.dao.IUserDao;
import htf.medmanager.repository.entity.UserEntity;
import org.springframework.stereotype.Repository;

@Repository
public class UserDaoImpl implements IUserDao {

    public void save(UserEntity entity) {

    }

    public UserEntity findById(String userId) {
        return UserEntity.builder().build();
    }
}
