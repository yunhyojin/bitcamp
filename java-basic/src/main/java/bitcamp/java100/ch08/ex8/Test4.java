package bitcamp.java100.ch08.ex8;

public class Test4 {
    public static void main(String[] args) {
        A obj = new A();
        obj.m1(100);
        
        //int value = obj.m1(200); - 컴파일 오류!
        
        obj.m2();
        
        int result = obj.m2();
    }
}
