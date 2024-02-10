package htf.medmanager.service;

import htf.medmanager.model.dto.MedicineDto;
import htf.medmanager.model.request.AddMedicineRequest;
import htf.medmanager.model.request.UpdateMedicineRequest;

import java.util.List;

public interface IMedicineService {

    MedicineDto addMedicine(AddMedicineRequest request);

    MedicineDto updateMedicine(String medicineId, UpdateMedicineRequest request);

    MedicineDto getMedicine(String medicineId);

    List<MedicineDto> getMedicinesByUser(String userId);

    void deleteMedicine(String medicineId);
}
