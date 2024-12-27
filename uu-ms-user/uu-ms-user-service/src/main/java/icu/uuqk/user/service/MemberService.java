package icu.uuqk.user.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import icu.uuqk.user.entity.Member;

/**
 * 用户表 服务类接口
 */
public interface MemberService extends IService<Member> {

    Member getById(Long id);

    Member getByOpenId(String openId);

    void createMember(Member member);

    boolean updateMemberById(Member member);

    boolean deleteMemberById(Long id);

    Page<Member> getMemberList(int page, int size);
}
