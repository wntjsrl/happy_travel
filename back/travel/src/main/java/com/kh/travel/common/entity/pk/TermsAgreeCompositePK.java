package com.kh.travel.common.entity.pk;

import lombok.*;
import lombok.experimental.FieldDefaults;

// TermsAgreeEntity를 위한 PK
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class TermsAgreeCompositePK {

    // P: 파트너, U: 회원
    String userType;
    String userId;
    Long templateSq;

//    @Override
//    public boolean equals(Object obj) {
//        if (this == obj) return true;
//        if (!(obj instanceof TermsAgreeCompositePK)) return false;
//        TermsAgreeCompositePK that = (TermsAgreeCompositePK) obj;
//        return userType == that.userType && userId == that.userId && templateSq == that.templateSq;
//    } // equals

//    @Override
//    public int hashCode() {
//        return Objects.hash(userType, userId, templateSq);
//    } // hashCode
} // class
