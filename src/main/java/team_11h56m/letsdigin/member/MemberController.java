package team_11h56m.letsdigin.member;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MemberController {
    // 회원가입, 로그인, 로그아웃 함수 제작 필요

    @PostMapping("/signup")
    public void signupForm() {}

    @GetMapping("/coupon/count")
    public void getCoupon() {}

    @GetMapping("/coupon/receive")
    public void receiveCoupon() {}

}
