package day02.Servlet;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ToDoService {

    // 1. 등록 서비스
    public void reister(TodoDTO todoDto){
        System.out.println("ToDoService.reister");


    }

    // 2. 출력 서비스
    public List<TodoDTO> getList(){


        //2. 스트림 문법을 사용했을때
    List<TodoDTO> todoDTOS = IntStream.range(0,10).mapToObj( i -> {
        TodoDTO todoDto = TodoDTO.builder().tno((long)i).title("Todo.."+i).dueDate(LocalDate.now()).build();
        return todoDto;
    }).collect(Collectors.toList());
        // IntStream.range(시작 정수, 끝 정수)
        // .mapToObj( i -> {}) : return 값을 반환해서 배열/리스트에 대입
        // .collect(Collectors.toList())
        return todoDTOS;

    }
}
 /*
        // 1. 스트림 문법 사용 x
        List<TodoDTO> list = new ArrayList<>();
        for(int i=0; i<10; i++){
            TodoDTO todoDto = TodoDTO.builder().tno((long)i).title("Todo.."+i).dueDate(LocalDate.now()).build();
            list.add(todoDto);
        }
        return list;

*/