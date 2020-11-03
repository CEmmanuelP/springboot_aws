package com.eugene.book.springboot.domain.friends;

import com.eugene.book.springboot.web.dto.FriendsResponseDto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FriendsRepository extends JpaRepository<Friends, Long> {
    List<Friends> findByName(String name);
}
