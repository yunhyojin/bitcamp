package bitcamp.java100;

public class Test14_2 {    

    public static void main(String[] args) {

        class Book {
            String title;
            String author;
            String press;
            int pageSize;
            double price;
        }
        Book b1;

        b1 = new Book();
        b1.title = "자바의정석";
        b1.author = "남궁성";
        b1.press = "도우출판";
        b1.pageSize = 526;
        b1.price = 3.14f;

        System.out.printf("%s %s %s %d %f\n", b1.title, b1.author, b1.press, b1.pageSize, b1.price);



    } 

}