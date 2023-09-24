package team_11h56m.letsdigin.calendar;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "calendar")
public class Calendar {
    @EmbeddedId
    private CalendarPK id;

    private String breakfast;

    private String lunch;

    private String dinner;

    public String getBreakfast() {
        return breakfast;
    }

    public void setBreakfast(String breakfast) {
        this.breakfast = breakfast;
    }

    public String getLunch() {
        return lunch;
    }

    public void setLunch(String lunch) {
        this.lunch = lunch;
    }

    public CalendarPK getId() {
        return id;
    }

    public String getDinner() {
        return dinner;
    }

    public void setDinner(String dinner) {
        this.dinner = dinner;
    }



    public Calendar(){}

    public Calendar(CalendarPK id, String breakfast, String lunch, String dinner){
        this.id = id;
        this.breakfast = breakfast;
        this.lunch = lunch;
        this.dinner = dinner;
    }
}
