package 객체연관관계;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class 게시물 {
    private int 게시물번호;
    private String 게시물제목;
    private String 게시물내용;
    private 회원 작성한회원;


}
