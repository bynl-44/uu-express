package icu.uuqk.common.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Schema(name = "ResponseDto", description = "成功响应对象")
public class ResponseDto {

    @Schema(description = "响应状态码", example = "200")
    private String statusCode;

    @Schema(description = "响应消息", example = "成功")
    private String statusMsg;
}
