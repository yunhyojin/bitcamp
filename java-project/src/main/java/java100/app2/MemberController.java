package java100.app2;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class MemberController {
    static Scanner keyScan = new Scanner(System.in);

    private ArrayList<Score> list = new ArrayList<>();

    public void doDelete() {
        System.out.println("[회원 정보]");
        String email = Prompts.input("이메일?" );
        Score score = null;
        Iterator<Score> iterator;
        iterator = list.iterator();
        while (iterator.hasNext()) {
            Score temp = iterator.next();
            if (temp.email.equals(email)) {
                score = temp;
                break;
            }
        }
        if (score == null) {
            System.out.printf("'%s'의 회원 정보가 없습니다.\n", email);
        } else {
            if (Prompts.confirm2("정말 삭제하시겠습니까?(y/N)")) {
                list.remove(score);
                System.out.println("삭제하였습니다.");
            } else {
                System.out.println("삭제를 취소하였습니다.");
            }
        }

    }

    public void doUpdate() {
        System.out.println("[회원 정보]");
        String email = Prompts.input("이메일?" );
        Score score = null;
        Iterator<Score> iterator;
        iterator = list.iterator();
        while (iterator.hasNext()) {
            Score temp = iterator.next();
            if (temp.email.equals(email)) {
                score = temp;
                break;
            }
        }
        if (score == null) {
            System.out.printf("'%s'의 회원 정보가 없습니다.\n", email);
        } else {
            score.update2();
        }

    }

    public void doView() {
        System.out.println("[회원 정보]");
        String email = Prompts.input("이메일?" );
        Score score = null;
        Iterator<Score> iterator;
        iterator = list.iterator();
        while (iterator.hasNext()) {
            Score temp = iterator.next();
            if (temp.email.equals(email)) {
                score = temp;
                break;
            }
        }
        if (score == null) {
            System.out.printf("'%s'의 회원 정보가 없습니다.\n", email);
        } else {
            score.printDetail2();
        }

    }

    public void dpList() {
        System.out.println("[학생 목록]");
        Iterator<Score> iterator;
        iterator = list.iterator();
        while (iterator.hasNext()) {
            iterator.next().print2();
        }
    }

    public void doAdd() {
        System.out.println("[회원등록]");
        Score score;
        while (true) {
            score = new Score();
            score.input2();
            list.add(score);
                break;
        }
    }

    public void execute() {
        loop: while (true) {
            System.out.println("회원관리");
            String input = keyScan.nextLine();
            switch (input) {
            case "add": this.doAdd(); break;
            case "list": this.dpList(); break;
            case "view": this.doView(); break;
            case "update": this.doUpdate(); break;
            case "delete": this.doDelete(); break;
            case "main": break loop;
            default: System.out.println("해당 명령이 없습니다.");
            }
        }
    }
}
