package java100.app.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import java100.app.domain.Board;

public class BoardDao {

    static {
        try {
            Class.forName("com.mysql.jdbc.Driver");

        } catch (ClassNotFoundException ex) {

            throw new RuntimeException("JDBC 드라이버 클래스를 찾을 수 없습니다.");
        }
    }

    Connection con;

    public BoardDao() {
        try {
            con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/studydb", "study", "1111");
        } catch (Exception e) {
            throw new DaoException(e);
        }
    }

    public List<Board> selectList() {
        try (Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/studydb", "study", "1111");
                PreparedStatement pstmt = con.prepareStatement(
                        "select no,title,conts,regdt from ex_board");
                ResultSet rs = pstmt.executeQuery();){

            ArrayList<Board> list = new ArrayList<>();

            while (rs.next()) {
                Board board = new Board(
                        rs.getInt("no"),
                        rs.getString("title"), 
                        rs.getString("conts"), 
                        rs.getDate("regdt")
                        );
                list.add(board);
            }
            return list;
        } catch (Exception e) {
            throw new DaoException();
        }
    }

    public int insert(Board board) {
        try (PreparedStatement pstmt = con.prepareStatement(
                "insert into ex_board(title,conts,regdt) values(?,?,now())");
                ){

            pstmt.setString(1, board.getTitle());
            pstmt.setString(2, board.getContent());

            return pstmt.executeUpdate();

        } catch (Exception e) {
            throw new DaoException();
        }
    }

    public int update(Board board) {
        try (PreparedStatement pstmt = con.prepareStatement(
                "update ex_board set title=?,conts=? where no=?");
                ){

            pstmt.setString(1, board.getTitle());
            pstmt.setString(2, board.getContent());
            pstmt.setInt(3, board.getNo());

            return pstmt.executeUpdate();

        } catch (Exception e) {
            throw new DaoException();
        }
    }

    public int delete(int no) {
        try (PreparedStatement pstmt = con.prepareStatement(
                "delete from ex_board where no=?");
                ){

            pstmt.setInt(1, no);

            return pstmt.executeUpdate();

        } catch (Exception e) {
            throw new DaoException();
        }
    }

    public Board selectOne(int no) {
        try {

            try (PreparedStatement pstmt = con.prepareStatement(
                    "update ex_board set vwcnt = vwcnt + 1 where no=?")) {
                pstmt.setInt(1, no);
                pstmt.executeUpdate();
            } catch (Exception e) {throw e;}

            try (PreparedStatement pstmt = con.prepareStatement(
                    "select no,title,conts,regdt,vwcnt from ex_board where no=?")) {
                pstmt.setInt(1, no);

                ResultSet rs = pstmt.executeQuery();

                Board board = null;

                if (rs.next()) {
                    board = new Board();
                    board.setNo(no);
                    board.setTitle(rs.getString("title"));
                    board.setContent(rs.getString("conts"));
                    board.setRegDate(rs.getDate("regdt"));
                    board.setViewCount(rs.getInt("vwcnt"));

                } 

                rs.close();
                return board;
            } catch (Exception e) {throw e;}

        } catch (Exception e) {
            throw new DaoException(e);
        }
    }

}
