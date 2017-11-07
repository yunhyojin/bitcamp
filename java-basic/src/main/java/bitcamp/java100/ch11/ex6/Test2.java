package bitcamp.java100.ch11.ex6;

public class Test2 {

    public static void main(String[] args) {

        B obj = new B();
        obj.m1();
        obj.m2();

        System.out.println("------------------------------");

        A obj2 = new B();

        obj2.m1();
        // obj2.m2(); - 컴파일 오류

        ((B) obj2).m2(); // 한번 사용할 때

        B obj3 = (B) obj2; // 여러번 사용할 때
        obj3.m2();

    }

}
