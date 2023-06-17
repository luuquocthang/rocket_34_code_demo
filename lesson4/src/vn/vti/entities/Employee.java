package vn.vti.entities;

import vn.vti.interfaces.IPerson;

import java.util.Date;

public class Employee extends Person implements IPerson {
    private Integer id;
    private String name;
    private Date birthDay;
    public String test;
    protected int sex;
    String address;

    private static double salary = 1000.0;

    public double getSalary() {
        return this.salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public void incrementSalary(double a) {
//        this.salary = this.salary + a;
        this.salary += a;

    }

    private Boolean intern;

    public Employee() {
        System.out.println("init Employee");
    }

    public Employee(Integer id) {
//        this();
        this.id = id;
    }

    public Employee(Integer idValue, String nameValue) {
        id = idValue;
        name = nameValue;
    }

    public Employee(Integer id, String name, Date birthDay, String test, int sex, String address) {
        this.id = id;
        this.name = name;
        this.birthDay = birthDay;
        this.test = test;
        this.sex = sex;
        this.address = address;
    }

    public Employee(int id, String fullName, int age, Integer id1, String name, Date birthDay, String test, int sex,
                    String address, Boolean intern) {
        super(id, fullName, age);
        this.id = id1;
        this.name = name;
        this.birthDay = birthDay;
        this.test = test;
        this.sex = sex;
        this.address = address;
        this.intern = intern;
    }

    public Integer getIdEmployee() {
        return this.id;
    }

    public void setId(Integer id) {
//        id.toString();
//        id.intValue();
//        Integer.parseInt("10");
        if (id < 0) {
            System.out.println("id invalid");
        } else {
            this.id = id;
        }
    }

    protected void show() {
//        System.out.println("Person");
//        System.out.println(super.fullName + "-" + super.age);
        super.showInfo();
        System.out.println("Employee:");
        String gt = this.sex == 1 ? "Male" : "Female";
        System.out.println(this.id + "-" + this.name + "-" + this.birthDay + "-" + this.test + "-" +  gt + "-" +
                this.address + "-" +  this.intern);
    }

    public void showInfo(){
        this.show();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(Date birthDay) {
        this.birthDay = birthDay;
    }

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Boolean getIntern() {
        return intern;
    }

    public void setIntern(Boolean intern) {
        this.intern = intern;
    }

    @Override
    public void showCarNumber() {
        System.out.println("Card Number" + super.getCardNumber());
    }

    @Override
    public void showFullName() {
        System.out.println("Full Name:" + this.fullName);
    }

    @Override
    public void showNameSalary() {
        System.out.println("Full Name: " + this.fullName + " and salary " + this.salary);
    }
}
