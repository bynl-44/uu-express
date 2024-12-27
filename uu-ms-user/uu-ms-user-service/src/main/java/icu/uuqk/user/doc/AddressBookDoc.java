package icu.uuqk.user.doc;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import icu.uuqk.common.dto.ErrorResponseDto;
import icu.uuqk.common.dto.ResponseDto;
import icu.uuqk.user.dto.AddressBookDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;

@Tag(name = "地址簿 API", description = "地址簿相关接口")
public interface AddressBookDoc {

    @Operation(summary = "创建地址簿", description = "创建地址簿")
    @ApiResponse(responseCode = "200", description = "成功")
    @ApiResponse(responseCode = "500", description = "服务器内部错误", content = @Content(schema = @Schema(implementation = ErrorResponseDto.class)))
    ResponseEntity<AddressBookDto> createAddressBook(AddressBookDto addressBookDto);

    @Operation(summary = "更新地址簿", description = "更新地址簿")
    @ApiResponse(responseCode = "200", description = "成功")
    @ApiResponse(responseCode = "417", description = "更新失败")
    @ApiResponse(responseCode = "500", description = "服务器内部错误", content = @Content(schema = @Schema(implementation = ErrorResponseDto.class)))
    ResponseEntity<ResponseDto> updateAddressBook(Long id, AddressBookDto addressBookDto);

    @Operation(summary = "删除地址簿", description = "删除地址簿")
    @ApiResponse(responseCode = "200", description = "成功")
    @ApiResponse(responseCode = "417", description = "删除失败")
    @ApiResponse(responseCode = "500", description = "服务器内部错误", content = @Content(schema = @Schema(implementation = ErrorResponseDto.class)))
    ResponseEntity<ResponseDto> deleteAddressBook(Long id);

    @Operation(summary = "获取地址簿", description = "获取地址簿")
    @ApiResponse(responseCode = "200", description = "成功")
    @ApiResponse(responseCode = "500", description = "服务器内部错误", content = @Content(schema = @Schema(implementation = ErrorResponseDto.class)))
    ResponseEntity<AddressBookDto> getAddressBook(Long id);

    @Operation(summary = "获取地址簿列表", description = "获取地址簿列表")
    @ApiResponse(responseCode = "200", description = "成功")
    @ApiResponse(responseCode = "500", description = "服务器内部错误", content = @Content(schema = @Schema(implementation = ErrorResponseDto.class)))
    ResponseEntity<Page<AddressBookDto>> getAddressBookList(int page, int size);
}
