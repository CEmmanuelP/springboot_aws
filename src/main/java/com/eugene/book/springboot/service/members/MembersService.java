package com.eugene.book.springboot.service.members;

import com.eugene.book.springboot.domain.members.Members;
import com.eugene.book.springboot.domain.members.MembersRepository;
import com.eugene.book.springboot.web.dto.MembersResponseDto;
import com.eugene.book.springboot.web.dto.MembersSaveRequestDto;
import com.eugene.book.springboot.web.dto.MembersSendRESTDto;
import com.eugene.book.springboot.web.dto.MembersUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class MembersService {

    private final MembersRepository membersRepository;

    @Transactional
    public Long save(MembersSaveRequestDto requestDto){
        return membersRepository.save(requestDto.toEntity()).getId();
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

    public Long tokenValue(Long id, String token, String toName, MembersSendRESTDto sendRESTDto){

        Optional<Members> byName = membersRepository.findByName(toName);
        return id;
    }
}
