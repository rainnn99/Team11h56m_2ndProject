package team_11h56m.letsdigin.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import team_11h56m.letsdigin.dao.MemberRepository;
import team_11h56m.letsdigin.dto.UserDTO;

import java.util.Optional;

@Component
public class MemberServiceImpl implements MemberService {

    private final MemberRepository memberRepository;

    @Autowired
    public MemberServiceImpl(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Override
    public Member signupUser(Member member) {
        return null;
    }

    @Override
    public Member signupUser(UserDTO userDTO) {
        return null;
    }

    @Override
    public Member getLoggedUser() {

        return null;
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
