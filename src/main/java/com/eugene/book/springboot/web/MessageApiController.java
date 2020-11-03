package com.eugene.book.springboot.web;

import com.eugene.book.springboot.web.dto.MembersSaveRequestDto;
import com.eugene.book.springboot.web.dto.MessageDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.*;
import com.eugene.book.springboot.service.message.MessageService;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

@RequiredArgsConstructor
@RestController
public class MessageApiController {

    private final MessageService messageService;

    @PostMapping("/callApi")
    public String callApi(Model model, @ModelAttribute(value = "MessageDto")MessageDto message){

        String url = "https://fcm.googleapis.com/fcm/send";
        String key = "AAAANfOmnEk:APA91bHNTrI4Js_CReSGDi4SNjVt4lYho8bU_zyZz2GQNK0vErKeS0vdrAQ-Ynoucp1NopAmj70DhuTETG8fwl51_4-YjOA85suuqmcuLPFF7kmjYTrw0gNvZEoIlYeGDGNHTI2pRd83";

        //create an instance of RestTemplate
        RestTemplate restTemplate = new RestTemplate();

        //create headers
        HttpHeaders headers = new HttpHeaders();
        //set `content-type` header
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        headers.add("Authorization", "key="+ key);

        //request body parameters
        Map<String, Object> map = new HashMap<>();
        Map<String, Object> map2 = new HashMap<>();

        map2.put("title", message.getTitle());
        map2.put("body", message.getBody());

        map.put("to", message.getTo());
        map.put("notification", map2);

        //build the request
        HttpEntity<Map<String, Object>> entity = new HttpEntity<>(map, headers);

        //send POST request
        ResponseEntity<String> response = restTemplate.postForEntity(url, entity, String.class);

        //check response
        if(response.getStatusCode() == HttpStatus.OK){
            System.out.println("request Successful");
            System.out.println(entity);
            System.out.println(response.getBody());

        }else{
            System.out.println("request Failed");
            System.out.println(response.getStatusCode());
        }

        return "";
    }


}
