package com.polykek.library.web;

import com.polykek.library.entity.User;
import com.polykek.library.exception.UserExistsException;
import com.polykek.library.repository.UserRepository;
import com.polykek.library.security.jwt.JwtTokenProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {
    private final JwtTokenProvider jwtTokenProvider;
    private final UserRepository userRepository;

    @PostMapping("/signin")
    public ResponseEntity signIn(@RequestBody AuthRequest request) {
        try {
            String name = request.getUserName();
            final var user = userRepository.findUserByUserName(name).orElseThrow(() -> new UsernameNotFoundException("User not found"));

            final boolean passwordsAreEqual = user.getPassword().equals(request.getPassword());
            if (!passwordsAreEqual) {
                throw new BadCredentialsException("Invalid Password");
            }

            String token = jwtTokenProvider.createToken(name,
                    user.getRoles());

            Map<Object, Object> model = new HashMap<>();
            model.put("userName", name);
            model.put("token", token);

            return ResponseEntity.ok(model);
        } catch (AuthenticationException e) {
            throw new BadCredentialsException("Invalid username or password");
        }
    }

    @PostMapping("/signup")
    public ResponseEntity signUp(@RequestBody AuthRequest request) {
        try {
            var userFromDb = userRepository.findUserByUserName(request.getUserName());
            if (userFromDb.isPresent()) {
                throw new UserExistsException();
            }

            var user = new User(
                    request.getUserName(),
                    request.getPassword(),
                    List.of("ROLE_USER")
            );

            userRepository.save(user);

            return ResponseEntity.ok().build();
        } catch (UserExistsException e) {
            return ResponseEntity.status(HttpStatus.resolve(422)).build();
        }
    }
}
