package bitcamp.java100.ch13.ex1;

import java.io.Console;

public class Test2 {

    public static void main(String[] args) {

        Console console = System.console();

        if (console == null) {
            System.out.println("콘솔 입력을 지원하지 않습니다.");
            System.exit(1);
        }

        while (true) {
            int a = Integer.parseInt(console.readLine("a = "));
            String op = console.readLine("연산자? ");
            int b = Integer.parseInt(console.readLine("b = "));
            switch (op) {
            case "+": System.out.printf("결과 = %d\n", a + b); break;
            case "-": System.out.printf("결과 = %d\n", a - b); break;
            case "*": System.out.printf("결과 = %d\n", a * b); break;
            case "/": System.out.printf("결과 = %d\n", a / b); break;
            case "%": System.out.printf("결과 = %d\n", a % b); break;
            default: System.out.println("지원하지 않는 연사자 입니다.");
            }
        }
    }

}
