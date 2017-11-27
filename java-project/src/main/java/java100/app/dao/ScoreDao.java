package java100.app.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import java100.app.domain.Score;

public class ScoreDao {
    
    static {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            throw new RuntimeException("JDBC 드라이버 클래스를 찾을 수 없습니다.");
        }
    }

    Connection con;
    
    public ScoreDao() {
        try {
            con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/studydb", "study", "1111");
        } catch (Exception e) {
            throw new DaoException(e);
        }
    }
    
    public List<Score> selectList() {
        try (PreparedStatement pstmt = con.prepareStatement(
                        "select no,name,kor,eng,math from ex_score");
                ResultSet rs = pstmt.executeQuery();){

            ArrayList<Score> list = new ArrayList<>();

            while (rs.next()) {
                Score score = new Score(
                        rs.getInt("no"),
                        rs.getString("name"),
                        rs.getInt("kor"),
                        rs.getInt("eng"),
                        rs.getInt("math"));
                list.add(score);
            }

            return list;

        } catch (Exception e) {
            throw new DaoException(e);
        }
    }

    public int insert(Score score){
        try (PreparedStatement pstmt = con.prepareStatement(
                        "insert into ex_score(name,kor,eng,math) values(?,?,?,?)");
                ){

            pstmt.setString(1, score.getName());
            pstmt.setInt(2, score.getKor());
            pstmt.setInt(3, score.getEng());
            pstmt.setInt(4, score.getMath());

            return pstmt.executeUpdate();

        } catch (Exception e) {
            throw new DaoException(e);
        }
    }

    public int update(Score score) {
        try (PreparedStatement pstmt = con.prepareStatement(
                "update ex_score set name=?,kor=?,eng=?,math=? where no=?");
                ){
            
            pstmt.setString(1, score.getName());
            pstmt.setInt(2, score.getKor());
            pstmt.setInt(3, score.getEng());
            pstmt.setInt(4, score.getMath());
            pstmt.setInt(5, score.getNo());

            return pstmt.executeUpdate();
            
        } catch (Exception e) {
            throw new DaoException(e);
        }
    }
    
    public int delete(int no) {
        try (PreparedStatement pstmt = con.prepareStatement(
                "delete from ex_score where no=?");
                ){
            
            pstmt.setInt(1, no);
            
            return pstmt.executeUpdate();

        } catch (Exception e) {
            throw new DaoException(e);
        }
    }
    
    public Score selectOne(int no) {
        try (PreparedStatement pstmt = con.prepareStatement(
                        "select no,name,kor,eng,math from ex_score where no=?");
                ){
            
            pstmt.setInt(1, no);
            
            ResultSet rs = pstmt.executeQuery();
            
            Score score = null;
            
            if(rs.next()) {
            score = new Score();
            score.setNo(no);
            score.setName(rs.getString("name"));
            score.setKor(rs.getInt("kor"));
            score.setEng(rs.getInt("eng"));
            score.setMath(rs.getInt("math"));
            return score;
            }
            rs.close();
            return score;

        } catch (Exception e) {
            throw new DaoException();
        }
    }
}
