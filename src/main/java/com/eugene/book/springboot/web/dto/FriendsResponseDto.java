package com.eugene.book.springboot.web.dto;

import com.eugene.book.springboot.domain.friends.Friends;
import com.eugene.book.springboot.domain.members.Members;
import lombok.Getter;

@Getter
public class FriendsResponseDto {

    private Long id;
    private String name;
    private String friendName;

    public FriendsResponseDto(Friends entity){
        this.id = entity.getId();
        this.name = entity.getName();
        this.friendName = entity.getFriendName();
    }

}
