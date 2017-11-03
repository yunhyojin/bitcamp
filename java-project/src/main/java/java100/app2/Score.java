package java100.app2;

import java.util.Scanner;

public class Score {
    protected String name;
    protected int[] subjects;
    protected int sum;
    protected float aver;
    protected String email;
    protected int password;

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
        System.out.printf("%-4s, %4d, %6.1f\n", this.name, this.sum, this.aver);
    }
    public void print2() {
        System.out.printf("%-4s, %11s\n", this.name, this.email);
    }

    public void input() {
        Scanner keyScan = new Scanner(System.in);
        System.out.print("이름? ");
        this.name = keyScan.nextLine();
        System.out.print("국어? ");
        this.subjects[0] = keyScan.nextInt();
        System.out.print("수학? ");
        this.subjects[1] = keyScan.nextInt();
        System.out.print("영어? ");
        this.subjects[2] = keyScan.nextInt();

        this.compute();
    }
    
    public void input2() {
        Scanner keyScan = new Scanner(System.in);
        System.out.print("이름? ");
        this.name = keyScan.nextLine();
        System.out.print("이메일? ");
        this.email = keyScan.nextLine();
        System.out.print("암호? ");
        this.password = keyScan.nextInt();
    }

    public void update() {
        Scanner keyScan = new Scanner(System.in);
        System.out.printf("국어? (%d) ", this.subjects[0]);
        int kor = this.subjects[0];
        try {
            kor = Integer.parseInt(keyScan.nextLine());
        } catch (Exception e) {
        }

        System.out.printf("영어? (%d) ", this.subjects[1]);
        int eng = this.subjects[1];
        try {
            eng = Integer.parseInt(keyScan.nextLine());
        } catch (Exception e) {
        }

        System.out.printf("수학? (%d) ", this.subjects[2]);
        int math = this.subjects[2];
        try {
            math = Integer.parseInt(keyScan.nextLine());
        } catch (Exception e) {
        }
        if (confirm2("변경하시겠습니까(y/N) ")) {
            this.subjects[0] = kor;
            this.subjects[1] = eng;
            this.subjects[2] = math;
            this.compute();
            System.out.println("변경하였습니다.");
        } else {
            System.out.println("변경되지 않았습니다.");
        }
    }
    public void update2() {
        Scanner keyScan = new Scanner(System.in);
        System.out.printf("이름? (%s) ", this.name);
        String name = this.name;
        try {
            name = keyScan.nextLine();
        } catch (Exception e) {
        }

        System.out.printf("비밀번호? (%d) ", this.password);
        int password = this.password;
        try {
            password = Integer.parseInt(keyScan.nextLine());
        } catch (Exception e) {
        }

        if (confirm2("변경하시겠습니까(y/N) ")) {
            this.name = name;
            this.password = password;
            this.compute();
            System.out.println("변경하였습니다.");
        } else {
            System.out.println("변경되지 않았습니다.");
        }
    }

    static boolean confirm2(String message) {
        Scanner keyScan = new Scanner(System.in);
        System.out.print(message);
        String response = keyScan.nextLine().toLowerCase();

        if (response.equals("n") || response.equals("no") || response.equals("")) {
            return false;
        }
        return true;
    }

    public void printDetail() {
        System.out.printf("%-4s, %4d, %4d,  %4d, %4d, %6.1f\n", this.name, this.subjects[0], this.subjects[1],
                this.subjects[2], this.sum, this.aver);
    }
    public void printDetail2() {
        System.out.printf("이름: %s\n이메일: %s\n비밀번호: %d\n", this.name, this.email, this.password);
    }

}
