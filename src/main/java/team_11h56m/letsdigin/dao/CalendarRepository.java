package team_11h56m.letsdigin.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import team_11h56m.letsdigin.calendar.Calendar;

import java.time.LocalDate;
import java.util.List;

public interface CalendarRepository extends JpaRepository<Calendar, String> {
    List<Calendar> findById_MemberIdAndId_DateBetween(String memberId, LocalDate startDate, LocalDate endDate);
    Calendar findById_MemberIdAndId_Date(String memberId, LocalDate date);
}
