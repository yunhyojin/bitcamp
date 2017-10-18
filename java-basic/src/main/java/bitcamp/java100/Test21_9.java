package bitcamp.java100;

import java.io.Console;

public class Test21_9 {
        

    public static void main(String[] args) {

        class Student {
            String name;
            String email;
            String working;
        }
        
        Console console = System.console();
        
        if (console == null) {
            System.err.println("콘솔을 지원하지 않습니다.");
            System.exit(1);
        }
        Student s = new Student();
        
        s.name = console.readLine("이름?");
        s.email = console.readLine("이메일?");
        s.working = console.readLine("전화?");
        
        System.out.println("-------------------------------------");
        
        System.out.printf("%s", s.name);
        System.out.printf("%20s", s.email);
        System.out.printf("%10s", s.working);
           
    }
}
