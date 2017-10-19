package bitcamp.java100;

import java.io.Console;
import java.text.Format;
import java.util.ArrayList;

public class Test21_8_3 {

    public static void main(String[] args) {

        Console console = System.console();

        if (console == null) {
            System.err.println("콘솔을 지원하지 않습니다.");
            System.exit(1);
        }

        String[] names = new String[100];
        String[] emails = new String[100];
        String[] tels = new String[100];

        int cursor = 0;

        while (cursor < names.length) {

            names[cursor] = console.readLine("이름? ");
            emails[cursor] = console.readLine("이메일? ");
            tels[cursor] = console.readLine("전화? ");
            cursor++;
            String response = console.readLine("계속 입력하시겠습니까?(y/n)");
            if (!(response.toLowerCase().equals("y") ||
                  response.toLowerCase().equals("yes")))
                break;
        }
        for (int i = 0; i < cursor; i++) {
            System.out.println(names[i]);
            System.out.println(emails[i]);
            System.out.println(tels[i]);
        }
    }
}
