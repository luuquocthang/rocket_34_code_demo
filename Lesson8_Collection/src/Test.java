import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Test {

    public static String str;
    public static void show(int a) {
        a = 7;
    }

    public static void setMarkStudent(Student s) {
        s.setMark(100);
    }

    public static void setStudent(Student s) {
        s = new Student(2, "thang2", 200);
    }

    public static void main(String[] args) {
        int a1 = 10;
        show(a1);
        System.out.println(a1);
        Student j = new Student(1, "luu quoc thang", 10);
//        setMarkStudent(j);
//        System.out.println(j.getMark());
        setStudent(j);
        System.out.println(j);

        String a = "luu quoc thang";
        String b = "luu quoc thang";
        if (a == b) {
            System.out.println("ok");
        } else {
            System.out.println("NG");
        }

        if (a == j.getName()) {
            System.out.println("ok");
        } else {
            System.out.println("NG");
        }

//        if (str.equals("luu quoc thang")) {
//            System.out.println("ok");
//        } else {
//            System.out.println("NG");
//        }

        if ("luu quoc thang".equals(str)) {
            System.out.println("ok");
        } else {
            System.out.println("NG");
        }

        String c = new String("luu quoc thang");
        String d = new String("luu quoc thang");
        if (c == d) {
            System.out.println("ok");
        } else {
            System.out.println("NG");
        }

//        Date date = new Date("2021-09-01");
        String dateStr = "1994-09-01 21:00:00";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        try {
            Date date = sdf.parse(dateStr);
            SimpleDateFormat sdf1 = new SimpleDateFormat("dd-MM-yyyy");
            System.out.println(sdf1.format(date));
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }
}
