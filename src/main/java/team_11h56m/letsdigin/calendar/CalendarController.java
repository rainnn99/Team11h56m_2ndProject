package team_11h56m.letsdigin.calendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import team_11h56m.letsdigin.dto.CalendarDTO;
import team_11h56m.letsdigin.member.LoggedMember;

import java.time.LocalDate;
import java.time.YearMonth;
import java.util.List;
import java.util.Map;

@RestController
public class CalendarController {
    @Autowired
    private CalendarServiceImpl calendarServiceImpl;

    private final LoggedMember loggedMember;

    public CalendarController(LoggedMember loggedMember) {
        this.loggedMember = loggedMember;
    }

    @GetMapping("/calendar/{yearMonthString}")
    public ResponseEntity<List<CalendarDTO>> getMonthlyData(@PathVariable String yearMonthString){
        try {
            String memberId = loggedMember.getLoggedMember();
            // yearMonthString를 년과 월로 분리
            String year = yearMonthString.substring(0, 4);
            String month = yearMonthString.substring(4, 6);

            YearMonth yearMonth = YearMonth.of(Integer.parseInt(year), Integer.parseInt(month));

            // 해당 월의 첫 날과 마지막 날 계산
            LocalDate startDate = yearMonth.atDay(1);
            LocalDate endDate = yearMonth.atEndOfMonth();

            List<CalendarDTO> data = calendarServiceImpl.getMonthlyData(memberId, startDate, endDate);
            return ResponseEntity.ok(data);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @PostMapping("/calendar/update")
    public ResponseEntity<String> updateOrCreateCalendarEntry(@RequestBody Map<String, String> requestBody) {
        try {
            String memberId = loggedMember.getLoggedMember();
            String dateString = requestBody.get("날짜");
            String breakfast = requestBody.get("음식이름1");
            String lunch = requestBody.get("음식이름2");
            String dinner = requestBody.get("음식이름3");

            boolean success = calendarServiceImpl.updateOrCreateEntry(memberId, dateString, breakfast, lunch, dinner);

            if (success) {
                return ResponseEntity.ok("success");
            } else {
                return ResponseEntity.ok("success");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().body("요청 처리 중 오류가 발생했습니다.");
        }
    }
}