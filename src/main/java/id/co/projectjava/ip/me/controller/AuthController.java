package id.co.projectjava.ip.me.controller;

import id.co.projectjava.ip.me.dto.request.LoginRequestDto;
import id.co.projectjava.ip.me.dto.response.JwtResponse;
import id.co.projectjava.ip.me.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/auth")
public class AuthController extends BaseController {
    private final AuthService authService;

    @PostMapping("/login")
    public JwtResponse login(@RequestBody LoginRequestDto requestDto) {
        String token = authService.loginAndGetToken(requestDto.getUsername(), requestDto.getPassword());
        return new JwtResponse(token);
    }
}
