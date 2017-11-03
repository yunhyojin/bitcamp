package java100.app2;

import java.util.Scanner;

public class App {

    static Scanner keyScan = new Scanner(System.in);
    static ScoreController scoreController = new ScoreController();
    static MemberController MemberController = new MemberController();

    public static void main(String[] args) {

        loop: while (true) {
            System.out.printf("명령> ");
            String[] input = keyScan.nextLine().toLowerCase().split(" ");

            try {
                switch (input[0]) {
                case "menu": doMenu(); break;
                case "help": doHelp(); break;
                case "quit": doQuit(); break loop;
                case "go": doGo(input[1]); break;
                default: doError();
                }
            } catch (Exception e) {
                System.out.println("명령처리중 오류 발생");
            }
        }
    }

    private static void doGo(String menuNo) {
        switch (menuNo) {
        case "1": scoreController.execute(); break;
        case "2": doMomber(); break;
        case "3":
            System.out.println("게시판");
            break;
        default:
            System.out.println("해당번호의 메뉴가 없습니다.");
        }
    }

    private static void doMomber() {
            loop: while (true) {
                System.out.println("회원관리");
                String input = keyScan.nextLine();
                switch (input) {
                case "add": MemberController.doAdd(); break;
                case "list": MemberController.dpList(); break;
                case "view": MemberController.doView(); break;
                case "update": MemberController.doUpdate(); break;
                case "delete": MemberController.doDelete(); break;
                case "main": break loop;
                default: System.out.println("해당 명령이 없습니다.");
                }
            }
    }

    private static void doHelp() {
        System.out.println("[메뉴]");
        System.out.println("menu       - 메뉴 목록 출력한다.");
        System.out.println("go 번호    - 메뉴로 이동한다.");
        System.out.println("quit       - 프로그램을 종료한다.");
    }

    private static void doMenu() {
        System.out.println("1. 성적관리");
        System.out.println("2. 회원관리");
        System.out.println("3. 게시판관리");
    }

    private static void doError() {
        System.out.println("실행할수 없는 명령입니다.");
    }

    private static void doQuit() {
        System.out.println("프로그램을 종료합니다.");
    }

}
