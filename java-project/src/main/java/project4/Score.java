package project4;

import java.util.Scanner;

public class Score {

    protected String name;
    protected int[] subjects;
    protected int sum;
    protected float aver;

    public Score() {
        this.subjects = new int[3];
    }

    public Score(String name, int kor, int eng, int math) {
        this.name = name;
        this.subjects = new int[] { kor, eng, math };

        this.compute();
    }

    private void compute() {
        this.sum = 0;
        for (int sub : this.subjects) {
            this.sum += sub;
        }
        this.aver = (float) this.sum / this.subjects.length;
    }

    public void print() {
        System.out.printf("%-4s, %4d, %4d, %4d, %4d, %6.1f\n", this.name, this.subjects[0], this.subjects[1],
                this.subjects[2], this.sum, this.aver);
    }

    public void input() {
        Scanner keyScan = new Scanner(System.in);

        System.out.print("이름? ");
        this.name = keyScan.nextLine();

        System.out.print("국어점수? ");
        this.subjects[0] = keyScan.nextInt();

        System.out.print("영어점수? ");
        this.subjects[1] = keyScan.nextInt();

        System.out.print("수학점수? ");
        this.subjects[2] = keyScan.nextInt();

        this.compute();
    }

    public void printDretil() {
        System.out.printf("%-4s, %4d, %4d, %4d, %4d, %6.1f\n", this.name, this.subjects[0], this.subjects[1],
                this.subjects[2], this.sum, this.aver);
    }
    public static boolean confirm(String message) {
        Scanner keyScan = new Scanner(System.in);
        System.out.print(message);
        String response = keyScan.nextLine().toLowerCase();

        if (response.equals("y") || response.equals("yes") || response.equals(" "))
            return true;
        return false;
    }
    public static boolean confirm2(String message) {
        Scanner keyScan = new Scanner(System.in);
        System.out.print(message);
        String response = keyScan.nextLine().toLowerCase();

        if (response.equals("n") || response.equals("no") || response.equals(" "))
            return true;
        return false;
    }

    public void update() {
        Scanner keyScan = new Scanner(System.in);
        System.out.printf("국어?(%d)",subjects[0]);
        int kor = subjects[0];
        try {
            kor = Integer.parseInt(keyScan.nextLine());
        } catch (Exception e) {}
        System.out.printf("영어(%d)",subjects[1]);
        int eng = subjects[1];
        try {
            eng = Integer.parseInt(keyScan.nextLine());
        } catch (Exception e) {}
        System.out.printf("수학?(%d)",subjects[2]);
        int math = subjects[2];
        try {
            math = Integer.parseInt(keyScan.nextLine());
        } catch (Exception e) {}
        
        if (!confirm2("변경하시겠습니까?")) {
            subjects[0] = kor;
            subjects[1] = eng;
            subjects[2] = math;
            compute();
            System.out.println("변경하였습니다.");
        }else {
            System.out.println("변경을 취소하였습니다.");
        }
    }
}
