package icu.uuqk.user.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import icu.uuqk.user.entity.AddressBook;

/**
 * 地址簿 服务类接口
 */
public interface AddressBookService extends IService<AddressBook> {

    AddressBook createAddressBook(AddressBook addressBookDto);

    boolean updateAddressBook(AddressBook addressBook);

    boolean deleteAddressBook(Long id);

    AddressBook getAddressBookById(Long id);

    Page<AddressBook> getAddressBookList(int page, int size);
}
