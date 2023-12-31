package test.project;

import lombok.*;

import javax.persistence.*;

@Entity
@Table( name = "member")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Builder
// 회원 테이블
public class MemberEntity {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    private int mgno;
    @Column(length = 20, nullable = false)
    private String mid;
    @Column(nullable = false)
    private String mpwd;

}
