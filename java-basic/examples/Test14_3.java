package bitcamp.java100;

public class Test14_3 {    
//비트캠프의 수강생 정보를 저장할 데이터 타입.
//이름 최종학력 생년월일 휴대폰번호
    public static void main(String[] args) {

        class BitCamp {
            String name;
            String degree;
            int birthDay;
            String cellPhone;
        }
        BitCamp b1;

        b1 = new BitCamp();
        b1.name = "윤효진";
        b1.degree = "양천고등학교";
        b1.birthDay = 910416;
        b1.cellPhone = "01049127578";

        System.out.printf("%s %s %d %s\n", b1.name, b1.degree, b1.birthDay, b1.cellPhone);



    } 

}