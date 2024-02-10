package htf.medmanager.repository.dao.impl;

import htf.medmanager.repository.dao.IMedicineDao;
import htf.medmanager.repository.entity.MedicineEntity;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class MedicineDaoImpl implements IMedicineDao {
    @Override
    public void save(MedicineEntity entity) {
        Long epoch = System.currentTimeMillis();
        entity.setCreatedAt(epoch);
        entity.setUpdatedAt(epoch);

    }

    @Override
    public void update(MedicineEntity entity) {
        Long epoch = System.currentTimeMillis();
        entity.setUpdatedAt(epoch);

    }

    @Override
    public MedicineEntity findById(String medicineId) {
        return MedicineEntity.builder().build();
    }

    @Override
    public List<MedicineEntity> findByUserId(String userId) {
        return List.of();
    }
}
