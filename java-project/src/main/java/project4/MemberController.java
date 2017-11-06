package project4;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class MemberController {
    private Scanner keyScan = new Scanner(System.in);
    private ArrayList<Score> list = new ArrayList<>();
    private Iterator<Score> iterator = list.iterator();
    public void execute() {
        loop:
        while (true) {
            System.out.print("성적관리> ");
            String input = keyScan.nextLine();
            switch (input) {
//            case "add": doAdd(); break;
//            case "list": doList(); break;
//            case "view": doView(); break;
//            case "delete": doDelete(); break;
//            case "update": doUpdate(); break;
//            case "quit": doQuit(); break loop;
//            default: doError(); break;
            }
        }
    }

    public void doAdd() {
        System.out.println("성적 등록");
        while (true) {
            Score score = new Score(); 
            score.input();
            list.add(score);
            if (!Score.confirm("계속하시겠습니까? "))
                break;
        }
    }

    public void doList() {
        System.out.println("[성적 목록]");
        iterator = list.iterator();
        while (iterator.hasNext()) {
            iterator.next().print();
        }
    }

}
