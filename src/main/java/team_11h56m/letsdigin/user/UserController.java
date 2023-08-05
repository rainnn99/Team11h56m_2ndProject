package team_11h56m.letsdigin.user;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.*;

@Controller
public class UserController {
    // 회원가입, 로그인, 로그아웃 함수 제작 필요

    @GetMapping("/login")
    public void loginForm() {}

    @GetMapping("/logout")
    public void logoutForm() {}

    @PostMapping("/signup")
    public void signupForm() {}

    @GetMapping("/coupon/count")
    public void getCoupon() {}

    @GetMapping("/coupon/receive")
    public void receiveCoupon() {}

}
