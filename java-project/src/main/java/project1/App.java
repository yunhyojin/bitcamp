package project1;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class App {

    static boolean confirm(String message) {
        Scanner keyScan = new Scanner(System.in);
        System.out.print(message);
        String response = keyScan.nextLine().toLowerCase();

        if (response.equals("y") || response.equals("yes") || response.equals(" "))
            return true;
        return false;
        
    }

    public static void main(String[] args) {

        ArrayList<Score> list = new ArrayList<>();
        Scanner keyScan = new Scanner(System.in);

        loop: while (true) {
            System.out.print("성적관리> ");
            String ipuet = keyScan.nextLine();
            switch (ipuet) {
            case "add":
                System.out.println("성적등록");
                while (true) {
                    Score score = new Score();
                    score.input();
                    list.add(score);
                    if (!confirm("계속하시겠습니까? "))
                        break;
                }
                break;
            case "list":
                System.out.println("성적목록");
                Iterator<Score> iterator = list.iterator();
                while (iterator.hasNext()) {
                    iterator.next().print();
                }
                break;
            case "view":
                System.out.println("성적정보");
                System.out.println("이름");
                String name = keyScan.nextLine();
                Score score = null;
                iterator = list.iterator();
                while (iterator.hasNext()) {
                    Score temp = iterator.next();
                    if (temp.name.equals(name)) {
                        score = temp;
                        break;
                    }
                }
                if (score == null) {
                    System.out.printf("'s'정보x", name);
                } else {
                    score.printDateil();
                }
                break;
                
            case "update":
                System.out.println("성적 변경");
                System.out.println("이름? ");
                name = keyScan.nextLine();
                score = null;
                iterator = list.listIterator();
                while (iterator.hasNext()) {
                    Score temp = iterator.next();
                    if (temp.name.equals(name)) {
                        score = temp;
                        break;
                    }
                }
                if (score == null) {
                    System.out.printf("'s'님 정보x",name);
                } else {
                    score.update();
                    }
                break;
                
            case "delete":
                System.out.println("성적 삭제");
                System.out.println("이름? ");
                name = keyScan.nextLine();
                score = null;
                iterator = list.iterator();
                while (iterator.hasNext()) {
                    Score temp = iterator.next();
                    if (temp.name.equals(name)) {
                        score = temp;
                        break;
                    }
                }
                if (score == null) {
                    System.out.printf("'s'정보x", name);
                } else {
                    if (!score.confirm2("정말 삭제 하시겠습니까?")) {
                        list.remove(score);
                        System.out.println("삭제되었습니다.");
                    } else {
                        System.out.println("삭제를 취소하였습니다.");
                    }
                }
                break;
            case "quit":
                System.out.println("프로그램을 종료합니다.");
                break loop;
            default:
                System.out.println("사용할수 없는 기능입니다.");
                break;
            }
        }
    }
}
