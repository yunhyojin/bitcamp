package bitcamp.java100.ch09.ex6;

public class BookStack {
    private class Box {
        Book value;
        Box next;

        public Box() {
        }
        public Box(Book value) {
            this.value = value;
        }
    }
    Box top;
    int len;
    public void push(Book value) {
        Box box = new Box(value);
        box.next = top;
        top = box;
        len++;
    }
    public int size() { 
        return len;
    }
    public Book pop() {
        if (len == 0)
            return null;
        Box box = top;
        top = top.next;
        len--;
        return box.value;
    }
}
