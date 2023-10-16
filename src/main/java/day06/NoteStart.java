package day06;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication  // 스프링 사용 명시, 설정 파일 읽은 후 해당 기능 제공, 동일 패키지 및 하위 패키지만 기능 제공
public class NoteStart {
    public static void main(String[] args) {
        SpringApplication.run( NoteStart.class ) ;
    }

}
