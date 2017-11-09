package java100.app.domain;

import java.sql.Date;

import java100.app.control.CSVFormatException;

public class Board {
    protected int number;
    protected String title;
    protected String contents;
    protected Date regDate;
    protected int viewCount;
    
    public Board() {}
    
    public Board(String csv) throws CSVFormatException {
        String[] rec = csv.split(",");
        if(rec.length != 5)
            throw new CSVFormatException("CSV 데이터 항목의 개수가 올바르지 않습니다.");
        this.number = Integer.parseInt(rec[0]);
        this.title = rec[1];
        this.contents = rec[2];
        this.regDate = Date.valueOf(rec[3]);
        this.viewCount = Integer.parseInt(rec[4]);
    }
    
    public String toCSVString() {
        return String.format("%d,%s,%s,%s,%d",
                this.getNumber(),
                this.getTitle(),
                this.getContents(),
                this.getRegDate().toString(),
                this.getViewCount());
    }
    
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
