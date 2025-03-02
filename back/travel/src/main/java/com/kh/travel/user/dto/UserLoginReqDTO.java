package com.kh.travel.user.dto;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.experimental.FieldDefaults;

@Getter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserLoginReqDTO {

    String userId;
    String userPwd;
} // class
