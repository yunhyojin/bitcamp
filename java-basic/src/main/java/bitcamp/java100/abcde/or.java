package bitcamp.java100.abcde;

import java.util.Scanner;

public class or {
    static boolean confrim(String message) {
        Scanner keyScan = new Scanner(System.in);
        System.out.println(message);
        String repeans = keyScan.nextLine().toLowerCase();
        
        if (repeans.equals("y") || repeans.equals("yes"))
            return true;
        return false;
    }

    public static void main(String[] args) {
        Score[] scores = new Score[100];
        int cursor = 0;
        
        while (true) {
            Score score = new Score();
            score.input();
            scores[cursor++] = score;
            
            if(!confrim("계속입력하시겠습니까? "))
                break;
        }
        for(int i = 0; i < cursor; i++)
            scores[i].print();
    }
}
