package com.kh.travel.user.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;

@Getter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserSignUpReqDTO {

    @NotBlank(message = "2000")
    @Size(min = 7, max = 15, message = "2001")
    String userId;

    @NotBlank(message = "2002")
    @Size(min = 10, max = 15, message = "2003")
    @Pattern(regexp = "^(?=.*[0-9])(?=.*[!@#$%^&*()_+\\-=\\[\\]{};':\"\\\\|,.<>\\/?])(?=.*[a-z]).+$", message = "2004")
    String userPwd;

    @NotBlank(message = "2005")
    String email1;

    @NotBlank(message = "2006")
    @Pattern(regexp = ".*\\.(com|net)$", message = "2007")
    String email2;

    @NotBlank(message = "2008")
    @Size(min = 11, max = 11, message = "2009")
    String phoneNo;

    @NotBlank(message = "2010")
    String userType;

    @NotNull(message = "2011")
    LocalDate dagreeDt;

    @NotNull(message = "2012")
    Long termsTemplateSq;

    @NotNull(message = "2013")
    Long marketingTemplateSq;

    @NotBlank(message = "2014")
    String marketingAgreeFl;
} // class
