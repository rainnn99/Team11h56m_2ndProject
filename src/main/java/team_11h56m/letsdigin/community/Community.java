package team_11h56m.letsdigin.community;

import jakarta.persistence.*;

@Entity
@Table(name = "community")
public class Community {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int serialNumber;

    private String memberId;

    private String title;

    @Column(columnDefinition = "LONGTEXT")
    private String mainText;

    public Community(int serialNumber, String memberId, String title, String mainText){
        this.serialNumber = serialNumber;
        this.memberId = memberId;
        this.title = title;
        this.mainText = mainText;
    }

    public Community() {}

    public int getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(int serialNumber) {
        this.serialNumber = serialNumber;
    }

    public String getMemberId() {
        return memberId;
    }

    public void setMemberId(String memberId) {
        this.memberId = memberId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getMainText() {
        return mainText;
    }

    public void setMainText(String mainText) {
        this.mainText = mainText;
    }
}
