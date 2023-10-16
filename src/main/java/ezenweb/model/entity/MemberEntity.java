package ezenweb.model.entity;

import ezenweb.model.dto.MemberDto;
import lombok.*;
import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;

@Entity
@Table(name = "member")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@ToString
public class MemberEntity extends BaseTime{

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    private int mno;
    @Column(name = "memail", nullable = true, unique = true, length = 50)
    private String memail;
    @Column(length = 30, nullable = false)
    private String mpassword;
    @Column(length = 20, nullable = false, unique = true)
    private String mid;
    @Column(length = 20, nullable = false)
    private String mname;
    @Column(length = 13, nullable = false, unique = true)
    private String mphone;
    @Column
    @ColumnDefault("'user'")
    private String mrole;   // 회원 등급

    // Entity -> Dto
    public MemberDto toDto(){
        return MemberDto.builder()
                .mno(this.mno)
                .memail(this.memail)
                .mpassword(this.mpassword)
                .mname(this.mname)
                .mphone(this.mphone)
                .mrole(this.mrole)
                .cdate(cdate)
                .udate(udate)
                .mid(this.mid)
                .build();
    }
}
