package com.github.carloscontrerasruiz.Repository;

import com.github.carloscontrerasruiz.user_starter.UserInfo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class RepositoryApplicationTests {

    @Autowired
    private UserInfo userInfo;

    @Test
    void starterTests() {
        String userData = userInfo.getUserData("TheId");
        System.out.println(userData);
    }

}
