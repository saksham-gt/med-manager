package htf.medmanager.repository.dao;

import htf.medmanager.repository.entity.UserEntity;

public interface IUserDao {
    void save(UserEntity entity);

    UserEntity findById(String userId);
}
