package id.co.projectjava.ip.me.service;

import id.co.projectjava.ip.me.config.JwtUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {
    private final JwtUtil jwtUtil;

    public String loginAndGetToken(String username, String password) {
        return jwtUtil.generateToken(username);
    }
}
