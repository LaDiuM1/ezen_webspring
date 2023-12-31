package day01.webMvc;

import lombok.*;

import java.time.LocalDate;
@NoArgsConstructor
@AllArgsConstructor
@Getter@Setter
@ToString@Builder

public class WebDto {

    private int no; // todo 번호

    private String title;   // todo 내용

    private LocalDate date; // todo 작성일

    private boolean finished;   // todo 실행여부

}
