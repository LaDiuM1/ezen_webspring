package day06;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/note")
public class NoteController {

    @Autowired
    private NoteService noteService;

    // 1. C
    @PostMapping("/do")
    public boolean boardWrite(@RequestBody NoteDto noteDto){

        return noteService.boardWrite(noteDto);
    }

    // 2. R
    @GetMapping("/do")
    public List<NoteDto> boardGetList(){


        return noteService.boardGetList();
    }

    @PutMapping("/do")
    // 3. U
    public boolean boardUpdate(@RequestBody NoteDto noteDto){

        return noteService.boardUpdate(noteDto);
    }


    // 4. D
    @DeleteMapping("/do")
    public boolean boardDelete(int bno){

        return noteService.boardDelete(bno);
    }

}
