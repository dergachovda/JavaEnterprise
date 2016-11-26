package com.bugs.reflection;

public class User {
    private String name;
    private String surName;
    private int age;
    private String companyName;
    private String veryImportantField;

    public User() {
    }

    public User(String name, String surName, int age, String companyName) {
        this.name = name;
        this.surName = surName;
        this.age = age;
        this.companyName = companyName;
    }

    public User(String name) {
        this.name = name;
    }

    public User(String companyName, String surName, String name) {
        this.companyName = companyName;
        this.surName = surName;
        this.name = name;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurName() {
        return surName;
    }

    public void setSurName(String surName) {
        this.surName = surName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }


    private void verySecurityMethod(){
        System.out.println("hi I am very security method");
    }


    public String getVeryImportantField() {
        return veryImportantField;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (getAge() != user.getAge()) return false;
        if (getName() != null ? !getName().equals(user.getName()) : user.getName() != null) return false;
        if (getSurName() != null ? !getSurName().equals(user.getSurName()) : user.getSurName() != null) return false;
        return !(getCompanyName() != null ? !getCompanyName().equals(user.getCompanyName()) : user.getCompanyName() != null);

    }

    @Override
    public int hashCode() {
        int result = getName() != null ? getName().hashCode() : 0;
        result = 31 * result + (getSurName() != null ? getSurName().hashCode() : 0);
        result = 31 * result + getAge();
        result = 31 * result + (getCompanyName() != null ? getCompanyName().hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", surName='" + surName + '\'' +
                ", age=" + age +
                ", companyName='" + companyName + '\'' +
                '}';
    }
}
