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
public class TimerDto implements Serializable {

    private static final long serialVersionUID = 1496320435541250379L;

    private Long breakfastTime;
    private Long lunchTime;
    private Long dinnerTime;
}
