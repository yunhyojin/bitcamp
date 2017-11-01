package bitcamp.java100.ch08.ex7;

public class B2 extends B {
    //void m1(int a, String s) {}
    //protected void m1(int a, String s) {}
    //public void m1(int a, String s) {}
    
    //int m1(int a, String s) {} - 컴파일 오류
    void m1(int a, String s) {}
    void m1(String a, String s) {}
    void m1(String s, int a) {}
    void m1(int a) {}
    
}
