package htf.medmanager.repository.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserEntity implements Serializable {

    private static final long serialVersionUID = 3091088722191612874L;

    @JsonProperty("id")
    private String userId;
    private String name;
    private Integer age;
    private String mobileNumber;
    private TimerEntity defaultTimers;
    private Boolean enableReminder;

    private Long createdAt;
    private Long updatedAt;
}

