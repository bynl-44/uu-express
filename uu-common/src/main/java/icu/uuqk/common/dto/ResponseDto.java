package icu.uuqk.common.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Schema(name = "Response", description = "成功响应对象")
public class ResponseDto {

    @Schema(description = "响应状态码")
    private String statusCode;

    @Schema(description = "响应消息")
    private String statusMsg;
}
