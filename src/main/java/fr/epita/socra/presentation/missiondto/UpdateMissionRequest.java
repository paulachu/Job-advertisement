package fr.epita.socra.presentation.missiondto;

import io.smallrye.common.constraint.NotNull;
import lombok.*;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@With
@EqualsAndHashCode
public class UpdateMissionRequest {
    @NotNull
    private long id;

    @NotNull
    private String location;

    @NotNull
    private int duration;

    @NotNull
    private int price;

    @Min(value = 0, message = "Remote should not be negative")
    @Max(value = 1, message = "Remote should not be greater than 1")
    private float remote;

    @NotNull
    private Date beginning;

    @NotEmpty
    private String job;

    @NotEmpty
    private String context;

    @NotEmpty
    private String description;
}
