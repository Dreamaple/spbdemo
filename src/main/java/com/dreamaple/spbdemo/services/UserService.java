package com.dreamaple.spbdemo.services;

import com.dreamaple.spbdemo.dao.repository.UserRepository;
import com.dreamaple.spbdemo.model.UserInfo;
import com.dreamaple.spbdemo.utils.ReturnHelper;
import com.dreamaple.spbdemo.utils.SpringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Date;

public class UserService {
    private UserRepository userRpy;
    private JavaMailSender mailSender;
//    btnSendSms     etSmsCode

    public boolean register(UserRepository userRpy,
                            String username,
                            String nickname,
                            String pwd,
                            String sex,
                            String tel,
                            String birth,
                            String email,
                            String signature,
                            String local) {
        UserInfo userInfo = new UserInfo();
        userInfo.setUserUid("A"+String.format("%04d",userRpy.count()+100001));
        userInfo.setUserUsername(username);
        userInfo.setUserNickname(nickname);
        userInfo.setUserPwd(SpringUtils.getMD5(pwd));
        userInfo.setUserSex(sex);
        userInfo.setUserTel(tel);
        userInfo.setUserBirth(Date.valueOf(birth));
//        try {
//            userInfo.setUserBirth((Date) new SimpleDateFormat("yyyy-MM-dd").parse(birth));
//        } catch (ParseException e) {
//            e.printStackTrace();
//            return false;
//        }
        userInfo.setUserEmail(email);
        userInfo.setUserSignature(signature);
        userInfo.setUserLocal(local);
//        System.out.println( userRpy.toString());
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

    public ReturnHelper<UserInfo> loginWithEmail(String email, String password){
        ReturnHelper<UserInfo> userInfoReturnHelper = new ReturnHelper<>();
        UserInfo userInfo = userRpy.findEmail(email);
        return userInfoReturnHelper;
    }

    public ReturnHelper<UserInfo> loginWithTel(String tel,String password){
        ReturnHelper<UserInfo> userInfoReturnHelper = new ReturnHelper<>();
        UserInfo userInfo = userRpy.findTel(tel);
        return userInfoReturnHelper;
    }

    public ReturnHelper<UserInfo> loginWithUsername(String username,String password){
        ReturnHelper<UserInfo> userInfoReturnHelper = new ReturnHelper<>();
        UserInfo userInfo = userRpy.findUsername(username);
        return userInfoReturnHelper;
    }
}
