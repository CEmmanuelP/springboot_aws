package com.eugene.book.springboot.web.dto;


import com.eugene.book.springboot.domain.message.Message;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class MessageDto {
    private String to;
    private String title;
    private String body;

}
