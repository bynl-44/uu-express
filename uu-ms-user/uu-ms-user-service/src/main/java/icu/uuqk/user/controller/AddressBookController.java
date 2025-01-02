package icu.uuqk.user.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import icu.uuqk.common.dto.ResponseDto;
import icu.uuqk.user.contants.AddressBookConstants;
import icu.uuqk.user.doc.AddressBookDoc;
import icu.uuqk.user.dto.AddressBookDto;
import icu.uuqk.user.entity.AddressBook;
import icu.uuqk.user.service.AddressBookService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * 地址簿 前端控制器
 */
@Validated
@RestController
@RequestMapping("/address-book")
@RequiredArgsConstructor
public class AddressBookController implements AddressBookDoc {

    private final AddressBookService addressBookService;

    @Override
    @PostMapping
    public ResponseEntity<AddressBookDto> createAddressBook(@RequestBody @Valid AddressBookDto addressBookDto) {
        AddressBook addressBook = AddressBookDto.Convertor.toEntity(addressBookDto);
        AddressBook result = addressBookService.createAddressBook(addressBook);
        AddressBookDto resultDto = AddressBook.Convertor.toDto(result);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(resultDto);
    }

    @Override
    @PutMapping("/{id}")
    public ResponseEntity<ResponseDto> updateAddressBook(@PathVariable Long id, @RequestBody @Valid AddressBookDto addressBookDto) {
        AddressBook addressBook = AddressBookDto.Convertor.toEntity(addressBookDto);
        boolean ok = addressBookService.updateAddressBook(addressBook);

        if (ok) {
            return ResponseEntity.ok(new ResponseDto(AddressBookConstants.STATUS_200, AddressBookConstants.MESSAGE_200));
        } else {
            return ResponseEntity
                    .status(HttpStatus.EXPECTATION_FAILED)
                    .body(new ResponseDto(AddressBookConstants.STATUS_417, AddressBookConstants.MESSAGE_417_UPDATE));
        }
    }

    @Override
    @DeleteMapping("/{id}")
    public ResponseEntity<ResponseDto> deleteAddressBook(@PathVariable Long id) {
        boolean ok = addressBookService.deleteAddressBook(id);

        if (ok) {
            return ResponseEntity.ok(new ResponseDto(AddressBookConstants.STATUS_200, AddressBookConstants.MESSAGE_200));
        } else {
            return ResponseEntity
                    .status(HttpStatus.EXPECTATION_FAILED)
                    .body(new ResponseDto(AddressBookConstants.STATUS_417, AddressBookConstants.MESSAGE_417_DELETE));
        }
    }

    @Override
    @GetMapping("/{id}")
    public ResponseEntity<AddressBookDto> getAddressBook(@PathVariable Long id) {
        AddressBook addressBook = addressBookService.getAddressBookById(id);
        AddressBookDto resultDto = AddressBook.Convertor.toDto(addressBook);
        return ResponseEntity.ok(resultDto);
    }

    @Override
    @GetMapping("/page")
    public ResponseEntity<Page<AddressBookDto>> getAddressBookList(@RequestParam(defaultValue = "1") int page, @RequestParam(defaultValue = "10") int size) {
        Page<AddressBook> addressBookPage = addressBookService.getAddressBookList(page, size);
        Page<AddressBookDto> addressBookDtoPage = Page.of(addressBookPage.getCurrent(), addressBookPage.getSize(), addressBookPage.getTotal());
        addressBookDtoPage.setRecords(addressBookPage.getRecords().stream().map(AddressBook.Convertor::toDto).toList());
        return ResponseEntity.ok(addressBookDtoPage);
    }
}
