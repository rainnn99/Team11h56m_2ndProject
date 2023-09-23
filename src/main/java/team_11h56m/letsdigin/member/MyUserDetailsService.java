//package team_11h56m.letsdigin.member;
//
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Component;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Optional;
//
//@Component
//public class MyUserDetailsService implements UserDetailsService {
//    private final MemberService memberService;
//
//    public MyUserDetailsService(MemberService memberService) {
//        this.memberService = memberService;
//    }
//
//    @Override
//    public UserDetails loadUserByUsername(String memberId) throws UsernameNotFoundException {
//        Optional<Member> memberOptional = memberService.findByMemberId(memberId);
//        if (!memberOptional.isPresent()) {
//            throw new UsernameNotFoundException("User not found with memberId: " + memberId);
//        }
//
//        Member member = memberOptional.get();
//
//        // 사용자의 권한을 설정하기 위한 코드
//        List<GrantedAuthority> authorities = new ArrayList<>();
//        // 사용자가 가지고 있는 권한을 추가합니다.
//        authorities.add(new SimpleGrantedAuthority("ROLE_USER")); // 예시 권한
//
//        // CustomUserDetails 객체를 생성
//        CustomUserDetails customUserDetails = new CustomUserDetails(
//                member.getMemberId(),
//                member.getPassword(),
//                authorities,
//                member.getName(),
//                member.getPhone(),
//                member.getCoupon()
//        );
//
//        // User 객체로 변환하여 리턴
//        return customUserDetails;
//    }
//}
