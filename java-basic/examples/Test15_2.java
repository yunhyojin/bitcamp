package bitcamp.java100;

public class Test15_2 {

    public static void main(String[] args) {
        byte b1 = 10;
        byte b2 = 20;
        //byte b3 = b1 - b2; - 컴파일 오류

        short s1 = 10;
        short s2 = 20;
        //short s3 = s1 + s2; - 컴파일 오류

        int r = s1 + s2;
        long r2 = s1 + s2;
    }
}