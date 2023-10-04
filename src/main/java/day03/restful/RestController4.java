package day03.restful;

import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@RestController
public class RestController4 {
    // 1. GET
    @GetMapping("/day03/blue")
    public String getBlack(HttpServletRequest request) throws IOException {

        // 요청
        String param1 = request.getParameter("param1");
        System.out.println("param1 = " + param1); // soutv

        // 응답
        return "안녕 blue";
    }

    // 2. POST
    @PostMapping("/day03/blue")
    public String postBlack(HttpServletRequest request) throws IOException{

        // 요청
        String param1 = request.getParameter("param1");
        System.out.println("param1 = " + param1); // soutv

        // 응답
        return "안녕 blue";

    }
    // 3. PUT
    @PutMapping("/day03/blue")
    public String putBlack(HttpServletRequest request)throws IOException{

        // 요청
        String param1 = request.getParameter("param1");
        System.out.println("param1 = " + param1); // soutv

        // 응답
        return "안녕 blue";

    }

    // 4. DELETE
    @DeleteMapping("/day03/blue")
    public String deleteBlack(HttpServletRequest request)throws IOException{

        // 요청
        String param1 = request.getParameter("param1");
        System.out.println("param1 = " + param1); // soutv

        // 응답
        return "안녕 blue";

    }
}
