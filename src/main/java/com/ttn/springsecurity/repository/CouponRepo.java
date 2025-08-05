package com.ttn.springsecurity.repository;

import com.ttn.springsecurity.entity.Coupon;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

public interface CouponRepo extends JpaRepository<Coupon, Long> {
    Coupon findByCode(@Param("code") String code);
}
