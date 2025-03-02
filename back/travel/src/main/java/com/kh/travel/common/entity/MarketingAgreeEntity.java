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
@Table(name = "marketing_agree_th")
@Entity
public class MarketingAgreeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "agree_sq", nullable = false, unique = true, updatable = false)
    Long agreeSq;

    @Column(name = "template_sq", nullable = false, updatable = false)
    Long templateSq;

    // P: 파트너 회원, U: 회원
    @Column(name = "user_type", length = 1, nullable = false, updatable = false)
    String userType;

    @Column(name = "user_id", length = 20, nullable = false, updatable = false)
    String userId;

    // Y / N
    @Column(name = "agree_fl", length = 1, nullable = false)
    String agreeFl;

    @Column(name = "agree_dt", columnDefinition = "timestamp", nullable = false)
    @CreatedDate
    LocalDate agreeDt;

    @Column(name = "dagree_dt", columnDefinition = "timestamp", nullable = false)
    LocalDate dagreeDt;

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
