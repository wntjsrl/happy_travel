package com.kh.travel.common.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@EntityListeners(AuditingEntityListener.class)
@Table(name = "user_tb")
@Entity
public class UserEntity {

    @Id
    @Column(name = "user_id", length = 20, nullable = false, unique = true, updatable = false)
    String userId;

    @Column(name = "user_pwd", length = 15, nullable = false)
    String userPwd;

    @Column(name = "last_Login_Dt", columnDefinition = "timestamp")
    @CreatedDate
    LocalDate lastLoginDt;

    // 회원가입 당시에는 가입일로 초기화
    @Column(name = "pwd_updt_dt", columnDefinition = "timestamp", nullable = false)
    @LastModifiedDate
    LocalDate pwdUpdtDt;

    @Column(name = "email1", length = 15, nullable = false)
    String email1;

    // naver.com / gmail.com / hitel.net
    @Column(name = "email2", length = 15, nullable = false)
    String email2;

    @Column(name = "phone_no", length = 11, nullable = false)
    String phoneNo;

    @Column(name = "reg_user", length = 20, nullable = false, updatable = false)
    String regUser;

    @Column(name = "reg_dtm", columnDefinition = "timestamp", nullable = false, updatable = false)
    @CreatedDate
    LocalDateTime regDtm;

    @Column(name = "updt_user", length = 20)
    String updtUser;

    @Column(name = "updt_dtm", columnDefinition = "timestamp")
    @LastModifiedDate
    LocalDateTime updtDtm;
} // class
