package day06;


import lombok.*;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter @Service @Builder @ToString
public class NoteDto {

        private int no;
        private String title;
        private String writer;
        private String password;
        private LocalDateTime date;

        public NoteEntity toEntity(){
                return NoteEntity.builder()
                        .no(this.no)
                        .title(this.title)
                        .writer(this.writer)
                        .password(this.password)
                        .date(this.date)
                        .build();
        }

}
