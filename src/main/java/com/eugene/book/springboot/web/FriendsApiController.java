package com.eugene.book.springboot.web;

import com.eugene.book.springboot.service.friends.FriendsService;
import com.eugene.book.springboot.web.dto.FriendsResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class FriendsApiController {

    private final FriendsService friendsService;

//    @GetMapping("/getFriends/{name}")
//    public FriendsResponseDto findByName(@PathVariable String name){ return friendsService.findByName(name); }

    @GetMapping("/getFriends/{name}")
    public List<FriendsResponseDto> findByName(@PathVariable String name){
        return friendsService.findByName(name);
    }
}
