package day01.consoleMvc;

import java.time.LocalDate;

public class ConsoleDto {

    private int no; // todo 번호

    private String title;   // todo 내용

    private LocalDate date; // todo 작성일

    private boolean finished;   // todo 실행여부

    public ConsoleDto() {
    }

    public ConsoleDto(int no, String title, LocalDate date, boolean finished) {
        this.no = no;
        this.title = title;
        this.date = date;
        this.finished = finished;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public boolean isFinished() {
        return finished;
    }

    public void setFinished(boolean finished) {
        this.finished = finished;
    }

    @Override
    public String toString() {
        return "ConsoleDto{" +
                "no=" + no +
                ", title='" + title + '\'' +
                ", date=" + date +
                ", finished=" + finished +
                '}';
    }
}
