package bitcamp.java100;

import java.io.Console;

public class Test21_7 {

    public static void main(String[] args) {

        Console console = System.console();
        
        if (console == null) {
            System.err.println("콘솔을 지원하지 않습니다.");
            System.exit(1);
        }
        

        System.out.print("문자열? ");

        String i = console.readLine("");
        
        System.out.printf("입력한 값: %s\n", i);

        System.out.printf("거꾸로 바꾼 값: ");
        for (int r = i.length()-1; r>=0; r--) {
            System.out.print(i.charAt(r));
        }
    }
}
