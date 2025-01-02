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

    @Schema(description = "用户 ID", example = "123")
    private Long id;

    @Schema(description = "用户认证 ID", example = "123456")
    private String authId;

    @Schema(description = "身份证号", example = "123456199001011234")
    @NotEmpty(message = "身份证号不能为空")
    @Size(min = 18, max = 18, message = "身份证号长度必须为 18 位")
    private String idCardNo;

    @Schema(description = "身份证号是否通过验证, 0：未验证，1：通过验证, 2：验证失败", example = "1")
    @NotEmpty(message = "身份证号验证状态不能为空")
    @Pattern(regexp = "^[012]$", message = "身份证号验证状态只能是 0、1 或 2")
    private Integer idCardNoVerify;

    @Schema(description = "手机号", example = "13800138000")
    @NotEmpty(message = "手机号不能为空")
    @Size(min = 11, max = 11, message = "手机号长度必须为 11 位")
    private String phone;

    @Schema(description = "姓名", example = "张三")
    @NotEmpty(message = "姓名不能为空")
    @Size(min = 2, max = 10, message = "姓名长度必须在 2 到 10 之间")
    private String name;

    @Schema(description = "头像", example = "http://example.com/avatar.jpg")
    private String avatar;

    @Schema(description = "微信 openId", example = "o1234567890")
    private String openId;

    @Schema(description = "性别，1：男，0：女", example = "1")
    @NotEmpty(message = "性别不能为空")
    @Pattern(regexp = "^[01]$", message = "性别只能是 0 或 1")
    private Integer sex;

    @Schema(description = "生日", example = "1990-01-01")
    @Pattern(regexp = "^\\d{4}-\\d{2}-\\d{2}$", message = "生日格式错误，应为 yyyy-MM-dd")
    private String birthday;

    public static class Convertor {
        private Convertor() {
        }

        public static Member toEntity(MemberDto memberDto) {
            Member member = new Member();
            member.setId(memberDto.getId());
            member.setAuthId(memberDto.getAuthId());
            member.setIdCardNo(memberDto.getIdCardNo());
            member.setIdCardNoVerify(memberDto.getIdCardNoVerify());
            member.setPhone(memberDto.getPhone());
            member.setName(memberDto.getName());
            member.setAvatar(memberDto.getAvatar());
            member.setOpenId(memberDto.getOpenId());
            member.setSex(memberDto.getSex());
            member.setBirthday(memberDto.getBirthday());
            return member;
        }
    }
}
