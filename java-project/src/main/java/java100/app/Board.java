package java100.app;

import java.sql.Date;
import java.util.Scanner;

public class Board {
    protected int number;
    protected String title;
    protected String contents;
    protected Date regDate;
    protected int viewCount;
    
    public Board() {}
    
    @Override
    public String toString() {
        return "Board [number=" + number + ", title=" + title + ", contents=" + contents + ", regDate=" + regDate
                + ", viewCount=" + viewCount + "]";
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContents() {
        return contents;
    }

    public void setContents(String contents) {
        this.contents = contents;
    }

    public Date getRegDate() {
        return regDate;
    }

    public void setRegDate(Date regDate) {
        this.regDate = regDate;
    }

    public int getViewCount() {
        return viewCount;
    }

    public void setViewCount(int viewCount) {
        this.viewCount = viewCount;
    }

    public void input() {
        Scanner keyScan = new Scanner(System.in);
        
        System.out.print("번호? ");
        this.number = Integer.parseInt(keyScan.nextLine());
        
        System.out.print("제목? ");
        this.title = keyScan.nextLine();
        
        System.out.print("내용? ");
        this.contents = keyScan.nextLine();
        
        this.regDate = new Date(System.currentTimeMillis());
    }

    public void print() {
        System.out.printf("%d, %s, %s, %d\n",  
                this.number, 
                this.title,
                this.regDate.toString(),
                this.viewCount); 
    }

    public void printDetail() {
        System.out.printf("제목: %s\n", this.title);  
        System.out.printf("내용: %s\n", this.contents);  
        System.out.printf("등록일: %s\n", this.regDate.toString());  
        System.out.printf("조회수: %d\n", ++this.viewCount);  
    }
    
    public void update() {
        Scanner keyScan = new Scanner(System.in);
        
        System.out.printf("제목?(%s) ", this.title);
        String title = keyScan.nextLine();
        if(title.isEmpty()) {
            title = this.title;
        }
        
        System.out.printf("내용?(%s) ", this.contents);
        String contents = keyScan.nextLine();
        
        if (Prompts.confirm2("변경하시겠습니까?(y/N) ")) {
            this.title = title;
            this.contents = contents;
            this.regDate = new Date(System.currentTimeMillis());
            System.out.println("변경하였습니다.");
            
        } else {
            System.out.println("변경을 취소하였습니다.");
        }
    }
    
}
