package com.eugene.book.springboot.web.dto;

import com.eugene.book.springboot.domain.members.Members;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Date;


@Getter
@NoArgsConstructor
public class MembersSaveRequestDto {

    private String loginId;
    private String password;
    private String name;
    private String email;
    private String phoneNumber;
    private Date birthday;
    private Integer gender;
    private String image;
    private String nickName;
    private String token;

    @Builder
    public MembersSaveRequestDto(String loginId, String password, String name, String email, String phoneNumber, Date birthday, Integer gender, String image, String nickName, String token){
        this.loginId = loginId;
        this.password = password;
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.birthday = birthday;
        this.gender = gender;
        this.image = image;
        this.nickName = nickName;
        this.token = token;
    }

    public Members toEntity(){
        return Members.builder()
                .loginId(loginId)
                .password(password)
                .name(name)
                .email(email)
                .phoneNumber(phoneNumber)
                .birthday(birthday)
                .gender(gender)
                .image(image)
                .nickName(nickName)
                .token(token)
                .build();
    }
}
