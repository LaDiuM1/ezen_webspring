package ezenweb.service;

import ezenweb.model.dto.BoardDto;
import ezenweb.model.entity.BoardEntity;
import ezenweb.model.repository.BoardEntityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BoardService {

    @Autowired
    private BoardEntityRepository boardEntityRepository;

    // 글쓰기
    @Transactional
    public boolean writeBoard(BoardDto boardDto){

        return boardEntityRepository.save(boardDto.toEntity()).getBno() > 0;

    }

    // 게시글 전체 조회
    @Transactional
    public List<BoardDto> getBoardList(){

        List<BoardDto> boardList = new ArrayList<>();

        boardEntityRepository.findAll().forEach( p -> {
            boardList.add(p.toDto());

        });

        return boardList;

    }

    // 게시글 수정
    @Transactional
    public boolean updateBoard(BoardDto boardDto){
        Optional<BoardEntity> optionalBoardEntity = boardEntityRepository.findById(boardDto.getBno());

        if(optionalBoardEntity.isPresent()){
            BoardEntity boardEntity = optionalBoardEntity.get();

            boardEntity.setBtitle(boardDto.getBtitle());
            boardEntity.setBcontent(boardDto.getBcontent());
            boardEntity.setBfile(boardDto.getBfile());

            return true;
        }
      return false;

    }

    @Transactional
    public boolean deleteBoard(@RequestParam int bno){

        Optional<BoardEntity> result = boardEntityRepository.findById(bno);

        if(result.isPresent()) {
            boardEntityRepository.deleteById(bno);
            return true;
        }

        return false;
    }


}
