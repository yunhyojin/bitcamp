package java100.app.dao;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import java100.app.domain.Member;

public class MemberDao {
    
    static {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            throw new RuntimeException("JDBC 드라이버 클래스를 찾을 수 없습니다.");
        }
    }
    
    Connection con;
    
    public MemberDao() {
        try {
            con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/studydb", "study", "1111");
        } catch (Exception e) {
            throw new DaoException(e);
        }
    }
    
    public List<Member> selectList() {
        try (PreparedStatement pstmt = con.prepareStatement(
                        "select no,name,email,regdt from ex_memb");
                ResultSet rs = pstmt.executeQuery();){
            
            ArrayList<Member> list = new ArrayList<>();

            while (rs.next()) {
                Member member = new Member(
                       rs.getInt("no"),
                       rs.getString("name"),
                       rs.getString("email"),
                       rs.getDate("regdt")
                        );
                
                list.add(member);
            }
            return list;

        } catch (Exception e) {
            throw new DaoException(e);
        }
    }
    
    public int insert(Member member) {
        try (PreparedStatement pstmt = con.prepareStatement(
                        "insert into ex_memb(name,email,pwd,regdt)"
                        + " values(?,?,password(?),now())");
                ){
            
            pstmt.setString(1, member.getName());
            pstmt.setString(2, member.getEmail());
            pstmt.setString(3, member.getPassword());

            return pstmt.executeUpdate();

        } catch (Exception e) {
            throw new DaoException();
        }
    }
    
    public int update(Member member) {
        try (PreparedStatement pstmt = con.prepareStatement(
                "update ex_memb set name=?,email=?,pwd=password(?) where no=?");
                ){
            
            
            pstmt.setString(1, member.getName());
            pstmt.setString(2, member.getEmail());
            pstmt.setString(3, member.getPassword());
            pstmt.setInt(4, member.getNo());
            
            return pstmt.executeUpdate();

        } catch (Exception e) {
            throw new DaoException();
            
        }
    }
    
    public int delete(int no) {
        try (PreparedStatement pstmt = con.prepareStatement(
                "delete from ex_memb where no=?");
                ){
            
            pstmt.setInt(1, no);
            
            return pstmt.executeUpdate();

        } catch (Exception e) {
            throw new DaoException();
        }
    }
    
    public Member selectOne(int no) {
        try (PreparedStatement pstmt = con.prepareStatement(
                        "select no,name,email,regdt from ex_memb where no=?");
                ){
            
            pstmt.setInt(1, no);
            ResultSet rs = pstmt.executeQuery();
            
            Member member = null;
            if (rs.next()) {
                member = new Member();
                member.setNo(no);
                member.setName(rs.getString("name"));
                member.setEmail(rs.getString("email"));
                member.setCreateDate(rs.getDate("regdt"));
                return member;
            }
            rs.close();
            return member;
        } catch (Exception e) {
            throw new DaoException();
        }
    }
}
