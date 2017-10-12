package bitcamp.java100;

public class Test12_9 {    

    public static void main(String[] args) {

        char c1;

        c1 = 44032;
        char c2 = 0xAC00;

        char n1 = 0xC724, n2 = 0xD6A8,  n3 = 0xC9C4;

        System.out.println(c1);
        System.out.println(c2);

        System.out.printf("%c %c %c\n", n1, n2, n3);

        n1 = '윤';
        n2 = '효';
        n3 = '진';

        System.out.printf("%c %c %c\n", n1, n2, n3);

        char x = '7';
        int num;

        num = x - '0';
        System.out.println(num);


    }
    
}