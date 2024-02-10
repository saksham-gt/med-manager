package htf.medmanager.adapter;

import htf.medmanager.model.dto.MedicineDto;
import htf.medmanager.model.response.MedicineDetailsResponse;
import htf.medmanager.repository.entity.MedicineEntity;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.Objects;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class MedicineAdapter {

    public static MedicineDto toMedicineDto(MedicineEntity medicineEntity) {
        if(Objects.isNull(medicineEntity)) {
            throw new RuntimeException("Medicine Entity not found!");
        }
        return MedicineDto.builder()
                .medicineId(medicineEntity.getMedicineId())
                .drug(medicineEntity.getDrug())
                .form(medicineEntity.getForm())
                .dosage(medicineEntity.getDosage())
                .duration(medicineEntity.getDuration())
                .strength(medicineEntity.getStrength())
                .status(medicineEntity.getStatus())
                .userId(medicineEntity.getUserId())
                .timestamps(medicineEntity.getTimestamps())
                .build();
    }

    public static MedicineEntity toMedicineEntity(MedicineDto medicineDto) {
        return MedicineEntity.builder()
                .medicineId(medicineDto.getMedicineId())
                .drug(medicineDto.getDrug())
                .form(medicineDto.getForm())
                .dosage(medicineDto.getDosage())
                .duration(medicineDto.getDuration())
                .strength(medicineDto.getStrength())
                .status(medicineDto.getStatus())
                .userId(medicineDto.getUserId())
                .timestamps(medicineDto.getTimestamps())
                .build();
    }

    public static MedicineDetailsResponse toMedicineDetailsResponse(MedicineDto medicineDto) {
        return MedicineDetailsResponse.builder()
                .medicineId(medicineDto.getMedicineId())
                .drug(medicineDto.getDrug())
                .form(medicineDto.getForm())
                .dosage(medicineDto.getDosage())
                .duration(medicineDto.getDuration())
                .strength(medicineDto.getStrength())
                .userId(medicineDto.getUserId())
                .timestamps(medicineDto.getTimestamps())
                .build();
    }
}
