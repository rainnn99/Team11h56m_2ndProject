package team_11h56m.letsdigin.calendar;

import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.io.Serializable;
import java.time.LocalDate;

@Embeddable
public class CalendarPK implements Serializable {

    private String memberId;

    private LocalDate date;

    public CalendarPK(){}

    public String getMemberId() {
        return memberId;
    }

    public LocalDate getDate() {
        return date;
    }

    public CalendarPK(String memberId, LocalDate date){
        this.memberId = memberId;
        this.date = date;
    }


}