package day03.mapping;

import org.springframework.web.bind.annotation.*;

@RestController
public class GetMappingController {

    @GetMapping("/day03/white")
    public String getWhite(@RequestParam String param) {

        System.out.println("param = " + param);

        return "안녕 white";
    }

    @GetMapping("/method3")
    public String method3(@RequestParam String param1, @RequestParam int param2){
        System.out.println("GetMappingController.method3");
        System.out.println("param1 = " + param1);
        System.out.println("param2 = " + param2);

        return "메소드3 도착";
    }

    @GetMapping("/method4")
    public String method4(ParamDto dto){
        System.out.println("GetMappingController.method4");
        System.out.println("dto = " + dto);

        return "정상응답";
    }

    @GetMapping("/method5")
    public String method5(@ModelAttribute ParamDto dto){
        System.out.println("GetMappingController.method5");
        System.out.println("dto = " + dto);

        return "정상응답";
    }

    @GetMapping("/method6/{param1}/{param2}") // PathVariable 방식
    public String method6(@PathVariable("param1") String param1, @PathVariable("param2") int param2){
        System.out.println("GetMappingController.method6");
        System.out.println("param1 = " + param1);
        System.out.println("param2 = " + param2);

        return "응답완료";

    }

    @GetMapping("/method7/{param1}/{param2}")
    public String method7(ParamDto dto){
        System.out.println("dto = " + dto);

        return "응답완료";

    }


    @GetMapping("/method8/{param1}/{param2}")
    public String method8(@ModelAttribute ParamDto dto){
        System.out.println("dto = " + dto);

        return "응답완료";

    }

}
