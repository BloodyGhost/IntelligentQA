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
@RequestMapping("/")
public class SqsxUserController {
    @Autowired
    private SqsxUserRepository sqsxuserRepository;
    @Autowired
    private SqsxUserService sqsxUserService;

    @RequestMapping("a")
    public String a()
    {
        return "hello";
    }

    @GetMapping("findAll")
    public List<SqsxUser> getAll() {
        return sqsxuserRepository.findAll();
    }

    @PostMapping("findByUsername")
    public SqsxUser findByUsername(@RequestParam("username") String username) {
        //通过用户名查找数据库中是否有该用户名
        return sqsxuserRepository.findByUsername(username);
    }

    @PostMapping("sign/up")
    public int save(@RequestParam("username") String username, @RequestParam("password") String password, @RequestParam("type") Integer type)
    {//增加一个用户
            if(findByUsername(username)!=null)
            {
                return 300;

            }else {
                SqsxUser sqsxUser = new SqsxUser();
                sqsxUser.setUsername(username);
                sqsxUser.setPassword(toHash(password));
                sqsxUser.setType(type);
                sqsxUser.setIsdel(0);
                sqsxuserRepository.save(sqsxUser);
                return 200;
            }
    }
    @PostMapping("findById")
    public SqsxUser findById(@RequestParam("id") Integer id) {
        return sqsxuserRepository.findById(id);
    }

    @PostMapping("sign/in")
    public int login(@RequestParam("username") String username, @RequestParam("password") String password) {//登陆，验证结果返回：-1表示失败，1表示成功

        SqsxUser sqsxUser = sqsxuserRepository.findByUsername(username);
        System.out.println(sqsxUser.getId()+sqsxUser.getUsername()+sqsxUser.getPassword()+sqsxUser.getType()+sqsxUser.getIsdel());
        if (sqsxUser!= null && toHash(password) == sqsxUser.getPassword() && sqsxUser.getIsdel()!=1) {
            return 200;
        } else {
                return 300;
        }
      //return 1;
    }
    @PostMapping("profile/modifyPass")
    public int update(@RequestParam("username") String username, @RequestParam("password") String password, @RequestParam("newpassword") String newpassword) {
        SqsxUser sqsxUser = sqsxuserRepository.findByUsername(username);
        if(toHash(password) == sqsxUser.getPassword() && sqsxUser.getIsdel()!=1)
        {
            sqsxUser.setPassword(toHash(newpassword));
            sqsxuserRepository.save(sqsxUser);
            return 200;//根据主键查找并更新
        }else {
            return 300;//密码输入错误
        }
    }
}
