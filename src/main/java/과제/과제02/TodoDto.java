package 과제.과제02;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter @Builder @ToString
public class TodoDto {

    private int pno;
    private String name;
    private String phone;

}
