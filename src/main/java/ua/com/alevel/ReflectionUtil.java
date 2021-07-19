package ua.com.alevel;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.UUID;

public class ReflectionUtil {

    Class<?> aClass;
    Constructor<?> constructor;
    Field field;
    Method method;

    public static <T> T createObject(Class<T> tClass) {
        try {
            return tClass.getDeclaredConstructor().newInstance();
        } catch (InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
            e.printStackTrace();
        }
        throw new RuntimeException("can not create");
    }

    public static void initrandomFields(User user) {
        Class<? extends User> aClass = user.getClass();
        Field[] declaredFields = aClass.getDeclaredFields();
        for (Field field : declaredFields) {
            if (field.getType().isPrimitive()) {
                System.out.println("field = " + field);
                field.setAccessible(true);
                try {
                    field.set(user, 25);
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
            if (field.getType().isAssignableFrom(String.class)) {
                try {
                    field.setAccessible(true);
                    field.set(user, UUID.randomUUID().toString());
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void runSomeMethod(User user) {
        Method[] declaredMethods = user.getClass().getDeclaredMethods();
        for (Method method : declaredMethods) {
            if (method.isAnnotationPresent(RunTest.class)) {
                System.out.println("method = " + method);
                method.setAccessible(true);
                try {
                    method.invoke(user);
                } catch (IllegalAccessException | InvocationTargetException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void reviewClass(Class<?> classObject) {
        System.out.println("classObject = " + classObject.toString());
        System.out.println("classObject = " + classObject.getName());
        System.out.println("classObject = " + classObject.getSimpleName());
        System.out.println("classObject = " + classObject.getTypeName());
    }

    public static void reviewFields(Class<?> classObject, User user) {
//        try {
//            Field firstName = classObject.getDeclaredField("firstName");
//            System.out.println("firstName = " + firstName);
//        } catch (NoSuchFieldException e) {
//            e.printStackTrace();
//        }
        Field[] fields = classObject.getDeclaredFields();
        for (Field field : fields) {
            if (field.getType().isPrimitive()) {
                System.out.println("field = " + field);
                field.setAccessible(true);
                try {
                    field.set(user, 25);
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
            if (field.getType().isAssignableFrom(Integer.class)) {

            }
        }
    }

    public static void reviewMethods(Class<?> classObject, User user) {
//        Method[] methods = classObject.getMethods();
//        for (Method method : methods) {
//            System.out.println("method = " + method);
//        }
//
//        System.out.println();

        Method[] declaredMethods = classObject.getDeclaredMethods();
        for (Method method : declaredMethods) {
//            System.out.println("declared method = " + method);
//            System.out.println("declared method = " + method.getName());
            if (method.isAnnotationPresent(RunTest.class)) {
                System.out.println("method = " + method);
                method.setAccessible(true);
                try {
                    method.invoke(user);
                } catch (IllegalAccessException | InvocationTargetException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
