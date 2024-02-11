package htf.medmanager.controller;

import htf.medmanager.adapter.MedicineAdapter;
import htf.medmanager.model.dto.MedicineDto;
import htf.medmanager.model.request.AddMedicineRequest;
import htf.medmanager.model.request.AddPrescriptionRequest;
import htf.medmanager.model.request.UpdateMedicineRequest;
import htf.medmanager.model.response.MedicineDetailsResponse;
import htf.medmanager.service.IMedicineService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import jakarta.validation.constraints.NotBlank;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RequestMapping("/v1/medicine")
@RestController
@RequiredArgsConstructor
public class MedicineController {

    private final IMedicineService medicineService;

    @Operation(summary = "Add Medicine")
    @ApiResponse(responseCode = "201", description = "Medicine Added Successfully",
            content = @Content(mediaType = "application/json"))
    @PostMapping(value = "/")
    public ResponseEntity<MedicineDetailsResponse> addMedicine(@RequestBody AddMedicineRequest request) {
        MedicineDto medicineDto = medicineService.addMedicine(request);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(MedicineAdapter.toMedicineDetailsResponse(medicineDto));
    }

    @Operation(summary = "Add Prescription")
    @ApiResponse(responseCode = "201", description = "Prescription Added Successfully",
            content = @Content(mediaType = "application/json"))
    @PostMapping(value = "/bulk/")
    public ResponseEntity<List<MedicineDetailsResponse>> addPrescription(@RequestBody AddPrescriptionRequest request) {
        List<MedicineDto> medicines = request.getMedicines().stream().map(medicineService::addMedicine).toList();
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(medicines.stream().map(MedicineAdapter::toMedicineDetailsResponse).toList());
    }

    @Operation(summary = "Update Medicine")
    @ApiResponse(responseCode = "200", description = "Medicine Update Successfully",
            content = @Content(mediaType = "application/json"))
    @PatchMapping(value = "/{id}")
    public ResponseEntity<MedicineDetailsResponse> updateMedicine(@PathVariable("id") String medicineId,
                                                          @RequestBody UpdateMedicineRequest request) {
        MedicineDto medicineDto = medicineService.updateMedicine(medicineId, request);
        return ResponseEntity.ok()
                .body(MedicineAdapter.toMedicineDetailsResponse(medicineDto));
    }

    @Operation(summary = "Get Medicine By Id")
    @ApiResponse(responseCode = "200", description = "Medicine Found Successfully",
            content = @Content(mediaType = "application/json"))
    @ApiResponse(responseCode = "404", description = "Medicine Not Found",
            content = @Content(mediaType = "application/json"))
    @GetMapping(value = "/{id}")
    public ResponseEntity<MedicineDetailsResponse> getMedicine(@PathVariable("id") String medicineId) {
        MedicineDto medicineDto = medicineService.getMedicine(medicineId);
        return ResponseEntity.ok()
                .body(MedicineAdapter.toMedicineDetailsResponse(medicineDto));
    }

    @Operation(summary = "Get Medicine By User")
    @ApiResponse(responseCode = "200", description = "Medicines By User Found Successfully",
            content = @Content(mediaType = "application/json"))
    @GetMapping(value = "/user/{userId}")
    public ResponseEntity<List<MedicineDetailsResponse>> getMedicineByUser(@PathVariable("userId") String userId) {
        List<MedicineDto> medicineList = medicineService.getMedicinesByUser(userId);
        return ResponseEntity.ok()
                .body(medicineList.stream().map(MedicineAdapter::toMedicineDetailsResponse).toList());
    }

    @Operation(summary = "Delete Medicine")
    @ApiResponse(responseCode = "204", description = "Medicines Deleted Successfully",
            content = @Content(mediaType = "application/json"))
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<List<MedicineDetailsResponse>> deleteMedicine(@PathVariable("id") String medicineId) {
        medicineService.deleteMedicine(medicineId);
        return ResponseEntity.ok().build();
    }


}
