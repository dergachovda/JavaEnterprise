package bug_10;

public class PrintObjectInformationProblem {

    public static void main(String[] args) {
        System.out.println(new User());
    }

}


class User {
    private User manager;

    private Company company;

    private String name;
    private String surName;
    private int age;

    public User getManager() {
        return manager;
    }

    public void setManager(User manager) {
        this.manager = manager;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
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

    @Override
    public String toString() {
        return "User{" +
                "manager=" + manager +
                ", company=" + company.getAddress()+
                ", name='" + name + '\'' +
                ", surName='" + surName + '\'' +
                ", age=" + age +
                '}';
    }
}

class Company {
    private String companyName;
    private String address;
    private String commonDescription;

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCommonDescription() {
        return commonDescription;
    }

    public void setCommonDescription(String commonDescription) {
        this.commonDescription = commonDescription;
    }

    @Override
    public String toString() {
        return "Company{" +
                "companyName='" + companyName + '\'' +
                ", address='" + address + '\'' +
                ", commonDescription='" + commonDescription + '\'' +
                '}';
    }
}