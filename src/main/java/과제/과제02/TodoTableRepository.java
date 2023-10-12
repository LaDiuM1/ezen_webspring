package 과제.과제02;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TodoTableRepository extends JpaRepository<TodoTable, Integer> {
    List<TodoTable> findAllByOrderByNameAsc();




}
