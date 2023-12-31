package test.project;

import lombok.*;

import javax.persistence.*;

@Entity
@Table( name = "guest")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Builder
// 비회원 테이블
public class GuestEntity {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    private int mgno;

}
