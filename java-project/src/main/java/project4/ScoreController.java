package project4;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class ScoreController {
    
    private Scanner keyScan = new Scanner(System.in);
    private ArrayList<Score> list = new ArrayList<>();
    private Iterator<Score> iterator = list.iterator();
    
    public void doError() {
        System.out.println("사용할수 없는 기능 입니다.");
    }

    public void doQuit() {
        System.out.println("프로그램을 종료합니다.");
    }

    public void doUpdate() {
        System.out.println("[성적 변경]");
        Score score = null;
        System.out.println("이름? ");
        String name = keyScan.nextLine();
        iterator = list.iterator();
        while (iterator.hasNext()) {
            Score temp = iterator.next();
            if(temp.name.equals(name)){
                score = temp;
                break;
            }
        }
        if (score == null) {
            System.out.println("정보가 없습니다.");
        } else{
                score.update();
        }
    }

    public void doDelete() {
        System.out.println("[성적 삭제]");
        Score score = null;
        System.out.println("이름? ");
        String name = keyScan.nextLine();
        iterator = list.iterator();
        while (iterator.hasNext()) {
            Score temp = iterator.next();
            if(temp.name.equals(name)) {
                score = temp;
                break;
            }
        }
        if (score == null) {
            System.out.println("정보가 없습니다.");
        } else {
        }if (!Score.confirm2("삭제하시겠습니까?")) {
            list.remove(score);
            System.out.println("삭제하였습니다.");
        } else {
            System.out.println("삭제를 취소하였습니다.");
        }
        
    }

    public void doView() {
        System.out.println("[성적 내용]");
        Score score= null;
        System.out.println("이름? ");
        String name = keyScan.nextLine();
        iterator = list.iterator();
        while (iterator.hasNext()) {
            Score temp = iterator.next();
            if(temp.name.equals(name)) {
                score = temp;
            }
        }
        if (score == null) {
            System.out.println("정보가 없습니다.");
        } else {
            score.printDretil();
        }
    }

    public void doList() {
        System.out.println("[성적 목록]");
        iterator = list.iterator();
        while (iterator.hasNext()) {
            iterator.next().print();
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

    public void execute() {
        loop:
        while (true) {
            System.out.print("성적관리> ");
            String input = keyScan.nextLine();
            switch (input) {
            case "add":
                doAdd();
                break;
            case "list":
                doList();
                break;
            case "view":
                doView();
                break;
            case "delete":
                doDelete();
                break;
            case "update":
                doUpdate();
                break;
            case "quit":
                doQuit();
                break loop;
            default:
                doError();
                break;
            }
        }
        
    }
}
