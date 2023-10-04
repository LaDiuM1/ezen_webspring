package day02.Servlet;

import lombok.*;

import java.time.LocalDate;

@Getter @Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class TodoDTO {
    private long tno;
    private String title;
    private LocalDate dueDate;
    private boolean finished;

}
