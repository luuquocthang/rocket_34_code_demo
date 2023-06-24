import java.util.Arrays;
import java.sql.Date;

public class Student {
    private int id;
    private String[] subjects;
    private int mark;
    private String[] advantage;
    private String[] disAdvantage;
    private Date beginDate;

    public Student() {
    }

    public Student(int id, String[] subjects, int mark, String[] advantage, String[] disAdvantage, Date beginDate) {
        this.id = id;
        this.subjects = subjects;
        this.mark = mark;
        this.advantage = advantage;
        this.disAdvantage = disAdvantage;
        this.beginDate = beginDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String[] getSubjects() {
        return subjects;
    }

    public void setSubjects(String[] subjects) {
        this.subjects = subjects;
    }

    public int getMark() {
        return mark;
    }

    public void setMark(int mark) {
        this.mark = mark;
    }

    public String[] getAdvantage() {
        return advantage;
    }

    public void setAdvantage(String[] advantage) {
        this.advantage = advantage;
    }

    public String[] getDisAdvantage() {
        return disAdvantage;
    }

    public void setDisAdvantage(String[] disAdvantage) {
        this.disAdvantage = disAdvantage;
    }

    public Date getBeginDate() {
        return beginDate;
    }

    public void setBeginDate(Date beginDate) {
        this.beginDate = beginDate;
    }

    public Student(String[] subjects) {
        this.subjects = subjects;
    }

    public void showInfo() {
//        System.out.println("Subjects: ");
//        for (int i = 0; i < this.subjects.length; i++) {
//            System.out.println("-" + this.subjects[i]);
//        }
        System.out.println("Id: " + this.id);
        System.out.println("Mark: " + this.mark);
        System.out.println("Begin date: " + this.beginDate);
        System.out.println("Subjects: " + Arrays.toString(this.subjects));
        System.out.println("Advantage: " + Arrays.toString(this.advantage));
        System.out.println("DisAdvantage: " + Arrays.toString(this.disAdvantage));
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", subjects=" + Arrays.toString(subjects) +
                ", mark=" + mark +
                ", advantage=" + Arrays.toString(advantage) +
                ", disAdvantage=" + Arrays.toString(disAdvantage) +
                ", beginDate=" + beginDate +
                '}';
    }
}
