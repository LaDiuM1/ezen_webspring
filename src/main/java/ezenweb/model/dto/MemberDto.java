package ezenweb.model.dto;


import ezenweb.model.entity.MemberEntity;
import lombok.*;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter @Builder @ToString
public class MemberDto {

    private int mno;
    private String mid;
    private String memail;
    private String mpassword;
    private String mname;
    private String mphone;
    private String mrole;   // 회원 등급
    private LocalDateTime cdate;        // 엔티티 생성 시간
    private LocalDateTime udate;        // 엔티티 업데이트 시간


    // dto -> entity
    public MemberEntity toEntity() {
        return MemberEntity.builder()
                .mid(this.mid)
                .mno(this.mno)
                .memail(this.memail)
                .mpassword(this.mpassword)
                .mname(this.mname)
                .mphone(this.mphone)
                .mrole(this.mrole)
                .build();
    }
}
