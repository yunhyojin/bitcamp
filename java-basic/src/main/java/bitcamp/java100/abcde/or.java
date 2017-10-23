package bitcamp.java100.abcde;

import java.io.Console;

public class or {
    public static void main(String[] args) {
        String name;
        int kor;
        int eng;
        int math;
        int sum;
        float aver;
        
        
        
        Console console = System.console();
        name = console.readLine("이름? ");
        kor = Integer.parseInt(console.readLine("국어? "));
        eng = Integer.parseInt(console.readLine("영어? "));
        math = Integer.parseInt(console.readLine("수학? "));
        sum = kor + eng + math;
        aver = sum / 3f;
        
        
        System.out.printf("%s, %d, %d, %d, %d, %f\n", name, kor, eng, math, sum, aver);
    }
}
