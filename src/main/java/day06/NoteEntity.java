package day06;

import lombok.*;
import org.springframework.stereotype.Service;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Entity // 해당 클래스를 테이블(엔티티)로 설정
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Service
@Builder
@ToString
public class NoteEntity {

    @Id // no 필드를 pk로 설정
    @GeneratedValue( strategy = GenerationType.IDENTITY) // pk 사용 정의
    private int no;
    private String title;
    private String writer;
    private String password;
    private LocalDateTime date;

    public NoteDto toDto(){
        return new NoteDto(
                this.no,
                this.title,
                this.writer,
                this.password,
                this.date );
    }

}
