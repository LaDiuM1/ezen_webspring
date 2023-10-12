package day05;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Builder
@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
public class TodoEntity {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int tno;

    private String tcontent;

    private boolean tstate;


}
