package icu.uuqk.user.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import icu.uuqk.user.entity.Member;
import icu.uuqk.user.exception.MemberAlreadyExistsException;
import icu.uuqk.user.exception.MemberNotFoundException;
import icu.uuqk.user.mapper.MemberMapper;
import icu.uuqk.user.service.MemberService;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * 用户表 服务实现类
 */
@Service
public class MemberServiceImpl extends ServiceImpl<MemberMapper, Member> implements MemberService {

    private static final String MEMBER = "Member";

    @Override
    public Member getById(Long id) {
        Optional<Member> optionalMember = Optional.ofNullable(getById(id));
        if (optionalMember.isEmpty()) {
            throw new MemberNotFoundException(MEMBER, "id", id.toString());
        }

        return optionalMember.get();
    }

    @Override
    public Member getByOpenId(String openId) {
        Optional<Member> optionalMember = Optional.ofNullable(lambdaQuery().eq(Member::getOpenId, openId).one());
        if (optionalMember.isEmpty()) {
            throw new MemberNotFoundException(MEMBER, "openId", openId);
        }

        return optionalMember.get();
    }

    @Override
    public void createMember(Member member) {
        Optional<Member> optionalMember = Optional.ofNullable(lambdaQuery().eq(Member::getOpenId, member.getOpenId()).one());
        if (optionalMember.isPresent()) {
            throw new MemberAlreadyExistsException("openId", member.getOpenId());
        }

        optionalMember = Optional.ofNullable(lambdaQuery().eq(Member::getPhone, member.getPhone()).one());
        if (optionalMember.isPresent()) {
            throw new MemberAlreadyExistsException("phone", member.getPhone());
        }

        save(member);
    }

    @Override
    public boolean updateMemberById(Member member) {
        Optional<Member> optionalMember = Optional.ofNullable(getById(member.getId()));
        if (optionalMember.isEmpty()) {
            throw new MemberNotFoundException(MEMBER, "id", member.getId().toString());
        }

        return updateById(member);
    }

    @Override
    public boolean deleteMemberById(Long id) {
        Optional<Member> optionalMember = Optional.ofNullable(getById(id));
        if (optionalMember.isEmpty()) {
            throw new MemberNotFoundException(MEMBER, "id", id.toString());
        }

        return removeById(id);
    }

    @Override
    public Page<Member> getMemberList(int page, int size) {
        Page<Member> pageMember = new Page<>(page, size);
        return lambdaQuery().page(pageMember);
    }

}
