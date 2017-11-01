package bitcamp.java100.ch10.ex1;

public class Test2 {
    static class A {}

    class B {}

    Object obj = new Object() {
        String name;
        public void m1() {
        }
    };
    public static void main(String[] args) {
        class C {}
        Object obj2 = new Object() {
            String name;
            public void m1() {
            }
        };
    }
}
