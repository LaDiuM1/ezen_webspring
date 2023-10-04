package day02.Servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/todo/list")
public class TodoListController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        System.out.println("TodoListController.doGet");
        //1. 서비스의 메소드 호출
        ToDoService toDoService = new ToDoService();
        List<TodoDTO> result = toDoService.getList();
        // 2. 서비스 메소드로부터 리턴값을 응답
        resp.setContentType("text/html;charset=utf-8");
        resp.getWriter().println(result);

    }
}
