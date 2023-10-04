package day03.mapping;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/day03/post")
public class PostMappingController {
    /*
        HttpServletRequest 요청 가능

     */

    @PostMapping("/method1")
    public String method1(@RequestParam String param1){
        System.out.println("PostMappingController.method1");
        System.out.println("param1 = " + param1);

        return "요청 완료";
    }




}
