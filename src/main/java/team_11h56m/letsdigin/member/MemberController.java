package team_11h56m.letsdigin.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import team_11h56m.letsdigin.dao.MemberRepository;
import team_11h56m.letsdigin.dto.MemberDTO;

@RestController
public class MemberController {
    @Autowired
    private MemberService memberService;
    @Autowired
    private MemberRepository memberRepository;
    @Autowired
    public MemberController(MemberService memberService){
        this.memberService = memberService;
    }

    @PostMapping("/signup")
    public ResponseEntity<String> signUp(@RequestBody MemberDTO request) {
        String result = memberService.signUp(request);

        if ("T".equals(result)) {
            return ResponseEntity.ok("회원가입 성공");
        } else {
            return ResponseEntity.ok("회원가입 실패");
        }
    }

    @GetMapping("/coupon/count")
    public void getCoupon() {}

    @GetMapping("/coupon/receive")
    public void receiveCoupon() {}

}
