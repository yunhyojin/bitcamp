package bitcamp.java100.ch08.ex1.other;

import bitcamp.java100.ch08.ex1.A;

public class Test3 extends A {
    public static void main(String[] args) {
        //A.v1 = 100; // - 접근불가!
        //A.v2 = 200; // - 접근불가!
        A.v3 = 300;
        A.v4 = 400;
    }
}
