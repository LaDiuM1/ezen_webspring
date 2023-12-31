package test.project;

import lombok.*;

import javax.persistence.*;


@Entity
@Table( name = "memberinfo")
@NoArgsConstructor
@AllArgsConstructor
@Getter@Setter@ToString@Builder
// 회원 공통 정보 테이블
public class MemberInfoEntity {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    private int mno;                // 테이블 회원 번호
    @Column(columnDefinition = "tinyint", nullable = false)
    private int mtype;              // 회원 비회원 구분 필드
    @Column(nullable = false, length = 20)
    private int mname;              // 회원 이름 공통 필드
    @Column(nullable = false, length = 5)
    private int msex;               // 회원 성별 공통 필드
    @Column(nullable = false, length = 20)
    private int mphone;             // 회원 전화번호 공통 필드
    @Column(nullable = false, length = 10)
    private int mbirth;             // 회원 생년월일 공통 필드
    @Column(nullable = false)
    private int mgno;               // 회원, 비회원 참조 필드


}
