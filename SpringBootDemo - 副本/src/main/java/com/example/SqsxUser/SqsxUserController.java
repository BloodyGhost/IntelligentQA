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

    // 将字符串转成hash值
    public static int toHash(String key) {
        int arraySize = 11113; // 数组大小一般取质数
        int hashCode = 0;
        for (int i = 0; i < key.length(); i++) { // 从字符串的左边开始计算
            int letterValue = key.charAt(i) - 96;// 将获取到的字符串转换成数字，比如a的码值是97，则97-96=1
            // 就代表a的值，同理b=2；
            hashCode = ((hashCode << 5) + letterValue) % arraySize;// 防止编码溢出，对每步结果都进行取模运算
        }
        return hashCode;
    }

    @PostMapping("save")
    public SqsxUser save(@RequestParam("username") String name, @RequestParam("password") String password, @RequestParam("type") Integer type, @RequestParam("isdel") Integer isdel)
    {//增加一个用户
        int pwd = toHash(password);

       // System.out.println("username=" + name + "\tpassword=" + password+ "\ttype=" + type+ "\tisdel=" + isdel);//验证一下是否正确得到数据

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

    @PostMapping("login")
    public int login(@RequestParam("username") String name, @RequestParam("password") String password)
    {//登陆，验证结果返回：-1表示失败，1表示成功
        int pwd = toHash(password);
        SqsxUser sqsxUser = new SqsxUser();
        sqsxUser.setUsername(name);
        sqsxUser.setPassword(pwd);
        //return sqsxuserRepository.login(name,password);//根据用户名和密码去数据库中匹配
        //SqsxUser user_entity = userDao.findByUsernameAndPassword(user_name,user_pwd);
        if(sqsxuserRepository.login(name,password) == -1)
        {
            return -1;//用户名或密码输入错
        }else {
            return 1;
        }
    }


    @PostMapping("update")
    public SqsxUser update(@RequestParam("username") String name, @RequestParam("password") int pwd, @RequestParam("type") Integer type, @RequestParam("isdel") Integer isdel) {
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
