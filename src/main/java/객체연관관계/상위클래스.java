package 객체연관관계;

import lombok.*;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@ToString
public class 상위클래스 {
    private int data;
    @Builder.Default
    private List<하위클래스> 참조하위클래스들 = new ArrayList<>();
}
