package htf.medmanager.model.request;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import htf.medmanager.model.dto.TimerDto;
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
public class UpdateUserRequest implements Serializable {

    private static final long serialVersionUID = -1467421103502409778L;

    private String name;
    private Integer age;
    private TimerDto defaultTimers;
    private Boolean enableReminder;
}
