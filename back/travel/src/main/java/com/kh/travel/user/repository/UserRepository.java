package com.kh.travel.user.repository;

import com.kh.travel.common.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, String> {

    // 회원가입 아이디 중복 검사
    UserEntity findByUserId(String userId);
    
    // 로그인 아이디, 비밀번호 조회
    UserEntity findUserByUserIdAndUserPwd(String userId, String userPwd);
} // interface
