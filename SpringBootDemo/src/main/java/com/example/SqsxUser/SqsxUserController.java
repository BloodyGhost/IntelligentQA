package com.example.SqsxUser;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 控制层
 * <p/>
 * yutianran 2017/1/19 下午9:02
 */
@RestController
@RequestMapping("sqsxuser")
public class SqsxUserController {

    @Autowired
    private SqsxUserRepository sqsxuserRepository;

    @Autowired
    private SqsxUserService sqsxUserService;

    /**
     * 通用的增删改查(JpaRepository自带)
     *
     * @return
     */
    @GetMapping("findAll")
    public List<SqsxUser> getAll() {
        return sqsxuserRepository.findAll();
    }

    @PostMapping("save")
    public SqsxUser save(@RequestParam("username") String name, @RequestParam("password") String pwd, @RequestParam("type") Integer type, @RequestParam("isdel") Integer isdel) {
        System.out.println("username=" + name + "\tpassword=" + pwd+ "\ttype=" + type+ "\tisdel=" + isdel);
        SqsxUser sqsxUser = new SqsxUser();
        sqsxUser.setUsername(name);
        sqsxUser.setPassword(pwd);
        sqsxUser.setType(type);
        sqsxUser.setIsdel(isdel);
        return sqsxuserRepository.save(sqsxUser);
    }

    @PostMapping("findOne")
    public SqsxUser findOne(@RequestParam("id") Integer id) {
        System.out.println("id=" + id);
        return sqsxuserRepository.findOne(id);
    }

    @PostMapping("update")
    public SqsxUser update(@RequestParam("username") String name, @RequestParam("password") String pwd, @RequestParam("type") Integer type, @RequestParam("isdel") Integer isdel) {
        System.out.println("name=" + name + "\tpassword=" + pwd+ "\ttype=" + type+ "\tisdel=" + isdel);
        SqsxUser sqsxUser = new SqsxUser();
        sqsxUser.setUsername(name);
        sqsxUser.setPassword(pwd);
        sqsxUser.setType(type);
        sqsxUser.setIsdel(isdel);
        return sqsxuserRepository.save(sqsxUser);
    }


    @PostMapping("delete")
    public void delete(@RequestParam("id") Integer id) {
        System.out.println("id=" + id);
        sqsxuserRepository.delete(id);
    }

    /**
     * 自定义的操作
     *
     * @param username
     * @return
     */
//    @PostMapping("findByUsername")
//    public List<SqsxUser> findByUsername(@RequestParam("username") Integer username) {
//        return userRepository.findByUsername(username);
//    }

//    @PostMapping("addTwo")
//    public void addTwo(@RequestParam("a") String a, @RequestParam("b") String b) {
//        userService.insertTwo(a, b);
//    }
}
