package icu.uuqk.common.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Schema(name = "ErrorResponse", description = "异常相应对象")
public class ErrorResponseDto {

    @Schema(description = "请求路径")
    private String apiPath;

    @Schema(description = "异常状态码")
    private HttpStatus errorCode;

    @Schema(description = "异常信息")
    private String errorMsg;

    @Schema(description = "异常时刻")
    private LocalDateTime errorTime;

}
