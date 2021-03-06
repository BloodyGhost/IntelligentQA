package com.example.db.User;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 持久层
 * <p/>
 * yutianran 2017/1/19 下午9:04
 */
@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    //通过年龄来查询
    List<User> findByAge(Integer age);
}
