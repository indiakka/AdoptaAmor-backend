package com.adoptaamor.adoptaamor.config;

import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Autowired;
import com.adoptaamor.adoptaamor.repositories.UserRepository;

import jakarta.annotation.PostConstruct;

import com.adoptaamor.adoptaamor.models.User;
import com.adoptaamor.adoptaamor.models.role.Role;
import org.springframework.security.crypto.password.PasswordEncoder;

@Component
public class AdminInitializer {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostConstruct
    public void init() {
        if (userRepository.findByEmail("admin@gmail.com").isEmpty()) {
            User admin = User.builder()
                    .name("Admin")
                    .lastname("Admin")
                    .email("admin@gmail.com")
                    .password(passwordEncoder.encode("1111"))
                    .dni("12345678h")
                    .role(Role.ADMIN)
                    .build();

            userRepository.save(admin);
            System.out.println("Administrador creado: admin@gmail.com / 1111");
        }
    }
}
