package htf.medmanager.repository.dao.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import htf.medmanager.client.INeureloClient;
import htf.medmanager.repository.dao.IMedicineDao;
import htf.medmanager.repository.entity.MedicineEntity;
import htf.medmanager.repository.entity.MedicineListEntity;
import htf.medmanager.repository.entity.response.MedicineResponseEntity;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
@AllArgsConstructor
public class MedicineDaoImpl implements IMedicineDao {

    private final INeureloClient neureloClient;
    private final String medicineUri = "/rest/medicine";
    private final ObjectMapper objectMapper = new ObjectMapper();
    @Override
    public MedicineEntity save(MedicineEntity entity) {
        Long epoch = System.currentTimeMillis();
        entity.setCreatedAt(epoch);
        entity.setUpdatedAt(epoch);
        try {
            String requestString = objectMapper.writeValueAsString(entity);
            return neureloClient.post(requestString, medicineUri, MedicineResponseEntity.class).getData();
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public MedicineEntity update(String medicineId, MedicineEntity entity) {
        Long epoch = System.currentTimeMillis();
        entity.setUpdatedAt(epoch);
        try {
            String requestString = objectMapper.writeValueAsString(entity);
            return neureloClient.patch(medicineId, medicineId, requestString, MedicineResponseEntity.class).getData();
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public MedicineEntity findById(String medicineId) {
        return neureloClient.get(medicineId, medicineUri, MedicineResponseEntity.class).getData();
    }

    @Override
    public List<MedicineEntity> findByUserId(String userId) {
        MedicineListEntity medicines =  neureloClient.get(medicineUri, MedicineListEntity.class,
                Map.of("filter", String.format("{\"userId\":{\"equals\":\"%s\"}}", userId)));
        return medicines.getData();
    }

    @Override
    public void delete(String medicineId) {
        neureloClient.delete(medicineId, medicineUri);
    }
}
