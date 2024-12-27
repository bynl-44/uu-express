package icu.uuqk.user.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import icu.uuqk.user.entity.Member;
import org.apache.ibatis.annotations.Mapper;

/**
 * 用户表 Mapper
 */
@Mapper
public interface MemberMapper extends BaseMapper<Member> {
}
