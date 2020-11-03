package com.eugene.book.springboot.domain.members;

import lombok.extern.java.Log;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MembersRepositoryTest {

    @Autowired
    MembersRepository membersRepository;

    @Test
    public void testInsert(){
        for(int i = 1; i <= 100; i++){

            Members members = new Members();
            members.setName("name" + i);
            members.setToken("token" + i);
            members.setLoginId("loginId" + i);
            members.setPassword("password" + i);

            membersRepository.save(members);
        }
    }

}
