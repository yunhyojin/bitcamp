package bitcamp.java100.abcde;

public class LinkedList {
    Box head;
    Box tail;
    int len;

    public void add(Object value) {
        Box box = new Box();
        box.value = value;
        if (tail == null) {
            head = box;
            tail = box;
        } else {
            tail.next = box;
            tail = box;
        }
        len++;
    }

    public int size() {
        return len;
    }

    public Object get(int index) {
        if(index < 0 || index >= len)
            return null;
        Box box = head;
        for (int count = 1; count <= index; count++) {
            box = box.next;
        }
        return box.value;
    }
    public void insert(int index, Object value) {
        if(index < 0 || index >= len)
            return;
        Box box = new Box();
        box.value = value;
        len++;
        if(index == 0) {
            box.next = head;
            head = box;
            return;
        }
    }
}
