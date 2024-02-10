package htf.medmanager.model.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import htf.medmanager.repository.entity.TimerEntity;
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
public class UserDetailsResponse implements Serializable {

    private static final long serialVersionUID = -900089187024012573L;

    private String userId;
    private String name;
    private Integer age;
    private TimerEntity timerEntity;
    private Boolean enableReminder;

}
