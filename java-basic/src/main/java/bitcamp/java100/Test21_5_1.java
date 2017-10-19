package bitcamp.java100;

import java.io.Console;

public class Test21_5_1 {

    public static void main(String[] args) {

        Console console = System.console();

        if (console == null) {
            System.err.println("콘솔을 지원하지 않습니다.");
            System.exit(1);
        }
        int n;
        while (true) {
            n = Integer.parseInt(console.readLine("구구단? "));
            for (int i = 0; i <= 9; i++) {
                if (n <=0 ) {
                    System.out.println("다음에 또 만나요!");
                    System.exit(1);
                    break;
                } else if (n == 1 || n >=10) {
                    System.out.println("2에서 9단까지 가능합니다!");
                    break;
                } else
                    System.out.println(n + "*" + i + "=" + n*i);
            }
            System.out.println("---------------------");
        }
    }
}
