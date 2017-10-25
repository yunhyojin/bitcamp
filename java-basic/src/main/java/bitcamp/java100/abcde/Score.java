package bitcamp.java100.abcde;

import java.util.Scanner;

public class Score {

    String name;
    int kor;
    int eng;
    int math;
    int sum;
    float aver;

    void input() {

        Scanner keyScan = new Scanner(System.in);
        System.out.print("이름? ");
        name = keyScan.nextLine();
        System.out.print("국어? ");
        kor = keyScan.nextInt();
        System.out.print("영어? ");
        eng = keyScan.nextInt();
        System.out.print("수학? ");
        math = keyScan.nextInt();
        compute();
    }

    void compute() {
        sum = kor + eng + math;
        aver = sum / 3f;
    }

    void print() {
        System.out.printf("%s, %d, %d, %d, %d, %.1f\n",
                name, kor, eng, math, sum, aver);
    }
}