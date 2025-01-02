package icu.uuqk.user.dto;

import icu.uuqk.user.entity.AddressBook;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@Schema(name = "AddressBookDto", description = "地址簿DTO")
public class AddressBookDto {

    @Schema(description = "id", example = "1123")
    private Long id;

    @Schema(description = "用户id", example = "123456")
    private Long userId;

    @Schema(description = "地址簿类型  1寄件 2收件", example = "1")
    @Pattern(regexp = "^[12]$", message = "地址簿类型只能是1或2")
    private Integer type;

    @Schema(description = "姓名", example = "张三")
    @NotEmpty(message = "姓名不能为空")
    @Size(min = 2, max = 10, message = "姓名长度必须在2-10之间")
    private String name;

    @Schema(description = "电话号", example = "13800138000")
    @NotEmpty(message = "电话号不能为空")
    @Pattern(regexp = "^\\d{11}$", message = "电话号格式不正确")
    private String phoneNumber;

    @Schema(description = "分机号", example = "010")
    private String extensionNumber;

    @Schema(description = "所属省份id", example = "110000")
    @NotEmpty(message = "所属省份id不能为空")
    private Long provinceId;

    @Schema(description = "所属城市id", example = "110100")
    @NotEmpty(message = "所属城市id不能为空")
    private Long cityId;

    @Schema(description = "所属区县id", example = "110101")
    @NotEmpty(message = "所属区县id不能为空")
    private Long countyId;

    @Schema(description = "详细地址", example = "北京市海淀区西二旗北路10号")
    @NotEmpty(message = "详细地址不能为空")
    private String address;

    @Schema(description = "公司名称", example = "腾讯科技")
    @NotEmpty(message = "公司名称不能为空")
    private String companyName;

    @Schema(description = "是否默认 0:否，1:是", example = "1")
    @Pattern(regexp = "^[01]$", message = "是否默认只能是0或1")
    private Integer isDefault;

    @Schema(description = "是否展示 0:否，1:是", example = "1")
    @Pattern(regexp = "^[01]$", message = "是否展示只能是0或1")
    private Integer isShow;

    public static class Convertor {
        private Convertor() {
        }

        public static AddressBook toEntity(AddressBookDto dto) {
            AddressBook addressBook = new AddressBook();
            addressBook.setId(dto.getId());
            addressBook.setUserId(dto.getUserId());
            addressBook.setType(dto.getType());
            addressBook.setName(dto.getName());
            addressBook.setPhoneNumber(dto.getPhoneNumber());
            addressBook.setExtensionNumber(dto.getExtensionNumber());
            addressBook.setProvinceId(dto.getProvinceId());
            addressBook.setCityId(dto.getCityId());
            addressBook.setCountyId(dto.getCountyId());
            addressBook.setAddress(dto.getAddress());
            addressBook.setCompanyName(dto.getCompanyName());
            addressBook.setIsDefault(dto.getIsDefault());
            addressBook.setIsShow(dto.getIsShow());
            return addressBook;
        }
    }
}
