package java100.app.domain;

import java.sql.Date;

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

}
