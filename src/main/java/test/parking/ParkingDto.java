package test.parking;

import lombok.*;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class ParkingDto {
    private int pno;    // 주차번호
    private String pcno;  // 차량번호
    private String ptype; // 차량종류
    private LocalDateTime pdate;    // 주차시간

    public ParkingEntity toEntity(){
        return new ParkingEntity(
                this.pno, this.pcno,
                this.ptype, this.pdate);
    }
}
