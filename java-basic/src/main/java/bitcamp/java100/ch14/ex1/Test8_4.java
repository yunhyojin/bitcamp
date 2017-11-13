package bitcamp.java100.ch14.ex1;

public class Test8_4 {
    static int f(int n) {
        long v0,v1,v2,v3,v4,v5,v6,v7,v8,v9,v10;
        
        
        long[] arr = new long[100];
        if (n % 1000 == 0)
            
            if (n == 0) {
                return 0;
            }
            return n + f(n - 1);
    }
    
    public static void main(String[] args) throws Exception {
        int sum = f(100000);
        System.out.println(sum);
        
        
    }

}
