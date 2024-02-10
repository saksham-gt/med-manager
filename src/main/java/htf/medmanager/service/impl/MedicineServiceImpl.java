package htf.medmanager.service.impl;

import htf.medmanager.adapter.MedicineAdapter;
import htf.medmanager.model.dto.MedicineDto;
import htf.medmanager.model.request.AddMedicineRequest;
import htf.medmanager.model.request.UpdateMedicineRequest;
import htf.medmanager.repository.dao.IMedicineDao;
import htf.medmanager.repository.entity.MedicineEntity;
import htf.medmanager.service.IMedicineService;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class MedicineServiceImpl implements IMedicineService {

    private final IMedicineDao medicineDao;

    @Override
    public MedicineDto addMedicine(AddMedicineRequest request) {
        MedicineDto medicineDto = MedicineDto.builder()
                .status("ACTIVE")
                .drug(request.getDrug())
                .form(request.getForm())
                .dosage(request.getDosage())
                .strength(request.getStrength())
                .duration(request.getDuration())
                .timestamps(request.getTimestamps())
                .userId(request.getUserId())
                .build();
        MedicineEntity entity = medicineDao.save(MedicineAdapter.toMedicineEntity(medicineDto));
        return MedicineAdapter.toMedicineDto(entity);
    }

    @Override
    public MedicineDto updateMedicine(String medicineId, UpdateMedicineRequest request) {
        MedicineDto medicineDto = MedicineAdapter.toMedicineDto(medicineDao.findById(medicineId));
        MedicineDto updatedDto = MedicineDto.builder()
                .status(medicineDto.getStatus())
                .userId(medicineDto.getUserId())
                .drug(StringUtils.isBlank(request.getDrug()) ? medicineDto.getDrug() : request.getDrug())
                .form(StringUtils.isBlank(request.getForm()) ? medicineDto.getForm() : request.getForm())
                .dosage(StringUtils.isBlank(request.getDosage()) ? medicineDto.getDosage() : request.getDosage())
                .strength(StringUtils.isBlank(request.getStrength()) ? medicineDto.getStrength() : request.getStrength())
                .duration(Objects.isNull(request.getDuration()) ? medicineDto.getDuration() : request.getDuration())
                .timestamps(Objects.isNull(request.getTimestamps()) ? medicineDto.getTimestamps() : request.getTimestamps())
                .build();

        MedicineEntity entity = medicineDao.update(medicineId, MedicineAdapter.toMedicineEntity(updatedDto));
        return MedicineAdapter.toMedicineDto(entity);
    }

    @Override
    public MedicineDto getMedicine(String medicineId) {
        return MedicineAdapter.toMedicineDto(medicineDao.findById(medicineId));
    }

    @Override
    public List<MedicineDto> getMedicinesByUser(String userId) {
        List<MedicineEntity> medicineEntities = medicineDao.findByUserId(userId);
        return medicineEntities.stream().map(MedicineAdapter::toMedicineDto).toList();
    }

    @Override
    public void deleteMedicine(String medicineId) {
        medicineDao.delete(medicineId);
    }
}
