package ezenweb.controller;

import ezenweb.model.dto.BoardDto;
import ezenweb.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/board")
public class BoardController {

    @Autowired
    private BoardService boardService;


    // 1. 글쓰기 [ C ]
    @PostMapping("/post")
    public boolean writeBoard(BoardDto boardDto) {

        return boardService.writeBoard(boardDto);


    }



    // 2. 게시글 전체 조회 [ R ]
    @GetMapping("/get")
    public List<BoardDto> getBoardList() {

        return boardService.getBoardList();

    }


    // 3. 게시글 수정 [ U ]
    @PutMapping("/put")
    public boolean updateBoard(BoardDto boardDto) {

        return boardService.updateBoard(boardDto);

    }


    // 4. 게시글 삭제 [ D ]
    @DeleteMapping("/delete")
    public boolean deleteBoard(@RequestParam int bno){

        return boardService.deleteBoard(bno);

    }



}
