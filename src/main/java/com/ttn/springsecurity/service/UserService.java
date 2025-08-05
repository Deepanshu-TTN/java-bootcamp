package com.ttn.springsecurity.service;

import com.ttn.springsecurity.entity.Role;
import com.ttn.springsecurity.entity.User;
import com.ttn.springsecurity.repository.RoleRepo;
import com.ttn.springsecurity.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class UserService {
    @Autowired
    UserRepo userRepo;
    @Autowired
    PasswordEncoder passwordEncoder;
    @Autowired
    RoleRepo roleRepo;
    @Autowired
    AuthenticationManager authenticationManager;
    @Autowired
    JWTService jtwService;

    public void createUser(User user, String userRole) {
        Role role = roleRepo.findByName(userRole).orElseGet(()->{
            Role trole =  new Role();
            trole.setName(userRole);
            trole.setUsers(Set.of());
            return trole;
        });
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setRoles(Set.of(role));
        userRepo.save(user);
    }

    public String obtainUserToken(User user) {
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                user.getEmail(),
                user.getPassword()
        ));
        if(authentication.isAuthenticated()){
            return  jtwService.generateToken(user.getEmail());
        }
        throw new UsernameNotFoundException("No user wtf");
    }
}
