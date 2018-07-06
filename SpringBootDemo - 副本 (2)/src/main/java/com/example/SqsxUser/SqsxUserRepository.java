package com.example.SqsxUser;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 持久层
 * <p/>
 */
@Repository
public interface SqsxUserRepository extends JpaRepository<SqsxUser, Integer> //实体类，主键
{
    //使用JpaRepository简化开发流程，非常舒服地定义简单的service 接口即可，会自动实现
    SqsxUser findByUsername(String username);

//    Integer login(String name, String password);

    SqsxUser findById(Integer id);
}
