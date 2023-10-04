package day01.consoleMvc;

import java.time.LocalDate;
import java.util.List;

public class ConsoleController {

    public List<ConsoleDto> doGet() {
        ConsoleDao consoleDao = new ConsoleDao();
        return consoleDao.doGet();

    }

    public boolean doPost (String title){
        // 인수 받아 dto 생성
        ConsoleDto consoleDto = new ConsoleDto(0, title, LocalDate.now(), false);
        ConsoleDao consoleDao = new ConsoleDao();

        return consoleDao.doPost(consoleDto);
    }

}
