package com.dreamaple.spbdemo.services;

import com.dreamaple.spbdemo.dao.repository.UserRepository;
import com.dreamaple.spbdemo.model.UserInfo;
import com.dreamaple.spbdemo.utils.SpringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class UserService {

    @Autowired
    private UserRepository userRpy;
    @Autowired
    private JavaMailSender mailSender;

    public boolean register(String username,
                            String nickname,
                            String pwd,
                            String sex,
                            String tel,
                            String birth,
                            String email,
                            String signature,
                            String local) {
        UserInfo userInfo = new UserInfo();
        userInfo.setUserUsername(username);
        userInfo.setUserNickname(nickname);
        userInfo.setUserPwd(SpringUtils.getMD5(pwd));
        userInfo.setUserSex(sex);
        userInfo.setUserTel(tel);
        try {
            userInfo.setUserBirth((Date) new SimpleDateFormat("yyyy-MM-dd").parse(birth));
        } catch (ParseException e) {
            e.printStackTrace();
            return false;
        }
        userInfo.setUserEmail(email);
        userInfo.setUserSignature(signature);
        userInfo.setUserLocal(local);
        userRpy.save(userInfo);

        return true;
    }

    public boolean verificationEmail(String email){
        String verificationCode = SpringUtils.getVerification();
        UserInfo userInfo = userRpy.findEmail(email);
        userInfo.setColumn0(verificationCode);
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("dreamaple@aliyun.com");
        message.setTo(email);
        message.setSubject("验证邮件");
        message.setText("您此次的验证码为："+verificationCode
                        +"如果非您本人操作，请发送邮件到dreamaple@aliyun.com进行反馈");
        try {
            mailSender.send(message);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public boolean verification(String email,String vCode) {
        UserInfo userInfo = userRpy.findEmail(email);
        if (userInfo.getColumn0().equals(vCode)) {
            userInfo.setColumn0("rig");
            userRpy.save(userInfo);
            return true;
        }else {
            return false;
        }
    }

}
