package day05;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TodoService {
    @Autowired // 객체 생성
    private TodoEntityRepository todoEntityRepository;

    @Transactional
    public boolean doPost(TodoDto todoDto) {
        /* 1. DTO를 Entity로 변환
            빌더패턴 사용하는 방법
            클래스명.builder()
                .저장할 필드명( 저장할 데이터 )
                .저장할 필드명( 저장할 데이터 )
                .build();
        */

    TodoEntity todoEntity = TodoEntity.builder()
            .tcontent(todoDto.getTcontent())
            .tstate(todoDto.isTstate())
            .build();
    todoEntityRepository.save(todoEntity);
    return false;
    }

    @Transactional
    public List<TodoDto> doGet() {
        List<TodoEntity> todoEntities = todoEntityRepository.findAll();

        List<TodoDto> list = new ArrayList<>();

        todoEntities.forEach( entity -> {

            TodoDto todoDto = TodoDto.builder()
                    .tno (entity.getTno())
                    .tcontent(entity.getTcontent())
                    .tstate(entity.isTstate())
                    .build();


            list.add(todoDto);
        });

        return list;
    }

    @Transactional
    public boolean doPut(TodoDto todoDto) {

        // 수정할 엔티티 찾기
        Optional<TodoEntity> todoEntity = todoEntityRepository.findById(todoDto.getTno());
        if(todoEntity.isPresent()) {
            // optional 객체 꺼내기
            TodoEntity updatedTodoEntity = todoEntity.get();

            // 엔티티 찾으면 필드 수정
            updatedTodoEntity.setTstate(todoDto.isTstate());

        }

        return false;
    }
    public boolean doDelete(int tno) {
        todoEntityRepository.findById(tno);
        todoEntityRepository.deleteById(tno);
        return false;
    }

}
