package com.kh.travel.common.entity;

import com.kh.travel.common.entity.pk.TermsAgreeCompositePK;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@EntityListeners(AuditingEntityListener.class)
@Table(name = "terms_agree_th")
@Entity
public class TermsAgreeEntity {

    // P: 파트너, U: 회원
    @EmbeddedId
    TermsAgreeCompositePK id;

    // Y
    @Column(name = "agree_fl", length = 1, nullable = false)
    String agreeFl;

    @Column(name = "agree_dt", columnDefinition = "timestamp", nullable = false)
    @CreatedDate
    LocalDate agreeDt;

    @Column(name = "reg_user", length = 20, nullable = false, updatable = false)
    String regUser;

    @Column(name = "reg_dtm", columnDefinition = "timestamp", nullable = false, updatable = false)
    @CreatedDate
    LocalDateTime regDtm;
} // class
