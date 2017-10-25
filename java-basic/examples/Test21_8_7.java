package bitcamp.java100;

import java.io.Console;

public class Test21_8_7 {

    static Console console;

    static Contact[] contacts = new Contact[100];

    static int cursor = 0;

    static class Contact {
        String name;
        String email;
        String tel;
    }

    static void printContacts() {
        for (int i = 0; i < size(); i++) {
            Contact contact = get(i);
            System.out.printf("%s %s %s\n", contact.name, contact.email, contact.tel);
        }
    }

    static boolean confirm(String message) {
        String input = console.readLine(message + "(y/n) ");
        if (input.toLowerCase().equals("y") || input.toLowerCase().equals("yes"))
            return true;
        return false;
    }

    static Contact inputContact() {

        Contact contact = new Contact();

        contact.name = console.readLine("이름? ");
        contact.email = console.readLine("이메일? ");
        contact.tel = console.readLine("전화? ");

        return contact;
    }

    static void add(Contact contact) {
        contacts[cursor] = contact;
        cursor++;
    }

    static Contact get(int index) {
        return contacts[index];
    }

    static int size() {
        return cursor;
    }

    public static void main(String[] args) {

        console = System.console();

        if (console == null) {
            System.err.println("콘솔을 지원하지 않습니다.");
            System.exit(1);
        }

        while (cursor < contacts.length) {

            Contact contact = inputContact();

            if (confirm("저장하시겠습니까?")) {
                add(contact);
            }

            if (!confirm("계속 입력하시겠습니까?"))
                break;
        }
        printContacts();
    }
}