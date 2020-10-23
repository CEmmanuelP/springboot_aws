package com.eugene.book.springboot.web.dto;

import lombok.Getter;

@Getter
public class Notification {
    private String title;
    private String body;

    public Notification(String title, String body){
        this.title = title;
        this.body = body;
    }
}
