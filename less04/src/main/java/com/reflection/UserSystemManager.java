package com.reflection;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;

public class UserSystemManager {

    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {

        User user = new User("User", 12);
        Class<? extends User> userClass = user.getClass();
        System.out.println("Class name: " + userClass.getName());

        Constructor<?>[] constructors = userClass.getDeclaredConstructors();
        System.out.println("\nConstructors:");
        for (Constructor constructor : constructors) {
            printModifiersById(constructor.getModifiers());
            System.out.println(Arrays.toString(constructor.getGenericParameterTypes()));
        }
        System.out.println("\nFields:");
        Field[] fields = userClass.getDeclaredFields();
        for (Field field : fields){
            printModifiersById(field.getModifiers());
            System.out.println(field.getName() + " : " + field.getType());
        }

        System.out.println("\nuser = " + user);

        Field fieldName = userClass.getDeclaredField("name");
        fieldName.setAccessible(true);
        fieldName.set(user, "yyy");

        System.out.println("\nuser = " + user);


        System.out.println("\n\nString test:\n");

        String test = "test";
        System.out.println("str value= " + test + ";\n\t hc= " + test.hashCode());
        test = test.concat("_xxx");
        System.out.println("str value= " + test + ";\n\t hc= " + test.hashCode());

        //case with reflection
        test = "test";
        System.out.println("str value= " + test + ";\n\t hc= " + test.hashCode());
        Field value = test.getClass().getDeclaredField("value");
        value.setAccessible(true);
        value.set(test, "test_xxx".toCharArray());

        System.out.println("str value= " + test + ";\n\t hc= " + test.hashCode());

//        Field theUnsafe = Unsafe.class.getDeclaredField("theUnsafe");
//        theUnsafe.setAccessible(true);
//        Object o = theUnsafe.get(null);
//        Unsafe unsafe = (Unsafe) o;
//        unsafe.throwException(new IOException("DGHDFGHF"));

        Method[] methods = userClass.getMethods();
        for (Method method : methods) {
            Annotation[] annotations = method.getDeclaredAnnotations();
            for (Annotation an : annotations) {

            }
            System.out.println("method = " + method);
        }

    }

    private static void printModifiersById(int modifiers) {
        if(Modifier.isPublic(modifiers)) {
            System.out.println("public");
        }
        if(Modifier.isPrivate(modifiers)) {
            System.out.println("private");
        }
        if(Modifier.isFinal(modifiers)) {
            System.out.println("final");
        }

    }
}
