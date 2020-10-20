package com.eugene.book.springboot.web.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class MembersUpdateRequestDto {

    private String password;
    private String image;
    private String nickName;
    private String phoneNumber;

    @Builder
    public MembersUpdateRequestDto(String password, String image, String nickName, String phoneNumber){

        this.password = password;
        this.image = image;
        this.nickName = nickName;
        this.phoneNumber = phoneNumber;
    }
}
