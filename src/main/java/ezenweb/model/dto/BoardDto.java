package ezenweb.model.dto;


import ezenweb.model.entity.BoardEntity;
import ezenweb.model.entity.MemberEntity;
import lombok.*;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter @Builder @ToString
public class BoardDto {

    // 필드 설계
    private int bno;
    private String btitle;
    private String bcontent;
    private int bview;
    private String bfile;
    private LocalDateTime cdate;
    private LocalDateTime udate;
    private MemberEntity memberEntity;


    // dto -> entity

    public BoardEntity toEntity() {

        return BoardEntity.builder()
                .bno(this.bno)
                .btitle(this.btitle)
                .bcontent(this.bcontent)
                .bview(this.bview)
                .bfile(this.bfile)
                .memberEntity(this.memberEntity)
                .build();

    }

}
