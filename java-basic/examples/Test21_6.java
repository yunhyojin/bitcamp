package bitcamp.java100;

import java.io.Console;

public class Test21_6 {

    public static void main(String[] args) {

        Console console = System.console();

        if (console == null) {
            System.err.println("콘솔을 지원하지 않습니다.");
            System.exit(1); // JVM을 종료한다.
        }

        System.out.print("숫자?");
        int i;
        
        int[] cnt = new int[10];

        i = Integer.parseInt(console.readLine(""));

        while (i > 0) {
            cnt[i % 10]++;
            i /= 10;
        }
        int x = 0;
        while (x < cnt.length) {
            System.out.printf("%d = %d\n", x, cnt[x]);
            x++;
        }
        }
    }

