package java100.app;

import java.net.ServerSocket;
import java.util.Collection;
import java.util.HashMap;
import java.util.Scanner;

import java100.app.control.BoardController;
import java100.app.control.Controller;
import java100.app.control.MemberController;
import java100.app.control.RoomController;
import java100.app.control.ScoreController;

public class App02 {

    Scanner keyScan = new Scanner(System.in);

    HashMap<String, Controller> controllerMap = new HashMap<>();

    void init() {
        controllerMap.put("1", new ScoreController("./data/score.csv"));
        controllerMap.put("2", new MemberController("./data/member.csv"));
        controllerMap.put("3", new BoardController("./data/board.csv"));
        controllerMap.put("4", new RoomController("./data/room.csv"));
    }

    void service() throws Exception {
        ServerSocket ss = new ServerSocket(9999);
        loop: while (true) {
            System.out.print("명령> ");
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
                System.out.println("명령 처리 중 오류 발생!");
            }
            System.out.println();
        }

    }

    private void doGo(String menuNo) {

        Controller controller = controllerMap.get(menuNo);

        if (controller == null) {
            System.out.println("해당 번호의 메뉴가 없습니다.");
            return;
        }
        controller.execute();
    }

    private void doHelp() {
        System.out.println("[명령]");
        System.out.println("menu        - 메뉴 목록 출력한다.");
        System.out.println("go 번호     - 메뉴로 이동한다.");
        System.out.println("quit        - 프로그램을 종료한다.");
    }

    private void doMenu() {
        System.out.println("1 성적관리");
        System.out.println("2 회원관리");
        System.out.println("3 게시판");
        System.out.println("3 강의실");
    }

    private void doError() {
        System.out.println("실행할 수 없는 명령입니다.");
    }

    private void doQuit() {
        Collection<Controller> controls = controllerMap.values();
        for (Controller control : controls) {
            control.destroy();
        }
        System.out.println("프로그램을 종료합니다.");
    }
    
    public static void main(String[] args) throws Exception {
        App02 app = new App02();
        app.init();
        app.service();
        
    }

}
