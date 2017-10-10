public class task2 {
    public static void main(String[] args) {
        
        String[] names = {"홍길동", "임꺽정", "유관순"};
        int[] a = {100, 80, 100};
        int[] b = {90, 80, 100};
        int[] c = {80, 80, 100};

        for (int i = 0; i < names.length; i++) {
            int d = a[i] + b[i] + c[i];
            float e = d / 3.0f;
            System.out.printf("%-4s %4d %4d %4d %4d %6.1f\n", names[i], a[i], b[i], c[i], d, e);

        }

        
    }
}