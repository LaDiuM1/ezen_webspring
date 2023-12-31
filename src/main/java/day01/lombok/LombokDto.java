package day01.lombok;

import lombok.*;

import java.time.LocalDate;

@NoArgsConstructor // 빈 생성자 자동생성
@AllArgsConstructor // 풀 생성자 자동생성
@Getter@Setter  // getter, setter 메소드 자동생성
@ToString   // toString
@Builder    // 빌더 패턴
public class LombokDto {

    private int no; // todo 번호

    private String title;   // todo 내용

    private LocalDate date; // todo 작성일

    private boolean finished;   // todo 실행여부



}
