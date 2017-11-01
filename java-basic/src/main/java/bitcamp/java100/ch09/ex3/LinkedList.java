package bitcamp.java100.ch09.ex3;

public class LinkedList {
    private class Box {
        Object value;
        Box next;
    }
   
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
        if (index < 0 || index >= len)
            return null;
        Box box = head;
        for (int count = 1; count <= index; count++) {
            box = box.next;
        }
        /*
         * for (int i = 0; count< i; i++) { box = box.next; } - 실제 실무에서는 이렇게 'i'를 사용 한다
         */

        return box.value;
    }

    public void insert(int index, Object value) {
        if (index < 0 || index >= len)
            return;
        Box box = new Box();
        box.value = value;
        
        len++;
        
        if (index == 0) {
            box.next = head;
            head = box;
            return;
        }
        Box pre = head;
        for (int count = 1; count < index; count++) {
            pre = pre.next;
        }
        box.next = pre.next;
        pre.next = box;
    }

    public Object remove(int index) {
        if (index < 0 || index >= len)
        return null;
        
        len--;
        
        Box removedBox;
        if (index == 0) {
            removedBox = head;
            head = head.next;
            return removedBox.value;
        }
        
        Box pre = head;
        
        for (int count = 1; count < index; count++) {
            pre = pre.next;
        }
        removedBox = pre.next;
        pre.next = pre.next.next;
        
        if(index ==len -1) {
            tail = pre;
        }
        return removedBox.value;
    }
}
