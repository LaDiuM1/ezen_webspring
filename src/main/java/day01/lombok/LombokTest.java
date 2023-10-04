package day01.lombok;

import java.time.LocalDate;

public class LombokTest {
    public static void main(String[] args) {


    // - 롬복이 없을때 DTO
        // 기본 생성자
       // LombokDto consoleDto = new ConsoleDto();
        // 풀 생성자
       // LombokDto consoleDto2 = new ConsoleDto(0,"공부", LocalDate.now(), true);
        // getter or setter
    //consoleDto.setTitle("공부하기");
    //consoleDto.getTitle();
        // toString
    // 5.
        // 1. 만들어져 있는 생성자가 아닌 새로운 생성자 사용하고 싶을때는 새로 만들어야함
        // 2. 생성자 생성 시 매개변수의 순서가 다르면 오류 발생 ( 정의된 생성자만 사용 가능 )


    // - 롬복이 있을때 DTO
    LombokDto lombokDto1 = new LombokDto();
    LombokDto lombokDto2 = new LombokDto(0,"공부", LocalDate.now(), true);
    LombokDto lombokDto3 = LombokDto.builder().title("공부").finished(true).build();
    LombokDto lombokDto4 = LombokDto.builder().finished(true).title("공부").date(LocalDate.now()).no(0).build();




    }
}
