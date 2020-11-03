package com.eugene.book.springboot.service.friends;

import com.eugene.book.springboot.domain.friends.Friends;
import com.eugene.book.springboot.domain.friends.FriendsRepository;
import com.eugene.book.springboot.domain.members.GetToken;
import com.eugene.book.springboot.web.dto.FriendsResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class FriendsService {
    private final FriendsRepository friendsRepository;

    public FriendsResponseDto findById(Long id) {
        Friends entity = friendsRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("no Id. id=" + id));

        return new FriendsResponseDto(entity);
    }



    @Transactional(readOnly = true)
    public List<FriendsResponseDto> findByName(String name) {
        return friendsRepository.findByName(name).stream()
                .map(FriendsResponseDto::new)
                .collect(Collectors.toList());
    }
}
