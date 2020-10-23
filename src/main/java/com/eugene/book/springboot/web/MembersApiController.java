package com.eugene.book.springboot.web;


import com.eugene.book.springboot.domain.members.GetToken;
import com.eugene.book.springboot.service.members.MembersService;
import com.eugene.book.springboot.web.dto.*;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.*;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

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

    @PostMapping("/getAPI")
    public String SendMessage(){

        HashMap<String, Object> result = new HashMap<String, Object>();

        String jsonInString = "";
        String key = "AAAANfOmnEk:APA91bHNTrI4Js_CReSGDi4SNjVt4lYho8bU_zyZz2GQNK0vErKeS0vdrAQ-Ynoucp1NopAmj70DhuTETG8fwl51_4-YjOA85suuqmcuLPFF7kmjYTrw0gNvZEoIlYeGDGNHTI2pRd83";

        try{
            RestTemplate resttemplate = new RestTemplate();

            HttpHeaders header = new HttpHeaders();
            header.add("Authorization", "key="+key);
            header.setContentType(MediaType.APPLICATION_JSON);

            HttpEntity<?> entity = new HttpEntity<>(header);

            String url = "https://fcm.googleapis.com/fcm/send";

            UriComponents uri = UriComponentsBuilder.fromHttpUrl(url).build();

            //API 호출해 MembersSendRESTDto 타입으로 전달받는다.
            ResponseEntity<MembersSendRESTDto> resultSendData = resttemplate.exchange(uri.toString(), HttpMethod.POST, entity, MembersSendRESTDto.class);
            result.put("statusCode", resultSendData.getStatusCodeValue());
            result.put("header", resultSendData.getHeaders());
            result.put("body", resultSendData.getBody());

            ObjectMapper mapper = new ObjectMapper();
            jsonInString = mapper.writeValueAsString(resultSendData.getBody());
            System.out.println(jsonInString);

        }catch(Exception e){
            e.printStackTrace();
        }


        return jsonInString;
    }

    @GetMapping("/getToken/{toName}")
    public String getToken(@PathVariable String toName){
        return membersService.getToken(toName);
    }



}
