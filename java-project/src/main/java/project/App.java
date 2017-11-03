package project;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class App {
    static Scanner keyScan = new Scanner(System.in);

    static boolean confirm(String message) {
        System.out.print(message);
        String response = keyScan.nextLine().toLowerCase();

        if (response.equals("y") || response.equals("yes") || response.equals(""))
            return true;
        return false;
    }
    static String prompt(String message) {
        System.out.print(message);
        return keyScan.nextLine();
    }

    public static void main(String[] args) {
        ArrayList<Score> list = new ArrayList<>();
        Iterator<Score> iterator = list.iterator();
        loop: while (true) {
            System.out.println("성적관리> ");
            String input = keyScan.nextLine();
            
            String name = null;
            Score score = null;
            
            switch (input) {
            case "add":
                System.out.println("학생등록");
                while (true) {
                    score = new Score();
                    score.input();
                    list.add(score);
                    if (!confirm("계속하시겠습니까?(Y/n) "))
                        break;
                }
                break;
            case "list":
                System.out.println("학생목록");
                while (iterator.hasNext()) {
                    iterator.next().print();
                }
                break;
            case "view":
                System.out.println("학생정보");
                name = prompt("이름? ");
                
                break;
            case "qlet":
                System.out.println("프로그램을 종료합니다.");
                break loop;
            default:
                System.out.println("사용할수 없는 기능입니다.");
            }
            System.out.println();
        }

    }
}
