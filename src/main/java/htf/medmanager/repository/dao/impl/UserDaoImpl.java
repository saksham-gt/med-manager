package htf.medmanager.repository.dao.impl;

import htf.medmanager.repository.dao.IUserDao;
import htf.medmanager.repository.entity.UserEntity;
import org.springframework.stereotype.Repository;

@Repository
public class UserDaoImpl implements IUserDao {

    @Override
    public void save(UserEntity entity) {

    }

    @Override
    public void update(UserEntity entity) {

    }

    @Override
    public UserEntity findById(String userId) {
        return UserEntity.builder().build();
    }

    @Override
    public UserEntity findByMobileNumber(String mobileNumber) {
        return UserEntity.builder().build();
    }
}
