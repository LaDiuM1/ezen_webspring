package 객체연관관계;


import lombok.*;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter @Builder @ToString
public class 회원 {

    private int 회원번호;
    private String 회원아이디;
    private String 회원이름;
    @Builder.Default
    List<게시물> 내가쓴글 = new ArrayList<>();


}
