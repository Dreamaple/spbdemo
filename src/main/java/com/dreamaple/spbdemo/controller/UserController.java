package com.dreamaple.spbdemo.controller;


import com.dreamaple.spbdemo.dao.repository.UserRepository;
import com.dreamaple.spbdemo.services.UserService;
import com.dreamaple.spbdemo.utils.SpringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    private UserRepository userRpy;
    @Autowired
    private JavaMailSender mailSender;

    private UserService userService = new UserService();

    @RequestMapping(value = "/user/register", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public String register(@RequestParam String username,
                            @RequestParam String nickname,
                            @RequestParam String pwd,
                            @RequestParam String sex,
                            @RequestParam String tel,
                            @RequestParam String birth,
                            @RequestParam String email,
                            @RequestParam String signature,
                            @RequestParam String local) {
        if (userService.register(userRpy,username, nickname, pwd, sex, tel, birth, email, signature, local)) {
            return SpringUtils.getReturn("successed").toJSONString();
        } else {
            return SpringUtils.getReturn("1","请求失败").toJSONString();
        }
//        return SpringUtils.getReturn("1", "success").toJSONString();
    }
    @RequestMapping(value = "/confirmEmail", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public String confirmEmail(@RequestParam String param1,
                               @RequestParam String param2,
                               @RequestParam String param3) {

        return "发送成功";
    }
}
