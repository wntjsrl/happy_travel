package com.kh.travel.user.dto;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.experimental.FieldDefaults;

@Getter
@Builder
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserLoginRespDTO {

    String userId;
    String email1;
    String email2;
    String phoneNo;
    String userType;
} // class
