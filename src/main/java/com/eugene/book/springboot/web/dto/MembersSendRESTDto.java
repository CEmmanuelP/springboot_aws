package com.eugene.book.springboot.web.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
public class MembersSendRESTDto {
    private String fromName;
    private String toName;
    private String title;
    private String message;
    private String token;

    public MembersSendRESTDto(String fromName, String toName, String title, String message, String token){

        this.fromName = fromName;
        this.toName = toName;
        this.title = title;
        this.message = message;
        this.token = token;

    }


}
