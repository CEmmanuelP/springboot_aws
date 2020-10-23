package com.eugene.book.springboot.domain.members;


import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Getter
@NoArgsConstructor
@Entity
public class Members{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //@Column(nullable = false)
    private String loginId;

    //@Column(nullable = false)
    private String password;

    //@Column(nullable = false)
    private String name;

    //@Column(nullable = false)
    private String email;

    //@Column(nullable = false)
    private String phoneNumber;

    //@Column(nullable = false)
    private String token;

    private Date birthday;
    private Integer gender;
    private String image;
    private String nickName;

    @Builder
    public Members(String loginId,String password, String name, String email, String phoneNumber, String token, Date birthday, Integer gender, String image, String nickName){
        this.loginId = loginId;
        this.password = password;
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.token = token;
        this.birthday = birthday;
        this.gender = gender;
        this.image = image;
        this.nickName = nickName;

    }

    public void update(String password, String phoneNumber, String image, String nickName){
        this.password = password;
        this.phoneNumber = phoneNumber;
        this.image = image;
        this.nickName = nickName;
    }

}
