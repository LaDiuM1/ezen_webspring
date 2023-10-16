package test.parking;


import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Builder
@Entity
public class ParkingEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int pno;    // 주차번호
    private String pcno;  // 차량번호
    private String ptype; // 차량종류
    private LocalDateTime pdate;  // 주차시간

    @PrePersist
    public void prePersist(){
        this.pdate = LocalDateTime.now();
    }
    @PreUpdate // 데이터 수정이 이루어질때 사전 작업
    public void preUpdate() {
        this.pdate = LocalDateTime.now();
    }

    // 엔티티 dto 변환 함수
    public ParkingDto toDto(){
        return new ParkingDto(
                this.pno, this.pcno,
                this.ptype, this.pdate);
    }
}
