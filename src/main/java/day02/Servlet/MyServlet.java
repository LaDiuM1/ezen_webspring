package day02.Servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

// @WebServlet( name = "서블릿이름"[생략시 클래스명으로 자동설정], urlPatterns = "서블릿에 연결될 url 경로" )
@WebServlet( name = "myServlet", urlPatterns = "/day02/myServlet")   // 브라우저 경로와 해당 서블릿을 연결하는 설정을 위해 사용
public class MyServlet extends HttpServlet {
        // JSP 프로젝트시 서블릿클래스 자동 세팅 -> 인텔리제이 유료 버전도 동일
        // 무료버전은 수동으로 생성해야함

    // 서블릿 생성 방법
    // 1. @WebServlet
    // 2. extends HttpServlet
    // 3. 상속 후 오른쪽클릭 -> 제네레이트 -> 메소드 오버라이딩


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");

        PrintWriter out = resp.getWriter();
        out.println("<html>");
            out.println("<body>");
              out.println("<h1> Hello Servlet </h1>");
            out.println("</body>");
        out.println("<html>");





    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    }
}
