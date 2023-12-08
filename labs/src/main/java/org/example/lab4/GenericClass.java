package org.example.lab4;

import java.lang.reflect.Method;

public class GenericClass {
    public static <T extends MyInterface> void callMyMethod(T instance) {
        try {
            Method method = MyInterface.class.getDeclaredMethod("method");
            method.invoke(instance);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        MyClass myClass = new MyClass();
        callMyMethod(myClass);
    }
}
