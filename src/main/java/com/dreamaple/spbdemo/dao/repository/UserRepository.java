package com.dreamaple.spbdemo.dao.repository;

import com.dreamaple.spbdemo.model.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserInfo,Long> {

//    public UserInfo findById(Long id);
//
//    public UserInfo save(UserInfo user);

    @Query(value = "SELECT u FROM UserInfo u WHERE u.user_email=:email")
    public UserInfo findEmail(@Param("email") String email);

}
