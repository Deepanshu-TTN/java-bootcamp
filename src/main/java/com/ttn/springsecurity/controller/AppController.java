package com.ttn.springsecurity.controller;

import com.ttn.springsecurity.entity.Coupon;
import com.ttn.springsecurity.entity.Role;
import com.ttn.springsecurity.entity.User;
import com.ttn.springsecurity.repository.CouponRepo;
import com.ttn.springsecurity.repository.RoleRepo;
import com.ttn.springsecurity.repository.UserRepo;
import com.ttn.springsecurity.service.UserDetailServiceImpl;
import com.ttn.springsecurity.service.UserService;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.Set;

@RestController
public class AppController {
    @Autowired
    UserService userService;

    @Autowired
    CouponRepo couponRepo;

    @Autowired
    PasswordEncoder passwordEncoder;

    @PostMapping(value = "/users", params = "role")
    public void createUser(
            @RequestBody User user,
            @RequestParam(value = "role", required = false, defaultValue = "USER") String userRole){

        userService.createUser(user, userRole);
    }

    @PostMapping("/coupons")
    public void createCoupon(@RequestBody Coupon coupon){
        couponRepo.save(coupon);
    }

    @GetMapping("/coupons/{code}")
    public Coupon getCoupon(@PathVariable("code") String code, Principal principal){
//        var principal = (User) user;
        System.out.println(principal.getName() + " accessed code");
        return couponRepo.findByCode(code);
    }

    @PostMapping("/jwt/obtain-token")
    public String obtainToken(@RequestBody User user){
        return userService.obtainUserToken(user);
    }

}
