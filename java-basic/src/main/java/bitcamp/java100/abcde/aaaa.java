package bitcamp.java100.abcde;

public class aaaa {

    static int m1(int p) {
        return m2(p + 1); // m2()를 호출한 후 m2()가 리턴한 값을 리턴한다.
    }
    
    static int m2(int q) {
        return m3(q + 1);
    }
    
    static int m3(int r) {
        return m4(r + 1);
    }
    
    static int m4(int s) {
        return s + 1;
    }
    
    
    public static void main(String[] args) {
        int result = m1(1);
        System.out.println(result);
    }
}
