package com.polykek.library;

import com.polykek.library.entity.User;
import com.polykek.library.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Collections;

@Component
@RequiredArgsConstructor
public class RolesInit implements CommandLineRunner {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public void run(String... args) throws Exception {
        //userRepository.save(new User("user", passwordEncoder.encode("default"), Collections.singletonList("ROLE_USER")));
        //userRepository.save(new User("admin", passwordEncoder.encode("root"), Collections.singletonList("ROLE_ADMIN")));
    }
}
