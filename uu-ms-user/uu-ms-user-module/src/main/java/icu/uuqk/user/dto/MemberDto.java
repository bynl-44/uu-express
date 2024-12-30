package icu.uuqk.user.dto;

import icu.uuqk.user.entity.Member;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@Schema(description = "用户 DTO")
public class MemberDto {

    @Schema(description = "用户 ID")
    private Long id;

    @Schema(description = "用户认证 ID")
    private String authId;

    @Schema(description = "身份证号")
    @NotEmpty(message = "身份证号不能为空")
    @Size(min = 18, max = 18, message = "身份证号长度必须为 18 位")
    private String idCardNo;

    @Schema(description = "身份证号是否通过验证, 0：未验证，1：通过验证, 2：验证失败")
    @NotEmpty(message = "身份证号验证状态不能为空")
    @Pattern(regexp = "^[012]$", message = "身份证号验证状态只能是 0、1 或 2")
    private Integer idCardNoVerify;

    @Schema(description = "手机号")
    @NotEmpty(message = "手机号不能为空")
    @Size(min = 11, max = 11, message = "手机号长度必须为 11 位")
    private String phone;

    @Schema(description = "姓名")
    @NotEmpty(message = "姓名不能为空")
    @Size(min = 2, max = 10, message = "姓名长度必须在 2 到 10 之间")
    private String name;

    @Schema(description = "头像")
    private String avatar;

    @Schema(description = "微信 openId")
    private String openId;

    @Schema(description = "性别，1：男，0：女")
    @NotEmpty(message = "性别不能为空")
    @Pattern(regexp = "^[01]$", message = "性别只能是 0 或 1")
    private Integer sex;

    @Schema(description = "生日")
    @Pattern(regexp = "^\\d{4}-\\d{2}-\\d{2}$", message = "生日格式错误，应为 yyyy-MM-dd")
    private String birthday;

    public static class Convertor {
        private Convertor() {
        }

        public static Member toEntity(MemberDto memberDto) {
            Member.MemberBuilder<?, ?> builder = Member.builder();
            builder.id(memberDto.getId());
            return builder.authId(memberDto.getAuthId())
                    .idCardNo(memberDto.getIdCardNo())
                    .idCardNoVerify(memberDto.getIdCardNoVerify())
                    .phone(memberDto.getPhone())
                    .name(memberDto.getName())
                    .avatar(memberDto.getAvatar())
                    .openId(memberDto.getOpenId())
                    .sex(memberDto.getSex())
                    .birthday(memberDto.getBirthday())
                    .build();
        }
    }
}
