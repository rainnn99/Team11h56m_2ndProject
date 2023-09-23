package team_11h56m.letsdigin.member;

import org.springframework.stereotype.Component;

@Component
public class LoggedMember {
    private String LoggedMember;

    public String getLoggedMember() {
        return LoggedMember;
    }

    public void setLoggedMember(String loggedMember) {
        LoggedMember = loggedMember;
    }
}
