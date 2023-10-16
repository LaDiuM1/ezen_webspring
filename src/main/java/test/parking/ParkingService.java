package test.parking;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;


import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ParkingService {
    @Autowired
    private ParkingEntityRepository parkingEntityRepository;

    // 1. C
    @Transactional
    public boolean pwrite(@RequestBody ParkingDto parkingDto){

        parkingEntityRepository.save(parkingDto.toEntity());

        return false;
    }

    // 2. R
    @Transactional
    public List<ParkingDto> plist(){
        List<ParkingEntity> list = parkingEntityRepository.findAll();

        List<ParkingDto> getList = new ArrayList<ParkingDto>();

        list.forEach( e -> {
            getList.add( e.toDto());
        });

        return getList;
    }


    // 3. U

    @Transactional
    public boolean pupdate(@RequestBody ParkingDto parkingDto){
        Optional<ParkingEntity> entity = parkingEntityRepository.findById( parkingDto.getPno() );

        if(entity.isPresent()){
            ParkingEntity parkingEntity = entity.get();
            parkingEntity.setPno( parkingDto.getPno() );
            parkingEntity.setPtype( parkingDto.getPtype() );
            parkingEntity.setPcno( parkingDto.getPcno() );


        }

        return false;

    }

    // 4. D
    @Transactional
    public boolean pdelete(@RequestParam int pno){
        parkingEntityRepository.deleteById(pno);

        return false;
    }




}
