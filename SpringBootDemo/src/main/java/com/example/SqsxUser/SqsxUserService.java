package com.example.SqsxUser;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 服务层
 * <p/>
 * yutianran 2017/1/19 下午10:02
 */
@Service
public class SqsxUserService {
    @Autowired
    private SqsxUserRepository repository;

    @Transactional
    public void insertTwo(String name, String pwd,int type,int isdel) {
        SqsxUser sqsxUserA = new SqsxUser();
        sqsxUserA.setUsername(name);
        sqsxUserA.setPassword(pwd);
        sqsxUserA.setType(type);
        sqsxUserA.setIsdel(isdel);
        repository.save(sqsxUserA);

        SqsxUser sqsxUserB = new SqsxUser();
        sqsxUserA.setUsername(name);
        sqsxUserA.setPassword(pwd);
        sqsxUserA.setType(type);
        sqsxUserA.setIsdel(isdel);
        repository.save(sqsxUserB);
    }
}
