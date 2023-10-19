package 객체연관관계;

public class Main2 {
    public static void main(String[] args) {

        상위클래스 A객체 = 상위클래스.builder().data(1).build();

        하위클래스 B객체 = 하위클래스.builder().value(2).build();
        하위클래스 C객체 = 하위클래스.builder().value(3).build();

        A객체.get참조하위클래스들().add(B객체);
        A객체.get참조하위클래스들().add(C객체);

        B객체.set상위객체(A객체);
        C객체.set상위객체(A객체);

        System.out.println("A객체 = " + A객체);

        // 양방향 참조
        // 상위객체에서 하위 객체 확인 가능
        System.out.println("A = " + A객체.get참조하위클래스들().get(0).getValue());
        
        // 하위객체에서 상위 객체도 확인 가능
        System.out.println("C객체.get상위객체().getData() = " + C객체.get상위객체().getData());








    }
}
