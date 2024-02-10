package htf.medmanager.service.impl;

import htf.medmanager.model.dto.MedicineDto;
import htf.medmanager.model.request.AddMedicineRequest;
import htf.medmanager.model.request.UpdateMedicineRequest;
import htf.medmanager.repository.dao.IMedicineDao;
import htf.medmanager.service.IMedicineService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MedicineServiceImpl implements IMedicineService {

    private final IMedicineDao medicineDao;

    public MedicineDto addMedicine(AddMedicineRequest request) {
        return MedicineDto.builder().build();
    }

    public MedicineDto updateMedicine(String medicineId, UpdateMedicineRequest request) {
        return MedicineDto.builder().build();
    }

    public MedicineDto getMedicine(String medicineId) {
        return MedicineDto.builder().build();
    }

    public List<MedicineDto> getMedicinesByUser(String userId) {
        return List.of();
    }

    public void deleteMedicine(String medicineId) {

    }
}
