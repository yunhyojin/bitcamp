package java100.app.control;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.util.Iterator;

import java100.app.domain.Board;
import java100.app.util.Prompts;

public class BoardController extends GenericController<Board> {
    
    private String dataFilePath;
    
    public BoardController(String dataFilePath) {
        this.dataFilePath = dataFilePath;
        this.init();
    }
     
    @Override
    public void destroy() {
        try (PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(this.dataFilePath)))) {

            for (Board board : this.list) {
                out.println(board.toCSVString());
            }

            out.flush();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    @Override
    public void init() {
        try (BufferedReader in = new BufferedReader(
                new FileReader(this.dataFilePath));) {
            String csv = null;
            while ((csv = in.readLine()) != null) {
                try {
                    list.add(new Board(csv));
                } catch (CSVFormatException e) {
                    System.out.println("CSV 데이터 형식 오류!");
                    e.printStackTrace();
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
            
    
    @Override
    public void execute() {
        loop: while (true) {
            System.out.print("게시판> ");
            String input = keyScan.nextLine();
            switch (input) {
            case "add":
                this.doAdd();
                break;
            case "list":
                this.doList();
                break;
            case "view":
                this.doView();
                break;
            case "update":
                this.doUpdate();
                break;
            case "delete":
                this.doDelete();
                break;
            case "main":
                break loop;
            default:
                System.out.println("해당 명령이 없습니다.");
            }
        }
    }

    private void doAdd() {
        System.out.println("[게시물 등록]");

        Board board;
        board = new Board();

        board.setNumber(Prompts.inputInt("번호? "));
        if (findByNumber(board.getNumber()) != null) {
            System.out.println("이미 등록된 번호입니다.");
            return;
        }
        board.setTitle(Prompts.inputString("제목? "));
        board.setContents(Prompts.inputString("내용? "));

        board.setRegDate(new Date(System.currentTimeMillis()));

        list.add(board);
    }

    private void doList() {
        System.out.println("[게시판 목록]");

        Iterator<Board> iterator = list.iterator();
        while (iterator.hasNext()) {
            Board board = iterator.next();
            System.out.printf("%d, %s, %s, %d\n", board.getNumber(), board.getTitle(), board.getRegDate().toString(),
                    board.getViewCount());
        }
    }

    private void doView() {
        System.out.println("[게시물 상세 정보]");
        int number = Prompts.inputInt("번호? ");
        Board board = findByNumber(number);
        if (board == null) {
            System.out.printf("'%d'의 회원 정보가 없습니다.\n", number);
            return;
        }
        System.out.printf("제목: %s\n", board.getTitle());
        System.out.printf("내용: %s\n", board.getContents());
        System.out.printf("등록일: %s\n", board.getRegDate().toString());
        board.setViewCount(board.getViewCount() + 1);
        System.out.printf("조회수: %d\n", board.getViewCount());
    }

    private void doUpdate() {
        System.out.println("[게시물 변경]");
        int number = Prompts.inputInt("번호? ");

        Board board = findByNumber(number);

        if (board == null) {
            System.out.printf("'%d'의 회원 정보가 없습니다.\n", number);
            return;
        }

        String title = Prompts.inputString("제목?(%s)", board.getTitle());
        if (title.isEmpty()) {
            title = board.getTitle();
        }
        String contents = Prompts.inputString("내용? ");

        if (Prompts.confirm2("변경하시겠습니까?(y/N) ")) {
            board.setTitle(title);
            board.setContents(contents);
            board.setRegDate(new Date(System.currentTimeMillis()));
            System.out.println("변경하였습니다.");

        } else {
            System.out.println("변경을 취소하였습니다.");
        }
    }

    private void doDelete() {
        System.out.println("[회원 상세 정보]");
        System.out.println("[게시물 변경]");
        int number = Prompts.inputInt("번호? ");

        Board board = findByNumber(number);

        if (board == null) {
            System.out.printf("'%d'의 회원 정보가 없습니다.\n", number);
            return;
        }
        if (Prompts.confirm2("정말 삭제하시겠습니까?(y/N) ")) {
            list.remove(board);
            System.out.println("삭제하였습니다.");
        } else {
            System.out.println("삭제를 취소하였습니다.");
        }
    }

    private Board findByNumber(int number) {
        Iterator<Board> iterator = list.iterator();
        while (iterator.hasNext()) {
            Board board = iterator.next();
            if (board.getNumber() == number) {
                return board;
            }
        }
        return null;
    }
}
