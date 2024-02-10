package htf.medmanager.repository.dao;

import htf.medmanager.repository.entity.MedicineEntity;

import java.util.List;

public interface IMedicineDao {

    void save(MedicineEntity entity);

    void update(MedicineEntity entity);

    MedicineEntity findById(String medicineId);

    List<MedicineEntity> findByUserId(String userId);
}
