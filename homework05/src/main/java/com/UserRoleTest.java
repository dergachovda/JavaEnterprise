package com;

public class UserRoleTest {

    public static void main(String[] args) {

        User user = new User();
        user.setName("Dima");
        user.setSurName("Derhachov");
        user.setAge(30);
        Role role = user.getClass().getAnnotation(UserRoleAnnotation.class).value();

        System.out.println(user + " has role: " + role);
    }

}
