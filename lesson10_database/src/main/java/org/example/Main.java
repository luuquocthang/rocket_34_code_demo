package org.example;

import org.example.dao.StudentDao;

import java.sql.Date;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        StudentDao studentDao = new StudentDao();
//        Date dob = new Date(1994, 8, 1);
        Date dob1 = Date.valueOf("1994-09-01");
        Student s1 = new Student(1, "luu thang", dob1, "thang123@yahoo.com.vn", 9.0, "Dai Mo");
        String insertResult = studentDao.insert(s1);
        System.out.println(insertResult);
        ArrayList<Student> students = studentDao.selectAll();
        for (Student s: students) {
            System.out.println(s);
        }
    }
}