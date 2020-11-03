package com.eugene.book.springboot.service.message;

import com.eugene.book.springboot.domain.message.MessageRepository;
import com.eugene.book.springboot.web.dto.FriendsResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class MessageService {

    private final MessageRepository messageRepository;
}
