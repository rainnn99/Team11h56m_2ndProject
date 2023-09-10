package team_11h56m.letsdigin.member;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import org.springframework.security.crypto.password.PasswordEncoder;

@Entity
public class Member {

    private String name;

    @Id
    @Column(unique = true)
    private String userid;

    private String pw;

    private String phone;

    private int coupon;

    public Member(String name, String userid, String pw, String phone, int coupon) {
        this.name = name;
        this.userid = userid;
        this.pw = pw;
        this.phone = phone;
        this.coupon = coupon;
    }

    public Member() {}

    public String getName() {
        return name;
    }

    public String getUserid() {
        return userid;
    }

    public String getPw() {
        return pw;
    }

    public String getPhone() {
        return phone;
    }

    public int getCoupon() {
        return coupon;
    }

    public void setCoupon(int coupon) {
        this.coupon = coupon;
    }
}
