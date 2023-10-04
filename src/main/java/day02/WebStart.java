package day02;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@ServletComponentScan// 해당 프로젝트 추가적인 서블릿을 정의했을때
@SpringBootApplication
public class WebStart {
    public static void main(String[] args) {
        SpringApplication.run(WebStart.class);

    }
}


/*
    스프링부트의 시작
        1. 해당 클래스의 @SpringBootApplication
        2. main선언 [ 쓰레드 1개 필요 ]
        3. main 함수 정의
            SpringApplication.run() : 스프링 시작 함수.
            SpringApplication.run( 현재클래스.Class ) : 현재클래스를 스프링이 시작







 */