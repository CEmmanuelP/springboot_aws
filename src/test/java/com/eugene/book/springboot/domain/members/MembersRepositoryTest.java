package com.eugene.book.springboot.domain.members;

import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MembersRepositoryTest {

    @Autowired
    MembersRepository membersRepository;

    @After
    public void cleanup(){
        membersRepository.deleteAll();
    }

    @Test
    public void memberRegisterSave_open(){
        String loginId = "eugene";
        String password = "1234";
        String name = "eugene";
        String email = "chrisp3@daum.net";
        String phoneNumber = "01026887399";
        membersRepository.save(Members.builder().loginId(loginId)
                                                .password(password)
                                                .name(name)
                                                .email(email)
                                                .phoneNumber(phoneNumber)
                                                .build());

        //when
        List<Members> membersList = membersRepository.findAll();

        //then
        Members members = membersList.get(0);
        assertThat(members.getLoginId()).isEqualTo(loginId);
        assertThat(members.getPassword()).isEqualTo(password);
        assertThat(members.getName()).isEqualTo(name);
        assertThat(members.getEmail()).isEqualTo(email);
        assertThat(members.getPhoneNumber()).isEqualTo(phoneNumber);


    }

}
