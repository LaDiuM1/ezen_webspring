package ezenweb.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration  // 스프링 컨테이너에 빈 등록
public class SpringMvcViewConfig extends WebMvcConfigurerAdapter {

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        //super.addViewControllers(registry);
        registry.addViewController( "/{spring:\\w+}").setViewName("forward:/");
        registry.addViewController( "/**/{spring:\\w+}").setViewName("forward:/");
        registry.addViewController( "/{spring:\\w+}/**{spring:?!(\\.js|\\.css)$}").setViewName("forward:/");
    }
}


/*
    기존에는 스프링 MVC에서 controller가 view를 반환
    리액트와 스프링 통합 시 get 요청 시 스프링이 우선 시 되어 리액트가 반환이 안되는 문제 발생
    해결 : get 요청 시 view를 찾을 때 view를 찾는 위치를 resource로 설정

    1. 스프링 설정 클래스 생성
    2. extends WebMvcConfigurerAdapter : MVC 아키텍처 연결 설정 커스텀 해주는 클래스
    3. 오른쪽클릭 -> 생성 -> 오버라이딩
    4. addViewControllers 오버라이딩

 */