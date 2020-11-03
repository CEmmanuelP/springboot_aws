package com.eugene.book.springboot.web;


import com.eugene.book.springboot.domain.members.GetToken;
import com.eugene.book.springboot.service.members.MembersService;
import com.eugene.book.springboot.web.dto.*;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.*;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import java.nio.file.Path;
import java.util.HashMap;
import java.util.List;

@RequiredArgsConstructor
@RestController
public class MembersApiController {

    private final MembersService membersService;

    @PostMapping("/api/v1/members")
    public String save(@RequestBody MembersSaveRequestDto requestDto){
        return membersService.save(requestDto);
    }

    @PutMapping("/api/v1/members/{id}")
    public Long update(@PathVariable Long id, @RequestBody MembersUpdateRequestDto requestDto){
        return membersService.update(id, requestDto);
    }

    @GetMapping("api/v1/members/{id}")
    public MembersResponseDto findById(@PathVariable Long id){
        return membersService.findById(id);
    }

    @GetMapping("/getToken/{toName}")
    public String getToken(@PathVariable String toName){
        return membersService.getToken(toName);
    }



}
