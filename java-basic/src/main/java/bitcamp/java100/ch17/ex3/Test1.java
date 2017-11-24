package bitcamp.java100.ch17.ex3;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class Test1 {

    public static void main(String[] args) throws Exception {

        Scanner keyboard = new Scanner(System.in);
        System.out.print("변경할 게시물 번호? ");
        String no = keyboard.nextLine();

        System.out.print("제목? ");
        String title = keyboard.nextLine();

        System.out.print("내용? ");
        String contents = keyboard.nextLine();
        keyboard.close();

        Class.forName("com.mysql.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/studydb", "study", "1111");
        System.out.println("연결 되었음!");

        Statement stmt = con.createStatement();

        stmt.executeUpdate("update jdbc_test set title='" + title
                + "', conts='" + contents
                + "' where no=" + no);

        System.out.println("변경 완료!");

        stmt.close();
        con.close();

    }
}
