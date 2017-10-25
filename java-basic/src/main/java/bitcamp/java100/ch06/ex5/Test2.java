package bitcamp.java100.ch06.ex5;

import java.util.Scanner;

public class Test2 {

    static String name;
    static int kor;
    static int eng;
    static int math;
    static int sum;
    static float aver;

    static void inputScore() {

        Scanner keyScan = new Scanner(System.in);

        System.out.print("이름? ");
        name = keyScan.nextLine();

        System.out.print("국어점수? ");
        kor = keyScan.nextInt();

        System.out.print("영어점수? ");
        eng = keyScan.nextInt();

        System.out.print("수학점수? ");
        math = keyScan.nextInt();
        
        keyScan.close(); // Scanner는 사용후 닫아야 한다.

    }

    static void computeScore() {

        sum = kor + eng + math;

        aver = sum / 3f;

    }

    static void printScore() {

        System.out.printf("%s, %d, %d, %d, %d, %.1f\n", name, kor, eng, math, sum, aver);

    }

    public static void main(String[] args) {
        
        inputScore();
        computeScore();
        printScore();

    }

}
