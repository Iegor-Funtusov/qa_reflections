package ua.com.alevel;

import java.util.ArrayList;
import java.util.List;

public class ReflectionsMain {

    public static void main(String[] args) {
        System.out.println("ReflectionsMain.main");

        List<User> users = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            users.add(ReflectionUtil.createObject(User.class));
        }

        for (User user : users) {
            ReflectionUtil.initrandomFields(user);
        }

        for (User user : users) {
            System.out.println("user = " + user);
        }

        for (User user : users) {
            ReflectionUtil.runSomeMethod(user);
        }
    }
}
