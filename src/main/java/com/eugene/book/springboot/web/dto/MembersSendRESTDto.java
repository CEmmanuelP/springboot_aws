package com.eugene.book.springboot.web.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
public class MembersSendRESTDto {
    private String token;
    private Notification notification;

    public MembersSendRESTDto(String token, Notification notification){
        this.token = token;
        this.notification = notification;

    }


}
