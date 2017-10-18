package bitcamp.java100;

import java.io.Console;

public class Test21_3 {

    public static void main(String[] args) {
        Console console = System.console();
        
        if (console == null) {
            System.err.println("콘솔을 지원하지 않습니다.");
            System.exit(1);
        }
        
        String name;
        int age;
        boolean working;
        float gpa;
        
        name = console.readLine("이름?(예:홍길동)");
        age = Integer.parseInt(console.readLine("나이?(예:20)"));
        working = Boolean.parseBoolean(console.readLine("재직여부?(예:true 또는 false)"));
        gpa = Float.parseFloat(console.readLine("학점?(예:4.15)"));
        
        System.out.println("-------------------------------------");
        
        System.out.printf("이름: %s\n", name);
        System.out.printf("나이: %d\n", age);
        System.out.printf("재직여부: %b\n", working);
        System.out.printf("졸업학점: %.2f\n", gpa);
        
    }
}
