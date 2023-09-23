package team_11h56m.letsdigin.calendar;

import team_11h56m.letsdigin.dto.CalendarDTO;

import java.time.LocalDate;
import java.util.List;

public interface CalendarService {
    public List<CalendarDTO> getMonthlyData(String memberId, LocalDate startDate, LocalDate endDate);

    public List<CalendarDTO> convertToDTOList(List<Calendar> data);

    public CalendarDTO convertToDTO(Calendar entry);

    public boolean updateOrCreateEntry(String memberId, String dateString, String breakfast, String lunch, String dinner);

}
