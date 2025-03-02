package com.kh.travel.user.service;

import com.kh.travel.common.entity.MarketingAgreeEntity;
import com.kh.travel.common.entity.TermsAgreeEntity;
import com.kh.travel.common.entity.UserEntity;
import com.kh.travel.common.entity.pk.TermsAgreeCompositePK;
import com.kh.travel.common.errorCode.CommonErrorCode;
import com.kh.travel.common.exception.CommonException;
import com.kh.travel.user.dto.UserLoginReqDTO;
import com.kh.travel.user.dto.UserLoginRespDTO;
import com.kh.travel.user.dto.UserSignUpReqDTO;
import com.kh.travel.user.dto.UserSignUpRespDTO;
import com.kh.travel.user.repository.MarketingAgreeRepository;
import com.kh.travel.user.repository.TermsAgreeRepository;
import com.kh.travel.user.repository.UserRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;

@RequiredArgsConstructor
@Service
public class UserService {

    private final UserRepository userRepository;
    private final MarketingAgreeRepository marketingAgreeRepository;
    private final TermsAgreeRepository termsAgreeRepository;

    // 회원가입 (회원)
    @Transactional
    public UserSignUpRespDTO userSignUp(UserSignUpReqDTO requestDTO){
        // ID 중복검사
        UserEntity readUserEntity = userRepository.findByUserId(requestDTO.getUserId());
        if(readUserEntity != null){
            throw new CommonException(CommonErrorCode.NO_VALIDITY_USER_ID_EXISTS);
        }

        // insert할 userEntity 생성
        UserEntity userEntity = UserEntity.builder()
                .userId(requestDTO.getUserId())
                .userPwd(requestDTO.getUserPwd())
                .pwdUpdtDt(LocalDate.now())
                .email1(requestDTO.getEmail1())
                .email2(requestDTO.getEmail2())
                .phoneNo(requestDTO.getPhoneNo())
                .regUser(requestDTO.getUserId())
                .regDtm(LocalDateTime.now())
                .build();

        // userEntity insert 결과
        UserEntity createUserEntity = userRepository.save(userEntity);
        if(createUserEntity == null){
            throw new CommonException(CommonErrorCode.DB_ERROR_USER_CREATE);
        }

        // insert할 termsAgreeEntity 생성
        TermsAgreeCompositePK termsAgreeCompositePK = TermsAgreeCompositePK.builder()
                .userType(requestDTO.getUserType())
                .userId(requestDTO.getUserId())
                .templateSq(requestDTO.getTermsTemplateSq())
                .build();
        TermsAgreeEntity termsAgreeEntity = TermsAgreeEntity.builder()
                .id(termsAgreeCompositePK)
                .agreeFl("Y")
                .agreeDt(LocalDate.now())
                .regUser(requestDTO.getUserId())
                .regDtm(LocalDateTime.now())
                .build();

        // termsAgreeEntity insert 결과
        TermsAgreeEntity createTermsAgreeEntity = termsAgreeRepository.save(termsAgreeEntity);
        if(createTermsAgreeEntity == null){
            throw new CommonException(CommonErrorCode.DB_ERROR_TERMS_AGREE_CREATE);
        }

        // insert할 marketingAgreeEntity 생성
        MarketingAgreeEntity marketingAgreeEntity = MarketingAgreeEntity.builder()
                .templateSq(requestDTO.getMarketingTemplateSq())
                .userType(requestDTO.getUserType())
                .userId(requestDTO.getUserId())
                .agreeDt(LocalDate.now())
                .agreeFl(requestDTO.getMarketingAgreeFl())
                .dagreeDt(requestDTO.getDagreeDt())
                .regUser(requestDTO.getUserId())
                .regDtm(LocalDateTime.now())
                .build();

        // marketingAgreeEntity insert 결과
        MarketingAgreeEntity createMarketingAgreeEntity = marketingAgreeRepository.save(marketingAgreeEntity);
        if(createMarketingAgreeEntity == null){
            throw new CommonException(CommonErrorCode.DB_ERROR_MARKETING_AGREE_CREATE);
        }

        return UserSignUpRespDTO.builder()
                .userId(createUserEntity.getUserId())
                .userType(createTermsAgreeEntity.getId().getUserType())
                .email1(createUserEntity.getEmail1())
                .email2(createUserEntity.getEmail2())
                .phoneNo(createUserEntity.getPhoneNo())
                .build();
    } // userSignUp

    // 로그인 (회원)
    public UserLoginRespDTO userLogin(UserLoginReqDTO requestDTO){
        // 로그인 결과
        UserEntity readUserById = userRepository.findUserByUserIdAndUserPwd(requestDTO.getUserId(), requestDTO.getUserPwd());
        if(readUserById == null){
            throw new CommonException(CommonErrorCode.DB_ERROR_USER_READ);
        }

        return UserLoginRespDTO.builder()
                .userId(readUserById.getUserId())
                .email1(readUserById.getEmail1())
                .email2(readUserById.getEmail2())
                .phoneNo(readUserById.getPhoneNo())
                .build();
    } // userLogin
} // class
