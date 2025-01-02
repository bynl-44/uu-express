package icu.uuqk.user.doc;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import icu.uuqk.common.dto.ErrorResponseDto;
import icu.uuqk.common.dto.ResponseDto;
import icu.uuqk.user.dto.MemberDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;

@Tag(name = "用户 API", description = "用户相关接口")
public interface MemberDoc {

    @Operation(summary = "创建用户", description = "创建用户")
    @ApiResponse(responseCode = "200", description = "成功")
    @ApiResponse(responseCode = "500", description = "服务器内部错误", content = @Content(
            schema = @Schema(implementation = ErrorResponseDto.class)
    ))
    ResponseEntity<ResponseDto> createMember(MemberDto memberDto);

    @Operation(summary = "更新用户", description = "更新用户")
    @ApiResponse(responseCode = "200", description = "成功")
    @ApiResponse(responseCode = "417", description = "更新失败")
    @ApiResponse(responseCode = "500", description = "服务器内部错误", content = @Content(
            schema = @Schema(implementation = ErrorResponseDto.class)
    ))
    ResponseEntity<ResponseDto> updateMember(Long id, MemberDto memberDto);

    @Operation(summary = "删除用户", description = "删除用户")
    @ApiResponse(responseCode = "200", description = "成功")
    @ApiResponse(responseCode = "417", description = "删除失败")
    @ApiResponse(responseCode = "500", description = "服务器内部错误", content = @Content(
            schema = @Schema(implementation = ErrorResponseDto.class)
    ))
    ResponseEntity<ResponseDto> deleteMember(Long id);

    @Operation(summary = "获取用户详情", description = "获取用户详情")
    @ApiResponse(responseCode = "200", description = "成功")
    @ApiResponse(responseCode = "500", description = "服务器内部错误", content = @Content(
            schema = @Schema(implementation = ErrorResponseDto.class)
    ))
    ResponseEntity<MemberDto> getMemberDetails(Long id);

    @Operation(summary = "获取用户详情", description = "获取用户详情")
    @ApiResponse(responseCode = "200", description = "成功")
    @ApiResponse(responseCode = "500", description = "服务器内部错误", content = @Content(
            schema = @Schema(implementation = ErrorResponseDto.class)
    ))
    ResponseEntity<MemberDto> getMemberByOpenId(String openId);

    @Operation(summary = "获取用户列表", description = "获取用户列表")
    @ApiResponse(responseCode = "200", description = "成功")
    @ApiResponse(responseCode = "500", description = "服务器内部错误", content = @Content(
            schema = @Schema(implementation = ErrorResponseDto.class)
    ))
    ResponseEntity<Page<MemberDto>> getMemberList(int page, int size);
}
