package test.parking;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/parking")
public class ParkingController {
    @Autowired
    private ParkingService parkingService;

    // 1.
    @PostMapping("/go")
    public boolean pwrite(@RequestBody ParkingDto parkingDto) {
        boolean result = parkingService.pwrite(parkingDto);
        return result;
    }
    // 2.
    @GetMapping("/go")
    public List<ParkingDto> plist(){
        List<ParkingDto> result = parkingService.plist();
        return result;
    }

    // 3.
    @PutMapping("/go")
    public boolean pupdate(@RequestBody ParkingDto parkingDto){
        boolean result = parkingService.pupdate(parkingDto);
        return result;
    }
    // 4.
    @DeleteMapping("/go")
    public boolean pdelete(@RequestParam int pno){
        boolean result = parkingService.pdelete(pno);
        return result;
    }

}
