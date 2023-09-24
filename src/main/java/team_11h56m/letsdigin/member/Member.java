package team_11h56m.letsdigin.member;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "member")
public class Member {

    private String name;

    @Id
    @Column(name = "member_id", unique = true)
    private String memberId;

    private String password;

    private String phone;

    private int coupon;

    public Member(String name, String memberId, String password, String phone, int coupon) {
        this.name = name;
        this.memberId = memberId;
        this.password = password;
        this.phone = phone;
        this.coupon = coupon;
    }

    public Member() {}

    public String getName() {
        return name;
    }

    public String getMemberId() {
        return memberId;
    }

    public String getPassword() {
        return password;
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
