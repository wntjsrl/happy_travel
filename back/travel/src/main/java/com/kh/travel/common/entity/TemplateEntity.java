package com.kh.travel.common.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@EntityListeners(AuditingEntityListener.class)
@Table(name = "template_tb")
@Entity
public class TemplateEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "template_sq", nullable = false, unique = true, updatable = false)
    Long templateSq;

    // T: 약관, M: 마케팅, A: 알람
    @Column(name = "mcategory", length = 1, nullable = false)
    String mcategory;

    // 약관 (00: 필수, 01: 선택), 마케팅 (00: SMS 수신, 01: 이메일 수신), 알람 (00: 이메일, 01: 카카오톡, 02: 문자)
    @Column(name = "scategory", length = 2, nullable = false)
    String scategory;

    @Column(name = "title", length = 250, nullable = false)
    String title;

    @Column(name = "content", columnDefinition = "text", nullable = false)
    String content;

    // Y / N
    @Column(name = "use_fl", length = 1, nullable = false)
    String useFl;

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
