package bitcamp.java100.ch09.ex6;

public class Test2 {
    public static void main(String[] args) {
        
        Stack2<Contact> contacts = new Stack2<Contact>();
        contacts.push(new Contact("홍길동", "hong@test.com", "1111-1111"));
        contacts.push(new Contact("임꺽정", "leem@test.com", "1111-1112"));
        contacts.push(new Contact("유관순", "yoo@test.com", "1111-1113"));
        //contacts.push(new String("안중근"));
        //contacts.push(new Boolean(true));
        
        contacts.pop();
        
        BookStack bookStack = new BookStack();
        bookStack.push(new Book());
        bookStack.push(new Book());
        //bookStack.push(new String());
        //bookStack.push(new Integer(20));
        Stack2<Book> score = new Stack2<>();
        Book b1 = score.pop();
        Book b2 = score.pop();
        
        ContactStack contactStack = new ContactStack();
        contactStack.push(new Contact());
        contactStack.push(new Contact());
        
        Contact c1 = contactStack.pop();
        Contact c2 = contactStack.pop();
        
        
        
    }
}
