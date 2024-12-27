package icu.uuqk.user.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import icu.uuqk.common.entity.BaseEntity;
import icu.uuqk.user.dto.MemberDto;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.SuperBuilder;

/**
 * 用户表
 */
@Data
@SuperBuilder
@EqualsAndHashCode(callSuper = true)
@TableName("uu_member")
public class Member extends BaseEntity {

    /**
     * 统一认证id
     */
    private String authId;

    /**
     * 身份证号
     */
    private String idCardNo;

    /**
     * 身份证号是否验证0：未验证 1：验证通过 2：验证未通过
     */
    private Integer idCardNoVerify;

    /**
     * 手机号
     */
    private String phone;

    /**
     * 名称
     */
    private String name;

    /**
     * 头像
     */
    private String avatar;

    /**
     * 微信openID
     */
    private String openId;

    /**
     * 性别 1-男，0-女
     */
    private Integer sex;

    /**
     * 生日
     */
    private String birthday;

    public static class Convertor {

        private Convertor() {
        }

        public static MemberDto toDto(Member member) {
            return MemberDto.builder()
                    .id(member.getId())
                    .authId(member.getAuthId())
                    .idCardNo(member.getIdCardNo())
                    .idCardNoVerify(member.getIdCardNoVerify())
                    .phone(member.getPhone())
                    .name(member.getName())
                    .avatar(member.getAvatar())
                    .openId(member.getOpenId())
                    .sex(member.getSex())
                    .birthday(member.getBirthday())
                    .build();
        }
    }
}
