package ua.com.alevel;

import java.util.List;

public class GenericTest<USER extends User> {

    private List<USER> objects;

    public void add(USER user) {
        objects.add(user);
    }

    public List<USER> getUsers() {
        return objects;
    }

    public void test() {
        GenericTest<Personal> userGenericTest = new GenericTest<>();
        userGenericTest.add(new Personal());
        userGenericTest.add(new Personal());
        userGenericTest.add(new Personal());

        List<Personal> personals = userGenericTest.getUsers();
    }
}
