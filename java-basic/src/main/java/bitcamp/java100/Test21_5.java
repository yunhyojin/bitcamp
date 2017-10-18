package bitcamp.java100;

import java.io.Console;

public class Test21_5 {

    public static void main(String[] args) {

        Console console = System.console();

        if (console == null) {
            System.err.println("콘솔을 지원하지 않습니다.");
            System.exit(1); // JVM을 종료한다.
        }
        System.out.print("구구단? ");
        int n, i =1;
        
        n = Integer.parseInt(console.readLine(""));
        
        if (n <= 0)
            System.out.println("다음에 또만나요!");
        else if (n >= 10)
            System.out.println("2에서 9단까지만 가능합니다!");
        else {
            while (i <= 9) {
                System.out.printf("%d * %d = %d\n", n, i, n*i);
                i++;
            }
        }
    }
}
