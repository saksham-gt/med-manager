package htf.medmanager.repository.dao;

import htf.medmanager.repository.entity.UserEntity;

public interface IUserDao {
    UserEntity save(UserEntity entity);

    UserEntity update(String userId, UserEntity entity);

    UserEntity findById(String userId);

    UserEntity findByMobileNumber(String mobileNumber);
}
