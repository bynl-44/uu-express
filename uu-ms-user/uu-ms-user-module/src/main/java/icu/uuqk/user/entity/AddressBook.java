package icu.uuqk.user.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import icu.uuqk.common.entity.BaseEntity;
import icu.uuqk.user.dto.AddressBookDto;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.SuperBuilder;

/**
 * 地址簿
 */
@Data
@SuperBuilder
@EqualsAndHashCode(callSuper = true)
@TableName("uu_address_book")
public class AddressBook extends BaseEntity {
    /**
     * 用户id
     */
    private Long userId;

    /**
     * 地址簿类型  1寄件 2收件
     */
    private Integer type;

    /**
     * 姓名
     */
    private String name;

    /**
     * 电话号
     */
    private String phoneNumber;

    /**
     * 分机号
     */
    private String extensionNumber;

    /**
     * 所属省份id
     */
    private Long provinceId;

    /**
     * 所属城市id
     */
    private Long cityId;

    /**
     * 所属区县id
     */
    private Long countyId;

    /**
     * 详细地址
     */
    private String address;

    /**
     * 公司名称
     */
    private String companyName;

    /**
     * 是否默认 0:否，1:是
     */
    private Integer isDefault;

    /**
     * 是否展示 0:否，1:是
     */
    private Integer isShow;

    public static class Convertor {
        private Convertor() {
        }

        public static AddressBookDto toDto(AddressBook addressBook) {
            return AddressBookDto.builder()
                    .id(addressBook.getId())
                    .userId(addressBook.getUserId())
                    .type(addressBook.getType())
                    .name(addressBook.getName())
                    .phoneNumber(addressBook.getPhoneNumber())
                    .extensionNumber(addressBook.getExtensionNumber())
                    .provinceId(addressBook.getProvinceId())
                    .cityId(addressBook.getCityId())
                    .countyId(addressBook.getCountyId())
                    .address(addressBook.getAddress())
                    .companyName(addressBook.getCompanyName())
                    .isDefault(addressBook.getIsDefault())
                    .isShow(addressBook.getIsShow())
                    .build();
        }
    }
}
