package com.eugene.book.springboot.service.members;

import com.eugene.book.springboot.domain.members.GetToken;
import com.eugene.book.springboot.domain.members.Members;
import com.eugene.book.springboot.domain.members.MembersRepository;

import com.eugene.book.springboot.web.dto.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class MembersService {

    private final MembersRepository membersRepository;

    @Transactional
    public String save(MembersSaveRequestDto requestDto){
        return membersRepository.save(requestDto.toEntity()).getName();
    }

    @Transactional
    public Long update(Long id, MembersUpdateRequestDto requestDto){
        Members members = membersRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("no Id. id=" + id));
        members.update(requestDto.getPassword(), requestDto.getPhoneNumber(), requestDto.getImage(), requestDto.getNickName());

        return id;
    }

    public MembersResponseDto findById(Long id){
        Members entity = membersRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("no Id. id=" + id));

        return new MembersResponseDto(entity);
    }

    @Transactional(readOnly = true)
    public List<MembersResponseDto> findAllDesc(){
        return membersRepository.findAllDesc().stream()
                .map(MembersResponseDto::new)
                .collect(Collectors.toList());
    }



    @Transactional
    public String getToken(String toName){

        GetToken getToken = membersRepository.findByName(toName);
        String token = getToken.getToken();
        return token;
    }
}
