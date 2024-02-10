package htf.medmanager.model.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
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
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class MedicineDetailsResponse implements Serializable {

    private static final long serialVersionUID = -1549671572131294306L;

    private String medicineId;
    private String drug;
    private String form;
    private String dosage;
    private String strength;
    private Integer duration;
    private List<Long> timestamps;
    private String userId;
}
