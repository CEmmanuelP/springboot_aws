package com.eugene.book.springboot.web;

import com.eugene.book.springboot.domain.members.Members;
import com.eugene.book.springboot.domain.members.MembersRepository;
import com.eugene.book.springboot.web.dto.MembersSaveRequestDto;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class MembersApiControllerTest {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Autowired
    private MembersRepository membersRepository;

    @After
    public void tearDown() throws Exception{
        membersRepository.deleteAll();
    }

    @Test
    public void Members_register() throws Exception{
        String loginId = "eugene";
        String password = "password";
        String name = "eugene";
        String email = "chrisp3@daum.net";
        String phoneNumber = "01026887399";
        MembersSaveRequestDto requestDto = MembersSaveRequestDto.builder()
                .loginId(loginId)
                .password(password)
                .name(name)
                .email(email)
                .phoneNumber(phoneNumber)
                .build();

        String url = "http://localhost:" + port + "api/v1/members";

        //when
        ResponseEntity<Long> responseEntity = restTemplate.postForEntity(url,requestDto, Long.class);

        //then
        assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(responseEntity.getBody()).isGreaterThan(0L);

        List<Members> all = membersRepository.findAll();
        assertThat(all.get(0).getLoginId()).isEqualTo(loginId);
        assertThat(all.get(0).getPassword()).isEqualTo(password);
        assertThat(all.get(0).getName()).isEqualTo(name);
        assertThat(all.get(0).getEmail()).isEqualTo(email);
        assertThat(all.get(0).getPhoneNumber()).isEqualTo(phoneNumber);
    }

}
