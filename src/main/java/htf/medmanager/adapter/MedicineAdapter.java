package htf.medmanager.adapter;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import htf.medmanager.model.dto.MedicineDto;
import htf.medmanager.model.response.MedicineDetailsResponse;
import htf.medmanager.repository.entity.MedicineEntity;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class MedicineAdapter {

    public static MedicineDto toMedicineDto(MedicineEntity medicineEntity) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        String json = objectMapper.writeValueAsString(medicineEntity);
        return objectMapper.readValue(json, MedicineDto.class);
    }

    public static MedicineEntity toMedicineEntity(MedicineDto medicineDto) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        String json = objectMapper.writeValueAsString(medicineDto);
        return objectMapper.readValue(json, MedicineEntity.class);
    }

    public static MedicineDetailsResponse toMedicineDetailsResponse(MedicineDto medicineDto) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        String json = objectMapper.writeValueAsString(medicineDto);
        return objectMapper.readValue(json, MedicineDetailsResponse.class);
    }
}
