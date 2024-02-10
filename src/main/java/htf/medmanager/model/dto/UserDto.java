package htf.medmanager.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserDto implements Serializable {

    private static final long serialVersionUID = -546848051875879952L;

    private String userId;
    private String name;
    private Integer age;
    private String mobileNumber;
    private TimerDto defaultTimers;
    private Boolean enableReminder;
}
