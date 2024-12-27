package icu.uuqk.user.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import icu.uuqk.user.entity.AddressBook;
import icu.uuqk.user.exception.AddressBookCreateException;
import icu.uuqk.user.exception.AddressBookNotFoundException;
import icu.uuqk.user.mapper.AddressBookMapper;
import icu.uuqk.user.service.AddressBookService;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * 地址簿 服务实现类
 */
@Service
public class AddressBookServiceImpl extends ServiceImpl<AddressBookMapper, AddressBook> implements AddressBookService {

    private static final String ADDRESS_BOOK = "AddressBook";

    @Override
    public AddressBook createAddressBook(AddressBook addressBook) {
        boolean ok = save(addressBook);

        if (!ok) {
            throw new AddressBookCreateException();
        }

        return lambdaQuery().eq(AddressBook::getType, addressBook.getType())
                .eq(AddressBook::getName, addressBook.getName())
                .eq(AddressBook::getPhoneNumber, addressBook.getPhoneNumber())
                .eq(AddressBook::getExtensionNumber, addressBook.getExtensionNumber())
                .eq(AddressBook::getProvinceId, addressBook.getProvinceId())
                .eq(AddressBook::getCityId, addressBook.getCityId())
                .eq(AddressBook::getCountyId, addressBook.getCountyId())
                .eq(AddressBook::getAddress, addressBook.getAddress())
                .eq(AddressBook::getCompanyName, addressBook.getCompanyName())
                .eq(AddressBook::getIsDefault, addressBook.getIsDefault())
                .eq(AddressBook::getIsShow, addressBook.getIsShow())
                .eq(AddressBook::getUserId, addressBook.getUserId())
                .orderByDesc(AddressBook::getCreated)
                .last("LIMIT 1")
                .one();

    }

    @Override
    public boolean updateAddressBook(AddressBook addressBook) {
        Optional<AddressBook> optionalAddressBook = Optional.ofNullable(getById(addressBook.getId()));

        if (optionalAddressBook.isEmpty()) {
            throw new AddressBookNotFoundException(ADDRESS_BOOK, "id", addressBook.getId().toString());
        }

        return updateById(addressBook);
    }

    @Override
    public boolean deleteAddressBook(Long id) {
        Optional<AddressBook> optionalAddressBook = Optional.ofNullable(getById(id));

        if (optionalAddressBook.isEmpty()) {
            throw new AddressBookNotFoundException(ADDRESS_BOOK, "id", id.toString());
        }

        return removeById(id);
    }

    @Override
    public AddressBook getAddressBookById(Long id) {
        Optional<AddressBook> optionalAddressBook = Optional.ofNullable(getById(id));

        if (optionalAddressBook.isEmpty()) {
            throw new AddressBookNotFoundException(ADDRESS_BOOK, "id", id.toString());
        }

        return optionalAddressBook.get();
    }

    @Override
    public Page<AddressBook> getAddressBookList(int page, int size) {
        Page<AddressBook> pageAddressBook = new Page<>(page, size);
        return lambdaQuery().page(pageAddressBook);
    }
}
