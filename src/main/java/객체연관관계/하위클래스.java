package 객체연관관계;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class 하위클래스 {
    private int value;
    private 상위클래스 상위객체;
}
