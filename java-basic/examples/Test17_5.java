package bitcamp.java100;

public class Test17_5 {

    static String m1() {
        return "Hello";
    }

    static int m2() {
        return 100;
    }

    static boolean m3() {
        return true;
    }
    
    static int m6() {
        return 100;
        //int a = 100; - 컴파일 오류
        //a++; - 컴파일 오류
    }

    // static int m4() {return "hello";} - 컴파일 오류
    // static int m5() {} - 컴파일 오류

    public static void main(String[] args) {

        String v = m1();
        System.out.println(v);

        System.out.println(m1());

        m1();

        // String s = m2(); - 컴파일 오류
        
        

    }
}