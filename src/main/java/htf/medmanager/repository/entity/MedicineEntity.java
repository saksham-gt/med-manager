package htf.medmanager.repository.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
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
public class MedicineEntity implements Serializable {

    private static final long serialVersionUID = 2484564858142272242L;

    @JsonProperty("id")
    private String medicineId;
    private String drug;
    private String form;
    private String dosage;
    private String strength;
    private Integer duration;
    private List<Long> timestamps;
    private String userId;
    private String status;

    private Long createdAt;
    private Long updatedAt;

}
