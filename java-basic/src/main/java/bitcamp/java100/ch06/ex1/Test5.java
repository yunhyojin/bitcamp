package bitcamp.java100.ch06.ex1;

public class Test5 {

    public static void main(String[] args) {

        Score4 score;

        //score = new Score4(); - 컴파일 오류!
        
        //score = new Score4("홍길동");
        
        score = new Score4("임꺽정", 100, 80, 70);

        System.out.printf("이름=%s\n", score.name);
        System.out.printf("총점=%d\n", score.sum);
        System.out.printf("평균=%f\n", score.aver);

        // score = new Score3; - 컴파일 오류!

        // score = new Score3("홍길동"); - 컴파일 오류!
        
    }
}
