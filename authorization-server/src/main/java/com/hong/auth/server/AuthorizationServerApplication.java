package com.hong.auth.server;

import com.hong.auth.server.domain.User;
import com.hong.auth.server.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
 

@SpringBootApplication
public class AuthorizationServerApplication implements CommandLineRunner {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public AuthorizationServerApplication(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public static void main(String[] args) {
        SpringApplication.run(AuthorizationServerApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        User user = User.builder()
                .email("admin@gmail.com")
                .userName("admin")
                .password(passwordEncoder.encode("password"))
                // .password("password")
                .role("ADMIN")
                .build();
        userRepository.save(user);
    }
}

