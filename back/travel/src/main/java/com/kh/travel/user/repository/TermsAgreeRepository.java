package com.kh.travel.user.repository;

import com.kh.travel.common.entity.TermsAgreeEntity;
import com.kh.travel.common.entity.pk.TermsAgreeCompositePK;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TermsAgreeRepository extends JpaRepository<TermsAgreeEntity, TermsAgreeCompositePK> {
} // interface
