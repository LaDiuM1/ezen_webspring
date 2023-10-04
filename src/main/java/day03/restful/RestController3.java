package day03.restful;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@RestController
public class RestController3 {
    // 1. GET
    @RequestMapping( value = "/day03/red", method = RequestMethod.GET)
    
    public String getBlack(HttpServletRequest request) throws IOException {

        // 요청
        String param1 = request.getParameter("param1");
        System.out.println("param1 = " + param1); // soutv

        // 응답
        return "안녕 red";


    }

    // 2. POST
    @RequestMapping( value = "/day03/red", method = RequestMethod.POST)
    
    public String postBlack(HttpServletRequest request) throws IOException{

        // 요청
        String param1 = request.getParameter("param1");
        System.out.println("param1 = " + param1); // soutv

        // 응답
        return "안녕 red";

    }
    // 3. PUT
    @RequestMapping( value = "/day03/red", method = RequestMethod.PUT)
    
    public String putBlack(HttpServletRequest request)throws IOException{

        // 요청
        String param1 = request.getParameter("param1");
        System.out.println("param1 = " + param1); // soutv

        // 응답
        return "안녕 red";

    }

    // 4. DELETE
    @RequestMapping( value = "/day03/red", method = RequestMethod.DELETE)
    
    public String deleteBlack(HttpServletRequest request)throws IOException{

        // 요청
        String param1 = request.getParameter("param1");
        System.out.println("param1 = " + param1); // soutv

        // 응답
        return "안녕 red";

    }
}
