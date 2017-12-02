package bitcamp.java100.ch18;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class Test5 {

    public static void main(String[] args) throws Exception {

        Class<?> clazz = Z.class;
        
        Method m = clazz.getDeclaredMethod("m3", int.class, float.class);
        System.out.printf("메서드명: %s\n", m.getName());
        System.out.printf("리턴 타입: %s\n", m.getReturnType().getName());

        int modifieres = m.getModifiers();
        
        if (Modifier.isPublic(modifieres)) {
            System.out.println("public 이다");
        } else if (Modifier.isProtected(modifieres)) {
            System.out.println("protected 이다");
        } else if (Modifier.isPrivate(modifieres)) {
            System.out.println("private 이다");
        }
        
        System.out.println(Modifier.toString(modifieres));
    }

}
