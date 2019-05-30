package com.dreamaple.spbdemo.controller;

import com.alibaba.fastjson.JSONObject;
import com.dreamaple.spbdemo.dao.repository.UserRepository;
import com.dreamaple.spbdemo.model.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class IndexController {
    @Autowired
    private UserRepository userRpy;
    @Autowired
    private JavaMailSender mailSender;

    @RequestMapping(value = "/index", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
    public String index() {
        JSONObject jsonObject = new JSONObject();
        Optional<UserInfo> byId = userRpy.findById(2L);
        List<UserInfo> all = userRpy.findAll();
        if (byId.isPresent()) {
            UserInfo userInfo = byId.get();
            jsonObject.put("nickname", userInfo.getUserNickname());
        }
//        userInfo.toString();
//        return jsonObject.toJSONString();
        return all.get(0).toJSONObject().toJSONString();
    }



}
