package bitcamp.java100.ch14.ex4;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

public class Test1_3 {
    public static void main(String[] args) throws Exception {
        
        Score4 s = new Score4("홍길동", 800, 900, 1000, 900);
        
        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("test3_new.dat"));
        
        out.writeObject(s);
        
        out.close();
        
        System.out.println("출력을 완료했습니다.");
    }
}
