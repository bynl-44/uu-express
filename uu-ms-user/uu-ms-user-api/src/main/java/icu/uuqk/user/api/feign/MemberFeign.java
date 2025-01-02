package icu.uuqk.user.api.feign;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import icu.uuqk.common.dto.ResponseDto;
import icu.uuqk.user.dto.MemberDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Feign client for the Member API.
 */
@FeignClient(name = "uu-ms-user", path = "member", contextId = "member")
public interface MemberFeign {

    /**
     * Creates a new member.
     *
     * @param memberDto The member to create.
     * @return The response containing the created member.
     */
    @PostMapping
    ResponseEntity<ResponseDto> createMember(@RequestBody MemberDto memberDto);

    /**
     * Updates an existing member.
     *
     * @param id        The id of the member to update.
     * @param memberDto The updated member.
     * @return The response containing the updated member.
     */
    @PutMapping("/{id}")
    ResponseEntity<ResponseDto> updateMember(@PathVariable Long id, @RequestBody MemberDto memberDto);

    /**
     * Deletes an existing member.
     *
     * @param id The id of the member to delete.
     * @return The response containing the deleted member.
     */
    @DeleteMapping("/{id}")
    ResponseEntity<ResponseDto> deleteMember(@PathVariable Long id);

    /**
     * Gets a member by id.
     *
     * @param id The id of the member to get.
     * @return The response containing the member.
     */
    @GetMapping("/{id}")
    ResponseEntity<ResponseDto> getMember(@PathVariable Long id);

    /**
     * Gets a member by openId.
     *
     * @param openId The openId of the member to get.
     * @return The response containing the member.
     */
    @GetMapping("/openId/{openId}")
    ResponseEntity<ResponseDto> getMemberByOpenId(@PathVariable String openId);

    /**
     * Gets a list of members.
     *
     * @param page The page number to get.
     * @param size The size of the page.
     * @return The response containing the list of members.
     */
    @GetMapping("/page")
    ResponseEntity<Page<MemberDto>> getMemberList(
            @RequestParam(value = "page", defaultValue = "1") Integer page,
            @RequestParam(value = "size", defaultValue = "10") Integer size
    );
}
