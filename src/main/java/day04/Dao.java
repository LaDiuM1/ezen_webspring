package day04;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Dao {
    public Connection conn;
    public PreparedStatement ps;
    public ResultSet rs;


    public Dao() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            this.conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/springweb", "root", "1234");
            System.out.println("연동 성공");
        } catch (Exception e) {
            System.out.println("연동 실패 : " + e);
        }
    }
}
