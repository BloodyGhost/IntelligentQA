package com.example.db.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 服务层
 * <p/>
 * yutianran 2017/1/19 下午10:02
 */
@Service
public class UserService {
    @Autowired
    private UserRepository repository;

    @Transactional
    public void insertTwo(String a, String b) {
        User userA = new User();
        userA.setName(a);
        userA.setAge(21);
        repository.save(userA);

        User userB = new User();
        userB.setName(b);
        userB.setAge(22);
        repository.save(userB);
    }
}
