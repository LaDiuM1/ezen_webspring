package day01.webMvc;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;

@RestController
public class WebController {

    @GetMapping("/day01/doget")
    public List<WebDto> doGet() {
        WebDao consoleDao = new WebDao();
        return consoleDao.doGet();

    }

    @PostMapping("/day01/doget")
    public boolean doPost (String title){
        //        // 인수 받아 dto 생성
        WebDto consoleDto = new WebDto(0, title, LocalDate.now(), false);
        WebDao consoleDao = new WebDao();

        return consoleDao.doPost(consoleDto);
    }

    @GetMapping("test")
    public String test() {
        return "스프링 리턴 테스트";

    }
}
