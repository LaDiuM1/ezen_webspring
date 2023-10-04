package day03.restful;

import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@RestController
@RequestMapping( value = "/day03" ) // 상위 URL 정의
public class RestController5 {
    // 1. GET
    @GetMapping("/pink")
    public String getBlack(HttpServletRequest request) throws IOException {

        // 요청
        String param1 = request.getParameter("param1");
        System.out.println("param1 = " + param1); // soutv

        // 응답
        return "안녕 pink";
    }

    // 2. POST
    @PostMapping("/pink")
    public String postBlack(HttpServletRequest request) throws IOException{

        // 요청
        String param1 = request.getParameter("param1");
        System.out.println("param1 = " + param1); // soutv

        // 응답
        return "안녕 pink";

    }
    // 3. PUT
    @PutMapping("/pink")
    public String putBlack(HttpServletRequest request)throws IOException{

        // 요청
        String param1 = request.getParameter("param1");
        System.out.println("param1 = " + param1); // soutv

        // 응답
        return "안녕 pink";

    }

    // 4. DELETE
    @DeleteMapping("/pink")
    public String deleteBlack(HttpServletRequest request)throws IOException{

        // 요청
        String param1 = request.getParameter("param1");
        System.out.println("param1 = " + param1); // soutv

        // 응답
        return "안녕 pink";

    }
}
