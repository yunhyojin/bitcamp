package bitcamp.java100.ch07.ex4;

public class Test2 {

    public static void main(String[] args) {
        Test2 obj = new Test2();
        System.out.println(obj.toString());

        System.out.println(Integer.toHexString(obj.hashCode()));

        Test2 obj2 = new Test2();
        Test2 obj3 = obj;
        System.out.println(obj.equals(obj2));
        System.out.println(obj.equals(obj3));

        System.out.println("--------------------------");

        String s1 = new String("Hello");
        String s2 = new String("Hello");
        System.out.println(s1 == s2);
        System.out.println(s1.equals(s2));

        System.out.println("--------------------------");

        StringBuffer sb1 = new StringBuffer("Hello");
        StringBuffer sb2 = new StringBuffer("Hello");
        System.out.println(sb1 == sb2);
        System.out.println(sb1.equals(sb2));

        System.out.println("--------------------------");
        
        Class c = obj.getClass();
        System.out.println(c.getName());

    }
}
