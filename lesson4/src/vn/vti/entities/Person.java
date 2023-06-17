package vn.vti.entities;

import vn.vti.interfaces.IPerson;

public class Person extends A {
    private int id;
    protected String fullName;
    protected int age;

    private int cardNumber;

    public Person() {}

    public Person(int id, String fullName, int age) {
        this.id = id;
        this.fullName = fullName;
        this.age = age;
    }

    public Person(int id, String fullName, int age, int cardNumber) {
        this.id = id;
        this.fullName = fullName;
        this.age = age;
        this.cardNumber = cardNumber;
    }

    public int getCardNumber() {
        return this.cardNumber;
    }

    public void setCardNumber(int cardNumber) {
        this.cardNumber = cardNumber;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void showInfo() {
        System.out.println("Person:");
        System.out.println("- Id " + this.id);
        System.out.println("- Full name " + this.fullName);
        System.out.println("- Age " + this.age);
        System.out.println("- Card Number " + this.cardNumber);
    }

    public int sum (int a, int b) {
        return 10;
    }

}
