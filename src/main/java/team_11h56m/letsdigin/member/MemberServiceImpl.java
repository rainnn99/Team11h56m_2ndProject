package team_11h56m.letsdigin.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import team_11h56m.letsdigin.dao.MemberRepository;
import team_11h56m.letsdigin.dto.MemberDTO;

import java.util.Optional;

@Component
@Service
public class MemberServiceImpl implements MemberService {

    private final MemberRepository memberRepository;
    private final LoggedMember loggedMember;

    @Autowired
    public MemberServiceImpl(MemberRepository memberRepository, LoggedMember loggedMember) {
        this.memberRepository = memberRepository;
        this.loggedMember = loggedMember;
    }

    @Override
    public String getLoggedMemberId() {
        return loggedMember.getLoggedMember();
    }

    @Override
    public String signUp(MemberDTO memberDTO) {
        try {
            String memberId = memberDTO.getMemberId();
            System.out.println("input afterEach memberId = " + memberId);
            // 중복 ID 검사
            Member NewMember = memberRepository.findByMemberId(memberId);
            if (NewMember != null) {
                return "F"; // 중복 ID가 이미 존재할 경우 "F" 반환
            }
            String password = memberDTO.getPassword();
            String name = memberDTO.getName();
            String phoneNumber = memberDTO.getPhone();
            int coupon = 0;

            // 회원가입 정보를 DB에 저장
            Member member = new Member(memberId, password, name, phoneNumber, coupon);
            memberRepository.save(member);

            return "T"; // 성공 시 "T" 반환

        } catch (Exception e) {
            e.printStackTrace();
            return "F"; // 실패 시 "F" 반환
        }
    }

    @Override
    public int getCouponCount(String userId) {
        Member member = memberRepository.findByMemberId(userId);

        if (member!=null) {
            int couponCount = member.getCoupon();
            return couponCount;
        } else {
            // 사용자 정보가 없으면 0을 반환
            return 0;
        }
    }

    @Override
    public int receiveCoupon(String userId) {
        Member member = memberRepository.findByMemberId(userId);

        if (member!=null) {
            member.setCoupon(member.getCoupon() + 1);
            memberRepository.save(member);
            return member.getCoupon();
        } else {
            return 0;
        }
    }

    @Override
    public Member findByMemberId(String memberId) {
        return memberRepository.findByMemberId(memberId);
    }

//    @Override
//    public String signUp(MemberDTO memberDTO) {
//        try {
//            // MemberDTO의 정보를 member 엔티티에 매핑하고 비밀번호를 BCrypt로 암호화하여 저장
//            String memberId = memberDTO.getMemberId();
//            // 중복 ID 검사
//            Optional<Member> existingMember = memberRepository.findByMemberId(memberId);
//            if (existingMember.isPresent()) {
//                return "F"; // 중복 ID가 이미 존재할 경우 "F" 반환~
//            }
//            String password = memberDTO.getPassword();
//            String name = memberDTO.getName();
//            String phoneNumber = memberDTO.getPhone();
//            int coupon = 0;
//
//            // 비밀번호 암호화
//            String hashedPassword = BCrypt.hashpw(password, BCrypt.gensalt());
//
//            // 회원가입 정보를 DB에 저장
//            Member member = new Member(memberId, hashedPassword, name, phoneNumber, coupon);
//            memberRepository.save(member);
//
//            return "T"; // 성공 시 "T" 반환
//
//        } catch (Exception e) {
//            e.printStackTrace();
//            return "F"; // 실패 시 "F" 반환
//        }
//    }
//    @Override
//    public int getCouponCount(String memberId) {
//        System.out.println("call getcoupon() userId : " + memberId);
//        Optional<Member> optionalMember = memberRepository.findByMemberId(memberId);
//
//        if (optionalMember.isPresent()) {
//            // 사용자 정보가 존재하면 쿠폰 수를 반환
//            Member member = optionalMember.get();
//            return member.getCoupon();
//        } else {
//            // 사용자 정보가 없으면 0을 반환
//            return 0;
//        }
//    }
//
//    @Override
//    public int receiveCoupon(String memberId) {
//        // userId를 이용하여 Member 테이블에서 해당 사용자의 정보를 조회
//        Optional<Member> optionalMember = memberRepository.findByMemberId(memberId);
//
//        if (optionalMember.isPresent()) {
//            // 사용자 정보가 존재하면 쿠폰 수를 +1 증가시키고 저장
//            Member member = optionalMember.get();
//            member.setCoupon(member.getCoupon() + 1);
//            memberRepository.save(member);
//            return member.getCoupon();
//        } else {
//            // 사용자 정보가 없으면 0을 반환
//            return 0;
//        }
//    }
//    @Override
//    public Optional<Member> findByMemberId(String memberId) {
//        return memberRepository.findByMemberId(memberId);
//    }
}
