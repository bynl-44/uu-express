package icu.uuqk.user.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import icu.uuqk.user.entity.AddressBook;
import org.apache.ibatis.annotations.Mapper;

/**
 * 地址簿 Mapper
 */
@Mapper
public interface AddressBookMapper extends BaseMapper<AddressBook> {
}
