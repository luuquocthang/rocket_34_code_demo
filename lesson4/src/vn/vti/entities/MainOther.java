package vn.vti.entities;

public class MainOther {
    public static void main(String[] args) {
        Employee employee = new Employee();
        System.out.println(employee.test + employee.address + employee.sex);
        employee.setId(10);
        employee.show();

    }
}
