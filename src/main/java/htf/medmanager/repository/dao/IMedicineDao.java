package htf.medmanager.repository.dao;

import htf.medmanager.repository.entity.MedicineEntity;

import java.util.List;

public interface IMedicineDao {

    MedicineEntity save(MedicineEntity entity);

    MedicineEntity update(String medicineId, MedicineEntity entity);

    MedicineEntity findById(String medicineId);

    List<MedicineEntity> findByUserId(String userId);

    void delete(String medicineId);
}
