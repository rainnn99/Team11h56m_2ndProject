package team_11h56m.letsdigin.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
    private final LoggedMember loggedMember;

    @Autowired
    public MemberController(MemberService memberService, LoggedMember loggedMember) {
        this.memberService = memberService;
        this.loggedMember = loggedMember;
    }

    @PostMapping("/login")
    public boolean login(@RequestBody MemberDTO request) {
        Member member = memberRepository.findByMemberId(request.getMemberId());
        if (member != null && member.getPassword().equals(request.getPassword())) {
            loggedMember.setLoggedMember(request.getMemberId());
            return true;
        } else {
            return false;
        }
    }

    @GetMapping("/logout")
    public void logout() {
        loggedMember.setLoggedMember(null);
    }

    @PostMapping("/signup")
    public ResponseEntity<String> signUp(@RequestBody MemberDTO request) {
        String result = memberService.signUp(request);

        if ("T".equals(result)) {
            return ResponseEntity.ok("회원가입 성공");
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("회원 가입 실패");
        }
    }

    @GetMapping("/coupon/count")
    public ResponseEntity<Integer> getCouponCount() {
        String MemberId = loggedMember.getLoggedMember();

        int couponCount = memberService.getCouponCount(MemberId);
        System.out.println("called: " + couponCount + " / userId : " + MemberId);
        return ResponseEntity.ok(couponCount);
    }

    @GetMapping("/coupon/receive")
    public ResponseEntity<Integer> receiveCoupon() {
        String MemberId = loggedMember.getLoggedMember();
        int updatedCouponCount = memberService.receiveCoupon(MemberId);
        return ResponseEntity.ok(updatedCouponCount);
    }

    @GetMapping("/user")
    public ResponseEntity<String> logincheck() {
        System.out.println("loggedMember = " + loggedMember.getLoggedMember());
        return ResponseEntity.ok(loggedMember.getLoggedMember());
    }
}

//    @PostMapping("/signup")
//    public ResponseEntity<String> signUp(@RequestBody MemberDTO request) {
//        String result = memberService.signUp(request);
//
//        if ("T".equals(result)) {
//            return ResponseEntity.ok("회원가입 성공");
//        } else {
//            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
//                    .body("회원 가입 실패");
//        }
//    }
//
//    @GetMapping("/coupon/count")
//    public ResponseEntity<Integer> getCouponCount() {
//        // 현재 사용자의 인증 정보를 가져옴
//        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//        System.out.println(authentication);
//        // 인증 정보로부터 사용자 ID를 추출
//        String userId = authentication.getName();
//
//        int couponCount = memberService.getCouponCount(userId);
//        System.out.println("called: " + couponCount + " / userId : " + userId);
//        return ResponseEntity.ok(couponCount);
//    }
//
//    @GetMapping("/coupon/receive")
//    public ResponseEntity<Integer> receiveCoupon() {
//        // 현재 사용자의 인증 정보를 가져옴
//        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//
//        // 인증 정보로부터 사용자 ID를 추출
//        String userId = authentication.getName();
//
//        // Service를 호출하여 쿠폰을 받은 후의 사용자의 쿠폰 수를 가져옴
//        int updatedCouponCount = memberService.receiveCoupon(userId);
//
//        // 쿠폰을 받은 후의 사용자의 쿠폰 수를 클라이언트에 반환\
//        return ResponseEntity.ok(updatedCouponCount);
//    }
//
//    @GetMapping("/check")
//    public ResponseEntity<String> logincheck(){
//        return ResponseEntity.ok("success");
//    }
//}
