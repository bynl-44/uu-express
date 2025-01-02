package icu.uuqk.user.api.feign;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import icu.uuqk.common.dto.ResponseDto;
import icu.uuqk.user.dto.AddressBookDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@FeignClient(name = "uu-ms-user", path = "addressBook", contextId = "AddressBook")
public interface AddressBookFeign {

    /**
     * 创建地址簿
     *
     * @param addressBookDto addressBookDto
     * @return AddressBookDto
     */
    @PostMapping
    ResponseEntity<AddressBookDto> createAddressBook(@RequestBody AddressBookDto addressBookDto);

    /**
     * 更新地址簿
     *
     * @param id             id
     * @param addressBookDto addressBookDto
     * @return ResponseDto
     */
    @PutMapping("/{id}")
    ResponseEntity<ResponseDto> updateAddressBook(@PathVariable Long id, @RequestBody AddressBookDto addressBookDto);

    /**
     * 删除地址簿
     *
     * @param id id
     * @return ResponseDto
     */
    @DeleteMapping("/{id}")
    ResponseEntity<ResponseDto> deleteAddressBook(@PathVariable Long id);

    /**
     * 获取地址簿
     *
     * @param id id
     * @return AddressBookDto
     */
    @GetMapping("/{id}")
    ResponseEntity<AddressBookDto> getAddressBook(@PathVariable Long id);

    /**
     * 获取地址簿列表
     *
     * @param page page
     * @param size size
     * @return Page<AddressBookDto>
     */
    @GetMapping("/page")
    ResponseEntity<Page<AddressBookDto>> getAddressBookList(
            @RequestParam(value = "page", defaultValue = "1") Integer page,
            @RequestParam(value = "size", defaultValue = "10") Integer size
    );
}
