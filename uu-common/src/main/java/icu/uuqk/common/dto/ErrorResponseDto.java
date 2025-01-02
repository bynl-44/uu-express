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
@Schema(name = "ErrorResponseDto", description = "异常相应对象")
public class ErrorResponseDto {

    @Schema(description = "请求路径", example = "/api/v1/users")
    private String apiPath;

    @Schema(description = "异常状态码", example = "500")
    private HttpStatus errorCode;

    @Schema(description = "异常信息", example = "Internal Server Error")
    private String errorMsg;

    @Schema(description = "异常时刻", example = "2021-10-10T10:10:10.101010")
    private LocalDateTime errorTime;

}
