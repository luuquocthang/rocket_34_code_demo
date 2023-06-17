package vn.vti.entities;

public class Student extends Person{
    private int mark;
    private String[] className;

    public Student(int id, String fullName, int age, int cardNumber, int mark, String[] className) {
        super(id, fullName, age, cardNumber);
        this.mark = mark;
        this.className = className;
    }

    public int getMark() {
        return mark;
    }

    public void setMark(int mark) {
        this.mark = mark;
    }

    public String[] getClassName() {
        return className;
    }

    public void setClassName(String[] className) {
        this.className = className;
    }

    public void showInfo() {
        super.showInfo();
        System.out.println("Student:");
        System.out.println("- Mark:" + this.mark);
        System.out.println("- Class");
        for (int i = 0; i < this.className.length; i++) {
            System.out.println("  -" + this.className[i]);
        }
    }


    public int sum(int a, int b) {
        return a+b;
    }
    public int sum(int a, int b, int c) {
        return a+b+c;
    }

    public int sum(int a, int b, int c, int d) {
        return a+b+c+d;
    }

    public float sum(float a, int b) {
        return a+b;
    }

}
