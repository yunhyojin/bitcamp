package bitcamp.java100.ch07.ex5;

public class A {
    A() {
        // super(); - 생략하면 자동 생성됨
        System.out.println("A() 생성자 실행!");
    }

    A(String str) {
        super();
        System.out.println("A(String) 호출됨.");
    }

    A(int i) {
        System.out.println("A(int) 호출됨.");
        // super(); - 컴파일 오류
    }
}
