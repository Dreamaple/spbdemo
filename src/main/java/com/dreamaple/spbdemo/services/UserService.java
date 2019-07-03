package com.dreamaple.spbdemo.services;

import com.dreamaple.spbdemo.dao.repository.UserRepository;
import com.dreamaple.spbdemo.model.UserInfo;
import com.dreamaple.spbdemo.utils.ReturnHelper;
import com.dreamaple.spbdemo.utils.SpringUtils;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

import java.sql.Date;

public class UserService {
//    private UserRepository userRpy;
//    private JavaMailSender mailSender;
//    btnSendSms     etSmsCode

    /**
     * 用户注册
     *
     * @param userRpy   UserRepository 用户表的JPA
     * @param username  用户名
     * @param nickname  昵称
     * @param pwd       密码
     * @param sex       性别 1为男性 0为女性
     * @param tel       电话号码
     * @param birth     生日 YYYY-mm-SS
     * @param email     电子邮箱
     * @param signature 个性签名
     * @param local     位置
     * @return
     */
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
        userInfo.setUserUid("A" + String.format("%04d", userRpy.count() + 100001));
        userInfo.setUserUsername(username);
        userInfo.setUserNickname(nickname);
        userInfo.setUserPwd(SpringUtils.getMD5(pwd));
        userInfo.setUserSex(sex);
        userInfo.setUserTel(tel);
        userInfo.setUserBirth(Date.valueOf(birth));
        userInfo.setUserEmail(email);
        userInfo.setUserSignature(signature);
        userInfo.setUserLocal(local);
        userRpy.save(userInfo);

        return true;
    }

    /**
     * 发送验证邮件
     *
     * @param userRpy    UserRepository 用户表的JPA
     * @param mailSender JavaMailSender 邮件发送对象
     * @param email      目标邮箱
     * @return
     */
    public boolean verificationEmail(UserRepository userRpy, JavaMailSender mailSender, String email) {
        String verificationCode = SpringUtils.getVerification();
        UserInfo userInfo = userRpy.findEmail(email);
        userInfo.setColumn0(verificationCode);
//        SpbdemoApplication
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("dreamaple@aliyun.com");
        message.setTo(email);
        message.setSubject("验证邮件");
        message.setText("您此次的验证码为：" + verificationCode
                + "如果非您本人操作，请发送邮件到dreamaple@aliyun.com进行反馈");
        try {
            mailSender.send(message);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    /**
     * 验证邮箱验证码
     *
     * @param userRpy UserRepository 用户表的JPA
     * @param email   注册邮箱
     * @param vCode   验证码
     * @return
     */
    public boolean verification(UserRepository userRpy, String email, String vCode) {
        UserInfo userInfo = userRpy.findEmail(email);
        if (userInfo.getColumn0().equals(vCode)) {
            userInfo.setColumn0("rig");
            userRpy.save(userInfo);
            return true;
        } else {
            return false;
        }
    }

    /**
     * @param userRpy  UserRepository 用户表的JPA
     * @param email    注册邮箱
     * @param password 密码
     * @return
     */
    public ReturnHelper<UserInfo> loginWithEmail(UserRepository userRpy, String email, String password) {
        ReturnHelper<UserInfo> userInfoReturnHelper = new ReturnHelper<>();
        UserInfo userInfo = userRpy.findEmail(email);
        if (userInfo == null) {
            userInfoReturnHelper.setStatus(ReturnHelper.S_NULL);
            return userInfoReturnHelper;
        }
        if (userInfo.getUserPwd().equals(password)) {
            userInfoReturnHelper.setStatus(ReturnHelper.S_SUCCESSED);
            userInfoReturnHelper.setT(userInfo);
        }
        return userInfoReturnHelper;
    }

    /**
     * @param userRpy  UserRepository 用户表的JPA
     * @param tel      注册的手机号
     * @param password 密码
     * @return
     */
    public ReturnHelper<UserInfo> loginWithTel(UserRepository userRpy, String tel, String password) {
        ReturnHelper<UserInfo> userInfoReturnHelper = new ReturnHelper<>();
        UserInfo userInfo = userRpy.findTel(tel);
        return userInfoReturnHelper;
    }

    /**
     * @param userRpy  UserRepository 用户表的JPA
     * @param username 用户名
     * @param password 密码
     * @return
     */
    public ReturnHelper<UserInfo> loginWithUsername(UserRepository userRpy, String username, String password) {
        ReturnHelper<UserInfo> userInfoReturnHelper = new ReturnHelper<>();
        UserInfo userInfo = userRpy.findUsername(username);
        return userInfoReturnHelper;
    }
}
