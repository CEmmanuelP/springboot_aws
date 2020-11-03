package com.eugene.book.springboot.domain.message;

import com.eugene.book.springboot.domain.friends.Friends;
import com.eugene.book.springboot.web.dto.MessageDto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MessageRepository extends JpaRepository<Message, Long> {

}
