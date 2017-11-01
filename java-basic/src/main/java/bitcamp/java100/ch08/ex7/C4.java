package bitcamp.java100.ch08.ex7;

public class C4 extends C3 {
    @Override
    void m1() {
        System.out.println("C4.m1()");
    }
    
    @Override
    void m2() {
        System.out.println("C4.m2()");
    }

    void tset1() {
        this.m1();
        super.m1();
        // super.super.m1(); - 컴파일 오류!
        this.m2();
        super.m2();

        this.m3();
        super.m3();

        this.m4();
        super.m4();
    }

    public static void main(String[] args) {
        C4 obj = new C4();
        obj.tset1();
    }
}
