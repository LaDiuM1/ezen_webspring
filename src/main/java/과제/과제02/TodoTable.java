package 과제.과제02;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TodoTable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    private int pno;
    private String name;
    private String phone;

}
