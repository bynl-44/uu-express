package icu.uuqk.user.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import icu.uuqk.common.dto.ResponseDto;
import icu.uuqk.user.contants.MemberConstants;
import icu.uuqk.user.doc.MemberDoc;
import icu.uuqk.user.dto.MemberDto;
import icu.uuqk.user.entity.Member;
import icu.uuqk.user.service.MemberService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * 用户表 前端控制器
 */
@Validated
@RestController
@RequiredArgsConstructor
@RequestMapping("/member")
public class MemberController implements MemberDoc {

    private final MemberService memberService;

    @Override
    @PostMapping
    public ResponseEntity<ResponseDto> createMember(@Valid @RequestBody MemberDto memberDto) {
        Member member = MemberDto.Convertor.toEntity(memberDto);
        memberService.createMember(member);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(new ResponseDto(MemberConstants.STATUS_201, MemberConstants.MESSAGE_201));
    }

    @Override
    @PutMapping("/{id}")
    public ResponseEntity<ResponseDto> updateMember(@PathVariable Long id, @Valid @RequestBody MemberDto memberDto) {
        Member member = MemberDto.Convertor.toEntity(memberDto);
        member.setId(id);
        boolean ok = memberService.updateMemberById(member);

        if (ok) {
            return ResponseEntity.ok(new ResponseDto(MemberConstants.STATUS_200, MemberConstants.MESSAGE_200));
        } else {
            return ResponseEntity
                    .status(HttpStatus.EXPECTATION_FAILED)
                    .body(new ResponseDto(MemberConstants.STATUS_417, MemberConstants.MESSAGE_417_UPDATE));
        }
    }

    @Override
    @DeleteMapping("/{id}")
    public ResponseEntity<ResponseDto> deleteMember(@PathVariable Long id) {
        boolean ok = memberService.deleteMemberById(id);

        if (ok) {
            return ResponseEntity.ok(new ResponseDto(MemberConstants.STATUS_200, MemberConstants.MESSAGE_200));
        } else {
            return ResponseEntity
                    .status(HttpStatus.EXPECTATION_FAILED)
                    .body(new ResponseDto(MemberConstants.STATUS_417, MemberConstants.MESSAGE_417_DELETE));
        }
    }

    @Override
    @GetMapping("/{id}")
    public ResponseEntity<MemberDto> getMemberDetails(@PathVariable Long id) {
        Member member = memberService.getById(id);
        MemberDto memberDto = Member.Convertor.toDto(member);
        return ResponseEntity.ok(memberDto);
    }

    @Override
    @GetMapping("/openId/{openId}")
    public ResponseEntity<MemberDto> getMemberByOpenId(@PathVariable String openId) {
        Member member = memberService.getByOpenId(openId);
        MemberDto memberDto = Member.Convertor.toDto(member);
        return ResponseEntity.ok(memberDto);
    }

    @Override
    @GetMapping("/page")
    public ResponseEntity<Page<MemberDto>> getMemberList(@RequestParam(defaultValue = "1") int page, @RequestParam(defaultValue = "10") int size) {
        Page<Member> memberPage = memberService.getMemberList(page, size);
        Page<MemberDto> memberDtoPage = Page.of(memberPage.getCurrent(), memberPage.getSize(), memberPage.getTotal());
        memberDtoPage.setRecords(memberPage.getRecords().stream().map(Member.Convertor::toDto).toList());
        return ResponseEntity.ok(memberDtoPage);
    }
}
