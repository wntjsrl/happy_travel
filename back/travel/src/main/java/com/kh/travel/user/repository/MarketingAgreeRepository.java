package com.kh.travel.user.repository;

import com.kh.travel.common.entity.MarketingAgreeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MarketingAgreeRepository extends JpaRepository<MarketingAgreeEntity, Long> {
} // interface
