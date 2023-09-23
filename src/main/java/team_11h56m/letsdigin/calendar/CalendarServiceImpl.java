package team_11h56m.letsdigin.calendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import team_11h56m.letsdigin.dao.CalendarRepository;
import team_11h56m.letsdigin.dto.CalendarDTO;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class CalendarServiceImpl implements CalendarService{
    @Autowired
    private CalendarRepository calendarRepository;

    public List<CalendarDTO> getMonthlyData(String memberId, LocalDate startDate, LocalDate endDate){
        List<Calendar> data = calendarRepository.findById_MemberIdAndId_DateBetween(memberId, startDate, endDate);

        return convertToDTOList(data);
    }

    public List<CalendarDTO> convertToDTOList(List<Calendar> data){
        List<CalendarDTO> dtoList = new ArrayList<>();

        for (Calendar entry : data) {
            CalendarDTO dto = new CalendarDTO();

            // Calendar 엔티티에서 필요한 정보 추출하여 DTO에 설정
            CalendarPK pk = entry.getId();
            dto.setMemberId(pk.getMemberId());
            dto.setDate(pk.getDate());
            dto.setBreakfast(entry.getBreakfast());
            dto.setLunch(entry.getLunch());
            dto.setDinner(entry.getDinner());

            dtoList.add(dto);
        }

        return dtoList;
    }

    public CalendarDTO convertToDTO(Calendar entry){
        CalendarDTO dto = new CalendarDTO();
        CalendarPK pk = entry.getId(); // 복합 키를 가져옴
        dto.setMemberId(pk.getMemberId());
        dto.setDate(pk.getDate());
        dto.setBreakfast(entry.getBreakfast());
        dto.setLunch(entry.getLunch());
        dto.setDinner(entry.getDinner());
        return dto;
    }

    public boolean updateOrCreateEntry(String memberId, String dateString, String breakfast, String lunch, String dinner) {
        try {
            // dateString을 LocalDate로 변환
            LocalDate date = LocalDate.parse(dateString);
            System.out.println("memberId = " + memberId);
            System.out.println("dateString = " + dateString);
            System.out.println("breakfast = " + breakfast);
            System.out.println("lunch = " + lunch);
            System.out.println("dinner = " + dinner);

            // DB에서 해당 날짜의 데이터 조회
            Calendar entry = calendarRepository.findById_MemberIdAndId_Date(memberId, date);

            if (entry == null) {
                CalendarPK pkEntry = new CalendarPK(memberId, date);
                entry = new Calendar(pkEntry, breakfast, lunch, dinner);
            } else {
                // 데이터가 있는 경우 수정
                entry.setBreakfast(breakfast);
                entry.setLunch(lunch);
                entry.setDinner(dinner);
            }

            // DB에 저장
            calendarRepository.save(entry);

            return true; // 업데이트 완료
        } catch (Exception e) {
            e.printStackTrace();
            return false; // 업데이트 실패
        }
    }

}
