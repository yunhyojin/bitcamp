package bitcamp.java100;

import java.io.Console;
import java.text.Format;
import java.util.ArrayList;

public class Test21_8_1 {

    public static void main(String[] args) {

        Console console = System.console();

        if (console == null) {
            System.err.println("콘솔을 지원하지 않습니다.");
            System.exit(1);
        }
        
        String name = console.readLine("이름? ");
        String email = console.readLine("이메일? ");
        String tel = console.readLine("전화? ");
        
        System.out.print(name);
        System.out.print(email);
        System.out.print(tel);
        
        
    }
}
