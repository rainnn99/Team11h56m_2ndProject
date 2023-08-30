package team_11h56m.letsdigin.dao;

import team_11h56m.letsdigin.member.Member;

import java.util.Optional;

public class MemberRepositoryImpl implements MemberRepository{

    @Override
    public Optional<Member> findByUserid(String userId) {
        return Optional.empty();
    }
}
