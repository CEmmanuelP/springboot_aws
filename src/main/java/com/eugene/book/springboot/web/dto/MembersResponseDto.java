package com.eugene.book.springboot.web.dto;

import com.eugene.book.springboot.domain.members.Members;
import lombok.Getter;

import java.util.Date;

@Getter
public class MembersResponseDto {

    private Long id;
    private String loginId;
    private String password;
    private String name;
    private String email;
    private String phoneNumber;
    private String token;
    private Date birthday;
    private Integer gender;
    private String image;
    private String nickName;

    public MembersResponseDto(Members entity){
        this.id = entity.getId();
        this.loginId = entity.getLoginId();
        this.password = entity.getPassword();
        this.name = entity.getName();
        this.email = entity.getEmail();
        this.phoneNumber = entity.getPhoneNumber();
        this.token = entity.getToken();
        this.birthday = entity.getBirthday();
        this.gender = entity.getGender();
        this.image = entity.getImage();
        this.nickName = entity.getNickName();
    }
}
