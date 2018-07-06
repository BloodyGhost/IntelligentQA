package com.example.db.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 控制层
 * <p/>
 * yutianran 2017/1/19 下午9:02
 */
@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserService userService;

    /**
     * 通用的增删改查(JpaRepository自带)
     *
     * @return
     */
    @GetMapping("findAll")
    public List<User> getAll() {
        return userRepository.findAll();
    }

    @PostMapping("save")
    public User save(@RequestParam("name") String name, @RequestParam("age") Integer age) {
        System.out.println("name=" + name + "\tage=" + age);
        User user = new User();
        user.setName(name);
        user.setAge(age);
        return userRepository.save(user);
    }

    @PostMapping("findOne")
    public User findOne(@RequestParam("id") Integer id) {
        System.out.println("id=" + id);
        return userRepository.findOne(id);
    }

    @PostMapping("update")
    public User update(@RequestParam("id") Integer id, @RequestParam("name") String score, @RequestParam("age") Integer age) {
        System.out.println("name=" + score + "\tage=" + age);
        User user = new User();
        user.setId(id);//带有id,表示更新
        user.setName(score);
        user.setAge(age);
        return userRepository.save(user);
    }


    @PostMapping("delete")
    public void delete(@RequestParam("id") Integer id) {
        System.out.println("id=" + id);
        userRepository.delete(id);
    }

    /**
     * 自定义的操作
     *
     * @param age
     * @return
     */
    @PostMapping("findByAge")
    public List<User> findByAge(@RequestParam("age") Integer age) {
        return userRepository.findByAge(age);
    }

    @PostMapping("addTwo")
    public void addTwo(@RequestParam("a") String a, @RequestParam("b") String b) {
        userService.insertTwo(a, b);
    }
}
