package ezenweb.model.entity;

import lombok.*;
import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
@Entity
@Table( name = "porder" )
public class Order {
    // 주문 번호
    // 주문 가격
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    private int ono;
    @Column
    @ColumnDefault("0")
    private int oprice;
    // 제품 FK
    @ToString.Exclude
    @OneToOne
    @JoinColumn(name = "pno")
    Product product;
}
