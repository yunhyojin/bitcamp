package java100.app.control;

import java.io.PrintWriter;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java100.app.dao.MemberDao;
import java100.app.domain.Member;

@Component("/member")
public class MemberController implements Controller{

    @Autowired
    MemberDao memberDao;
    
    @Override
    public void destroy() {}

    @Override
    public void init() {

        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            throw new RuntimeException("JDBC 드라이버 클래스를 찾을 수 없습니다.");
        }
    }

    @Override    
    public void execute(Request request, Response response) {
        switch (request.getMenuPath()) {
        case "/member/list": this.doList(request, response); break;
        case "/member/add": this.doAdd(request, response); break;
        case "/member/view": this.doView(request, response); break;
        case "/member/update": this.doUpdate(request, response); break;
        case "/member/delete": this.doDelete(request, response); break;
        default: 
            response.getWriter().println("해당 명령이 없습니다.");
        }
    }

    private void doList(Request request, Response response) {
        PrintWriter out = response.getWriter();
        out.println("[회원 목록]");

        try {
            List<Member> list = memberDao.selectList();

            for (Member member : list) {
                out.printf("%d, %s, %s, %s\n",
                        member.getNo(),
                        member.getName(),
                        member.getEmail(),
                        member.getCreateDate());
            }

        } catch (Exception e) {
            e.printStackTrace();
            out.println(e.getMessage());
        }
    }

    private void doAdd(Request request, Response response) {
        PrintWriter out = response.getWriter();

        out.println("[회원 등록]");

        try {
            Member member = new Member();
            member.setName(request.getParameter("name"));
            member.setEmail(request.getParameter("email"));
            member.setPassword(request.getParameter("password"));

            memberDao.insert(member);
            out.print("저장하였습니다.");

        } catch (Exception e) {
            e.printStackTrace();
            out.println(e.getMessage());
        }

    } 

    private void doView(Request request, Response response) {
        PrintWriter out = response.getWriter();
        out.println("[회원 상세 정보]");

        try {
            int no = Integer.parseInt(request.getParameter("no"));
            Member member = memberDao.selectOne(no);

            if (member != null) {
                out.printf("번호: %d\n", member.getNo());
                out.printf("이름: %s\n", member.getName());
                out.printf("이메일: %s\n", member.getEmail());
                out.printf("등록일: %s\n", member.getCreateDate());
            } else {
                out.printf("'%d'의 성적 정보가 없습니다.\n", no);
            }
        } catch (Exception e) {
            e.printStackTrace();
            out.println(e.getMessage());
        }

    }

    private void doUpdate(Request request, Response response) {
        PrintWriter out = response.getWriter();
        out.println("[회원 변경]");

        try {
            Member member = new Member();
            member.setNo(Integer.parseInt(request.getParameter("no")));
            member.setName(request.getParameter("name"));
            member.setEmail(request.getParameter("email"));
            member.setPassword(request.getParameter("password"));

            if(memberDao.update(member) > 0) {
                out.print("변경하였습니다.");
            }else {
                out.printf("'%s'의 회원 정보가 없습니다.\n", member.getNo());
            }

        } catch (Exception e) {
            e.printStackTrace();
            out.println(e.getMessage());
        }
    }

    private void doDelete(Request request, Response response) {
        PrintWriter out = response.getWriter();
        out.println("[회원 삭제]");

        try {
            int no = Integer.parseInt(request.getParameter("no"));

            if (memberDao.delete(no) > 0) {
                out.println("삭제했습니다.");
            } else {
                out.printf("'%d'의 회원 정보가 없습니다.\n", no);
            }

        } catch (Exception e) {
            e.printStackTrace();
            out.println(e.getMessage());
        }
    }

}