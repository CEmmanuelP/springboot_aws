package com.eugene.book.springboot.domain.friends;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
public class Friends {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String friendName;

    @Builder
    public Friends(String name, String friendName){
        this.name = name;
        this.friendName = friendName;
    }
}
