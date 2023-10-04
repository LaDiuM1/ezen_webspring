package day01.consoleMvc;

import java.util.List;
import java.util.Scanner;

public class ConsoleStart {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        while (true){
            doGet();
            doPost();
        }


    }


public static void doGet(){
    ConsoleController controller = new ConsoleController();
    List<ConsoleDto> list = controller.doGet();
    System.out.println(list);

}

public static void doPost(){
    System.out.print("title : "); String title = sc.next();
    ConsoleController controller = new ConsoleController();
    boolean result = controller.doPost(title);
    System.out.println(result);


}

}
//        System.out.println("안녕하세요");
//        System.out.printf("");
//        System.out.println("consoleStart.main"); // soutm : 현재 실행중인 함수명
//        System.out.println("args = " + Arrays.toString(args)); // soutp 현재 실행중인 함수의 매개변수 출력
//        System.out.println("args = " + args); // soutv 변수 출력
