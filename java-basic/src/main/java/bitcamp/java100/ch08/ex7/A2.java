package bitcamp.java100.ch08.ex7;

public class A2 extends A {
    public void test1() {
        m4();
        m3();
        m2();
        //m1(); - 컴파일 오류!
    }
    private void m1() {
        System.out.println("B.m1()");
    }

    void m2() {}

    protected void m3() {}

    public void m4() {}
    
}
