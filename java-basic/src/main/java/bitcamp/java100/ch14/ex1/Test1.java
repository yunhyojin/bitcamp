package bitcamp.java100.ch14.ex1;

import java.io.File;
import java.sql.Date;

public class Test1 {

    public static void main(String[] args) throws Exception {
        
        File file = new File("../java-project/build.gradle");
        //File file = new File(".");
        
        System.out.printf("파일명=%s\n", file.getName());
        System.out.printf("파일객체를 생성할 때 넘겨준 경로=%s\n", file.getPath());
        System.out.printf("절대경로=%s\n", file.getAbsolutePath());
        System.out.printf("계산된경로=%s\n", file.getCanonicalPath());
        System.out.printf("기준디렉토리=%s\n", file.getParent());
        System.out.printf("전체용량=%s\n", file.getTotalSpace());
        System.out.printf("남은용량=%s\n", file.getFreeSpace());
        System.out.printf("사용가능한용량=%s\n", file.getUsableSpace());
        System.out.printf("존재여부=%s\n", file.exists());
        System.out.printf("파일여부=%s\n", file.isFile());
        System.out.printf("디렉토리여부=%s\n", file.isDirectory());
        System.out.printf("파일이나 디렉토리크기=%s\n", file.length());
        
        System.out.printf("읽기=%s\n", file.canRead());
        System.out.printf("쓰기=%s\n", file.canWrite());
        System.out.printf("실행=%s\n", file.canExecute());
        
        System.out.printf("마지막 변경일=%s\n",
                new Date(file.lastModified()).toString());
        System.out.printf("마지막 변경시간=%s\n",
                new Date(file.lastModified()).toLocaleString());
        
    }

}
