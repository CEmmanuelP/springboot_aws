package com.eugene.book.springboot.web;


import com.eugene.book.springboot.service.members.MembersService;
import com.eugene.book.springboot.web.dto.MembersResponseDto;
import com.eugene.book.springboot.web.dto.MembersSaveRequestDto;
import com.eugene.book.springboot.web.dto.MembersUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;

@RequiredArgsConstructor
@RestController
public class MembersApiController {

    private final MembersService membersService;

    @PostMapping("/api/v1/members")
    public Long save(@RequestBody MembersSaveRequestDto requestDto){
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

    @GetMapping("/getAPI")
    public String SendMessage(){

        HashMap<String, Object> result = new HashMap<String, Object>();

        String jsonInString = "";

        try{
            RestTemplate resttemplate = new RestTemplate();

            HttpHeaders header = new HttpHeaders();
            HttpEntity<?> entity = new HttpEntity<>(header);

            String url = "https://fcm.googleapis.com/fcm/send";

        }catch(Exception e){
            e.printStackTrace();
        }


        return "";
    }
}
