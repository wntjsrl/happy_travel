package com.kh.travel.common.errorCode;

import com.kh.travel.common.exception.CommonException;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.experimental.FieldDefaults;
import org.springframework.http.HttpStatus;

import java.util.HashMap;
import java.util.Map;

@Getter
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public enum CommonErrorCode {

    // no validity error
    NO_VALIDITY_ID_BLANK(HttpStatus.BAD_REQUEST, "2000", "아이디는 필수 입력사항입니다."),
    NO_VALIDITY_ID_SIZE(HttpStatus.BAD_REQUEST, "2001", "아이디는 7자리에서 15자리입니다."),
    NO_VALIDITY_PWD_BLANK(HttpStatus.BAD_REQUEST, "2002", "비밀번호는 필수 입력사항입니다."),
    NO_VALIDITY_PWD_SIZE(HttpStatus.BAD_REQUEST, "2003", "비밀번호는 8자리에서 15자리입니다."),
    NO_VALIDITY_PWD_INAPPOSITE(HttpStatus.BAD_REQUEST, "2004", "비밀번호는 숫자, 영어 소문자, 특수문자를 모두 포함해야 합니다."),
    NO_VALIDITY_EMAIL1_BLANK(HttpStatus.BAD_REQUEST, "2005", "이메일은 필수 입력사항입니다."),
    NO_VALIDITY_EMAIL2_BLANK(HttpStatus.BAD_REQUEST, "2006", "이메일 도메인은 필수 입력사항입니다."),
    NO_VALIDITY_EMAIL2_INAPPOSITE(HttpStatus.BAD_REQUEST, "2007", "이메일 도메인은 '.com' 또는 '.net'이어야 합니다."),
    NO_VALIDITY_PHONE_NO_BLANK(HttpStatus.BAD_REQUEST, "2008", "전화번호는 필수 입력사항입니다."),
    NO_VALIDITY_PHONE_NO_INAPPOSITE(HttpStatus.BAD_REQUEST, "2009", "전화번호는 11자리입니다."),
    NO_VALIDITY_USER_TYPE_BLANK(HttpStatus.BAD_REQUEST, "2010", "회원 유형은 필수 입력사항입니다."),
    NO_VALIDITY_DAGREE_DT_BLANK(HttpStatus.BAD_REQUEST, "2011", "마케팅 철회일은 필수 입력사항입니다."),
    NO_VALIDITY_TERMS_TEMPLATE_SQ_BLANK(HttpStatus.BAD_REQUEST, "2012", "약관 번호는 필수 입력사항입니다."),
    NO_VALIDITY_MARKETING_TEMPLATE_SQ_BLANK(HttpStatus.BAD_REQUEST, "2013", "마케팅 번호는 필수 입력사항입니다."),
    NO_VALIDITY_MARKETING_TEMPLATE_FL_BLANK(HttpStatus.BAD_REQUEST, "2014", "마케팅 동의 여부는 필수 입력사항입니다."),
    NO_VALIDITY_USER_ID_EXISTS(HttpStatus.BAD_REQUEST, "2015", "중복되는 아이디입니다."),

    // DB error
    DB_ERROR_USER_CREATE(HttpStatus.INTERNAL_SERVER_ERROR, "3000", "회원가입 실패입니다."),
    DB_ERROR_TERMS_AGREE_CREATE(HttpStatus.INTERNAL_SERVER_ERROR, "3001", "약관 동의 실패입니다."),
    DB_ERROR_MARKETING_AGREE_CREATE(HttpStatus.INTERNAL_SERVER_ERROR, "3002", "마케팅 동의 실패입니다."),
    DB_ERROR_USER_READ(HttpStatus.INTERNAL_SERVER_ERROR, "3003", "가입되지 않은 아이디 또는 잘못된 비밀번호입니다."),

    // common error
    COMMON_ERROR_CODE_NOT_MATCH(HttpStatus.INTERNAL_SERVER_ERROR, "4000", "매칭되는 코드가 존재하지 않습니다."),
    COMMON_ERROR_CODE_MDC_FILTER_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, "4001", "MDC 필터 동작 오류입니다."),
    COMMON_ERROR_CODE_LOGGING_FILTER_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, "4002", "로깅 필터 동작 오류입니다.");

    final HttpStatus status;
    final String code;
    final String message;

    // commonErrorCode의 code와 errorCode 매핑을 위한 준비 작업
    private static final Map<String, CommonErrorCode> errorCodeMap = new HashMap<>();
    static {
        for (CommonErrorCode errorCode : CommonErrorCode.values()) {
            errorCodeMap.put(errorCode.getCode(), errorCode);
        }
    }

    // commonErrorCode의 code와 errorCode 매핑해주는 메서드
    public static CommonErrorCode findErrorCode(String code){
        CommonErrorCode errorCode = errorCodeMap.get(code);

        if (errorCode == null) {
            throw new CommonException(COMMON_ERROR_CODE_NOT_MATCH);
        }
        return errorCode;
    } // findErrorCode
} // enum
