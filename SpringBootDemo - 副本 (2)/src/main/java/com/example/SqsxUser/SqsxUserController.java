package com.example.SqsxUser;

import com.example.Utils.ToHash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.example.Utils.ToHash.toHash;

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

    @PostMapping("findByUsername")
    public SqsxUser findByUsername(@RequestParam("username") String username) {
        //通过用户名查找数据库中是否有该用户名
        return sqsxuserRepository.findByUsername(username);
    }

    @PostMapping("save")
    public SqsxUser save(@RequestParam("username") String username, @RequestParam("password") String password, @RequestParam("type") Integer type, @RequestParam("isdel") Integer isdel)
    {//增加一个用户
       // System.out.println("username=" + name + "\tpassword=" + password+ "\ttype=" + type+ "\tisdel=" + isdel);//验证一下是否正确得到数据
            SqsxUser sqsxUser = new SqsxUser();
            sqsxUser.setUsername(username);
            sqsxUser.setPassword(toHash(password));
            sqsxUser.setType(type);
            sqsxUser.setIsdel(isdel);

            return sqsxuserRepository.save(sqsxUser);

    }

    @PostMapping("findById")
    public SqsxUser findById(@RequestParam("id") Integer id) {
        return sqsxuserRepository.findById(id);
    }

    @PostMapping("login")
    public int login(@RequestParam("username") String username, @RequestParam("password") String password)
    {//登陆，验证结果返回：-1表示失败，1表示成功
        SqsxUser sqsxUser = sqsxuserRepository.findByUsername(username);//根据用户名去苦中查找该用户
       // if()
        if(toHash(password) == sqsxUser.getPassword())
        {
            return 1;//用户名或密码输入错
        }else {
            return -1;
        }
    }


    @PostMapping("update")
    public SqsxUser update(@RequestParam("username") String name, @RequestParam("password") Integer pwd, @RequestParam("type") Integer type, @RequestParam("isdel") Integer isdel) {
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


//    @PostMapping("addTwo")
//    public void addTwo(@RequestParam("a") String a, @RequestParam("b") String b) {
//        userService.insertTwo(a, b);
//    }
}
