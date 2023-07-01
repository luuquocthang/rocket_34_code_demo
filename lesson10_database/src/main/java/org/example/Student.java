package org.example;

import java.sql.Date;

public class Student {
    private int id;
    private String name;
    private Date dob;
    private String email;
    private Double mark;
    private String address;

    public Student() {
    }

    public Student(int id, String name, Date dob, String email, Double mark, String address) {
        this.id = id;
        this.name = name;
        this.dob = dob;
        this.email = email;
        this.mark = mark;
        this.address = address;
    }

    public Student(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Double getMark() {
        return mark;
    }

    public void setMark(Double mark) {
        this.mark = mark;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", dob=" + dob +
                ", email='" + email + '\'' +
                ", mark=" + mark +
                ", address='" + address + '\'' +
                '}';
    }
}
