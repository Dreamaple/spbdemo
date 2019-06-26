package com.dreamaple.spbdemo.model;


import com.alibaba.fastjson.JSONObject;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "user_info")
//@MappedSuperclass
public class UserInfo implements Serializable {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private long userInfoId;
  @Column(name = "user_uid")
  private String userUid;
  @Column(name = "user_username")
  private String userUsername;
  @Column(name = "user_nickname")
  private String userNickname;
  @Column(name = "user_pwd")
  private String userPwd;
  @Column(name = "user_sex")
  private String userSex;
  @Column(name = "user_tel")
  private String userTel;
  @Column(name = "user_birth")
  private java.sql.Date userBirth;
  @Column(name = "user_local")
  private String userLocal;
  @Column(name = "user_exp")
  private long userExp;
  @Column(name = "user_email")
  private String userEmail;
  @Column(name = "user_signature")
  private String userSignature;
  @Column(name = "user_token")
  private String userToken;
  @Column(name = "user_rigstatus")
  private String userRigstatus;
  @Column(name = "column1")
  private String column1;
  @Column(name = "column2")
  private String column2;
  @Column(name = "column3")
  private String column3;
  @Column(name = "column4")
  private String column4;
  @Column(name = "column0")
  private String column0;
  @Column(name = "user_column1")
  private String userColumn1;
  @Column(name = "user_column2")
  private String userColumn2;
  @Column(name = "user_column3")
  private String userColumn3;
  @Column(name = "user_column4")
  private String userColumn4;
  @Column(name = "user_column0")
  private String userColumn0;

  public String getUserColumn1() {
    return userColumn1;
  }

  public void setUserColumn1(String userColumn1) {
    this.userColumn1 = userColumn1;
  }

  public String getUserColumn2() {
    return userColumn2;
  }

  public void setUserColumn2(String userColumn2) {
    this.userColumn2 = userColumn2;
  }

  public String getUserColumn3() {
    return userColumn3;
  }

  public void setUserColumn3(String userColumn3) {
    this.userColumn3 = userColumn3;
  }

  public String getUserColumn4() {
    return userColumn4;
  }

  public void setUserColumn4(String userColumn4) {
    this.userColumn4 = userColumn4;
  }

  public String getUserColumn0() {
    return userColumn0;
  }

  public void setUserColumn0(String userColumn0) {
    this.userColumn0 = userColumn0;
  }

  public String getUserToken() {
    return userToken;
  }

  public void setUserToken(String userToken) {
    this.userToken = userToken;
  }

  public String getUserRigstatus() {
    return userRigstatus;
  }

  public void setUserRigstatus(String userRigstatus) {
    this.userRigstatus = userRigstatus;
  }



  public long getUserInfoId() {
    return userInfoId;
  }

  public void setUserInfoId(long userInfoId) {
    this.userInfoId = userInfoId;
  }


  public String getUserUid() {
    return userUid;
  }

  public void setUserUid(String userUid) {
    this.userUid = userUid;
  }


  public String getUserUsername() {
    return userUsername;
  }

  public void setUserUsername(String userUsername) {
    this.userUsername = userUsername;
  }


  public String getUserNickname() {
    return userNickname;
  }

  public void setUserNickname(String userNickname) {
    this.userNickname = userNickname;
  }


  public String getUserPwd() {
    return userPwd;
  }

  public void setUserPwd(String userPwd) {
    this.userPwd = userPwd;
  }


  public String getUserSex() {
    return userSex;
  }

  public void setUserSex(String userSex) {
    this.userSex = userSex;
  }


  public String getUserTel() {
    return userTel;
  }

  public void setUserTel(String userTel) {
    this.userTel = userTel;
  }


  public java.sql.Date getUserBirth() {
    return userBirth;
  }

  public void setUserBirth(java.sql.Date userBirth) {
    this.userBirth = userBirth;
  }


  public String getUserLocal() {
    return userLocal;
  }

  public void setUserLocal(String userLocal) {
    this.userLocal = userLocal;
  }


  public long getUserExp() {
    return userExp;
  }

  public void setUserExp(long userExp) {
    this.userExp = userExp;
  }


  public String getUserEmail() {
    return userEmail;
  }

  public void setUserEmail(String userEmail) {
    this.userEmail = userEmail;
  }


  public String getUserSignature() {
    return userSignature;
  }

  public void setUserSignature(String userSignature) {
    this.userSignature = userSignature;
  }


  public String getColumn1() {
    return column1;
  }

  public void setColumn1(String column1) {
    this.column1 = column1;
  }


  public String getColumn2() {
    return column2;
  }

  public void setColumn2(String column2) {
    this.column2 = column2;
  }


  public String getColumn3() {
    return column3;
  }

  public void setColumn3(String column3) {
    this.column3 = column3;
  }


  public String getColumn4() {
    return column4;
  }

  public void setColumn4(String column4) {
    this.column4 = column4;
  }


  public String getColumn0() {
    return column0;
  }

  public void setColumn0(String column0) {
    this.column0 = column0;
  }

  public JSONObject toJSONObject(){
    JSONObject jsonObject = new JSONObject();
    jsonObject.put("user_uid",userUid);
    jsonObject.put("user_username",userUsername);
    jsonObject.put("user_nickname",userNickname);
    jsonObject.put("user_pwd",userPwd);
    jsonObject.put("user_sex",userSex);
    jsonObject.put("user_tel",userTel);
    jsonObject.put("user_birth",userBirth);
    jsonObject.put("user_local",userLocal);
    jsonObject.put("user_exp",userExp);
    jsonObject.put("user_email",userEmail);
    jsonObject.put("user_signature",userSignature);
    jsonObject.put("user_token",userToken);
    jsonObject.put("user_rigstatus",userRigstatus);
    jsonObject.put("user_column1",userColumn1);
    jsonObject.put("user_column2",userColumn2);
    jsonObject.put("user_column3",userColumn3);
    jsonObject.put("user_column4",userColumn4);
    jsonObject.put("user_column0",userColumn0);
    jsonObject.put("column1",column1);
    jsonObject.put("column2",column2);
    jsonObject.put("column3",column3);
    jsonObject.put("column4",column4);
    jsonObject.put("column0",column0);
    return jsonObject;
  }
}
