package ezenweb.model.entity;

import ezenweb.model.dto.BoardDto;
import lombok.*;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.DynamicInsert;

import javax.persistence.*;

// 1. 엔티티를 이용한 테이블 생성할 때
@Entity
@Table(name = "board")
@DynamicInsert  // @ColumnDefault가 적용될 수 있도록 해주는 어노테이션
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@ToString
public class BoardEntity extends BaseTime{

    // 필드 설계
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    private int bno;
    @Column(length = 200, nullable = false) // 생략 가능, 커스텀 필드 사용 시 사용
    private String btitle;
    @Column( columnDefinition = "longtext", nullable = true)   // java String은 최대 255자만 지원하므로 longtext 사용 시 다른 방법으로 정의
                                              // columnDefinition : db 지원 형식으로 정의
    private String bcontent;
    @Column()
    @ColumnDefault("0")
    private int bview;
    // BaseTime 클래스가 상속해주는 필드 1.작성일(cdate) 2.수정일(udate)
    @Column( columnDefinition = "longtext", nullable = true)
    private String bfile;
    @Column()
    private int mno;


    // Entity -> dto
    public BoardDto toDto() {

        return BoardDto.builder()
                .bno(this.bno)
                .btitle(this.btitle)
                .bcontent(this.bcontent)
                .bview(this.bview)
                .bfile(this.bfile)
                .mno(this.mno)
                .cdate(this.cdate)
                .udate(this.udate)
                .build();

    }

}
