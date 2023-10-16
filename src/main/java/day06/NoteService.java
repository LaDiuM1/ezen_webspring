package day06;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class NoteService {
    @Autowired
    private NoteEntityRepository noteEntityRepository;

    // 1. C
    public boolean boardWrite(@RequestBody NoteDto noteDto){
        noteEntityRepository.save(noteDto.toEntity());
        return false;
    }

    // 2. R
    public List<NoteDto> boardGetList(){
        List<NoteEntity> list = noteEntityRepository.findAll();

        List<NoteDto> noteDtos = new ArrayList<NoteDto>();

        list.forEach( e -> {
            noteDtos.add( e.toDto());

        });
        System.out.println("noteDtos = " + noteDtos);
        return noteDtos;
    }

    // 3. U
    @Transactional
    public boolean boardUpdate(@RequestBody NoteDto noteDto){
        Optional<NoteEntity> optionalNoteEntity =  noteEntityRepository.findById( noteDto.getNo() );
        if(optionalNoteEntity.isPresent()){
            NoteEntity entity = optionalNoteEntity.get();

            // 수정

            entity.setTitle( noteDto.getTitle() );
            entity.setWriter( noteDto.getWriter() );

        }


        return false;
    }


    // 4. D
    @Transactional
    public boolean boardDelete(int bno){
        noteEntityRepository.deleteById(bno);

        return false;
    }
    
    

}
