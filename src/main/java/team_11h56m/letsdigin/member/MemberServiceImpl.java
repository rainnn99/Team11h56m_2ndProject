package team_11h56m.letsdigin.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Component;
import team_11h56m.letsdigin.dao.MemberRepository;
import team_11h56m.letsdigin.dto.MemberDTO;

import java.util.Optional;

@Component
public class MemberServiceImpl implements MemberService {

    private final MemberRepository memberRepository;

    @Autowired
    public MemberServiceImpl(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Override
    public String signUp(MemberDTO memberDTO) {
        try {
            // MemberDTO의 정보를 member 엔티티에 매핑하고 비밀번호를 BCrypt로 암호화하여 저장
            String id = memberDTO.getId();
            // 중복 ID 검사
            Optional<Member> existingMember = memberRepository.findByUserid(id);
            if (existingMember.isPresent()) {
                return "F"; // 중복 ID가 이미 존재할 경우 "F" 반환
            }
            String password = memberDTO.getPassword();
            String name = memberDTO.getName();
            String phoneNumber = memberDTO.getPhone();
            int coupon = 0;

            // 비밀번호 암호화
            String hashedPassword = BCrypt.hashpw(password, BCrypt.gensalt());

            // 회원가입 정보를 DB에 저장
            Member member = new Member(id, hashedPassword, name, phoneNumber, coupon);
            memberRepository.save(member);

            return "T"; // 성공 시 "T" 반환

        } catch (Exception e) {
            e.printStackTrace();
            return "F"; // 실패 시 "F" 반환
        }
    }
    @Override
    public Member getCoupon() {
        return null;
    }

    @Override
    public Member receiveCoupon() {
        return null;
    }

    public Optional<Member> findOne(String userId) {
        return memberRepository.findByUserid(userId);
    }
}
