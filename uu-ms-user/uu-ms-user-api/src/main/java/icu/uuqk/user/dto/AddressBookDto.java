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

    @Schema(description = "id")
    private Long id;

    @Schema(description = "用户id")
    private Long userId;

    @Schema(description = "地址簿类型  1寄件 2收件")
    @Pattern(regexp = "^[12]$", message = "地址簿类型只能是1或2")
    private Integer type;

    @Schema(description = "姓名")
    @NotEmpty(message = "姓名不能为空")
    @Size(min = 2, max = 10, message = "姓名长度必须在2-10之间")
    private String name;

    @Schema(description = "电话号")
    @NotEmpty(message = "电话号不能为空")
    @Pattern(regexp = "^\\d{11}$", message = "电话号格式不正确")
    private String phoneNumber;

    @Schema(description = "分机号")
    private String extensionNumber;

    @Schema(description = "所属省份id")
    @NotEmpty(message = "所属省份id不能为空")
    private Long provinceId;

    @Schema(description = "所属城市id")
    @NotEmpty(message = "所属城市id不能为空")
    private Long cityId;

    @Schema(description = "所属区县id")
    @NotEmpty(message = "所属区县id不能为空")
    private Long countyId;

    @Schema(description = "详细地址")
    @NotEmpty(message = "详细地址不能为空")
    private String address;

    @Schema(description = "公司名称")
    @NotEmpty(message = "公司名称不能为空")
    private String companyName;

    @Schema(description = "是否默认 0:否，1:是")
    @Pattern(regexp = "^[01]$", message = "是否默认只能是0或1")
    private Integer isDefault;

    @Schema(description = "是否展示 0:否，1:是")
    @Pattern(regexp = "^[01]$", message = "是否展示只能是0或1")
    private Integer isShow;

    public static class Convertor {
        private Convertor() {
        }

        public static AddressBook toEntity(AddressBookDto dto) {
            AddressBook.AddressBookBuilder<?, ?> builder = AddressBook.builder();
            builder.id(dto.getId());
            return builder.userId(dto.getUserId())
                    .type(dto.getType())
                    .name(dto.getName())
                    .phoneNumber(dto.getPhoneNumber())
                    .extensionNumber(dto.getExtensionNumber())
                    .provinceId(dto.getProvinceId())
                    .cityId(dto.getCityId())
                    .countyId(dto.getCountyId())
                    .address(dto.getAddress())
                    .companyName(dto.getCompanyName())
                    .isDefault(dto.getIsDefault())
                    .isShow(dto.getIsShow())
                    .build();
        }
    }
}
