package project4;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class App {
    static Scanner keyScan = new Scanner(System.in);
    static ArrayList<Score> list = new ArrayList<>();
    static Iterator<Score> iterator = list.iterator();

    public static void main(String[] args) {
        ScoreController scoreController = new ScoreController();

        loop: while (true) {
            System.out.print("명령> ");
            String[] input = keyScan.nextLine().toLowerCase().split(" ");

            switch (input[0]) {
            case "menu":
                break;
            case "help":
                System.out.println("menu -      메뉴 목록 출력");
                System.out.println("go 번호 -   메뉴 이동");
                System.out.println("quit -      프로그램 종료");
                break;
            case "quit":
                System.out.println("프로그램종료");
                break loop;
            default:
                System.out.println("잘못된 명령어 입니다.");
                break;
            }
        }
    }
}
