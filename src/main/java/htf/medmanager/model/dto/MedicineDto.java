package htf.medmanager.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MedicineDto implements Serializable {

    private static final long serialVersionUID = -8901391365156011913L;

    private String medicineId;
    private String drug;
    private String form;
    private String dosage;
    private String strength;
    private Integer duration;
    private List<Long> timestamps;
    private String userId;
    private String status;
}
