package finesse52.restjwtproject.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public abstract class BaseResponse {

    @Schema(description = "Status", example = "200")
    private Integer status;
    @Schema(description = "Timestamp", example = "2025-04-02")
    private final LocalDate timestamp = LocalDate.now();
}