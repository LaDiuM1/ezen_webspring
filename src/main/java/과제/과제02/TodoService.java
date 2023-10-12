package 과제.과제02;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TodoService {

    @Autowired // 객체 생성
    private TodoTableRepository todoTableRepository;

    @Transactional
    public boolean doPost(TodoDto todoDto) {


        TodoTable todoTable = TodoTable.builder()
                        .name(todoDto.getName())
                                .phone(todoDto.getPhone()).build();

        todoTableRepository.save(todoTable);
        return false;
    }

    @Transactional
    public List<TodoDto> doGet() {
       List<TodoTable> list = todoTableRepository.findAllByOrderByNameAsc();

       List<TodoDto> getList = new ArrayList<>();

       list.forEach( entity -> {
           TodoDto todoDto = TodoDto.builder()
                   .pno (entity.getPno())
                   .name(entity.getName())
                   .phone(entity.getPhone())
                   .build();
           getList.add(todoDto);

       });


       return getList;

    }

    @Transactional
    public boolean doPut(TodoDto todoDto) {
        Optional<TodoTable> todoTable = todoTableRepository.findById(todoDto.getPno());

        boolean result = todoTable.isPresent();
        System.out.println("result = " + result);
        if(result){
            TodoTable updatedTodoTable = todoTable.get();

            updatedTodoTable.setName(todoDto.getName());
            updatedTodoTable.setPhone(todoDto.getPhone());

        }
        return result;

    }

    @Transactional
    public boolean doDelete(int pno) {
        todoTableRepository.deleteById(pno);
        return true;
    }

}
