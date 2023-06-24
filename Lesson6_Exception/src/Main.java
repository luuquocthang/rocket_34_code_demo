import java.io.IOException;
import java.sql.Date;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void show() {
        System.out.println("show");
        show();
    }

    public void inputValue(String input, int mode) throws InputExceptionCustom, IOException {
        switch (mode) {
            // int
            case 1:
                int number = Integer.parseInt(input);
                if(number < 0 ) {
//                    InputExceptionCustom inputExceptionCustom = new InputExceptionCustom("Can't convert input to number");
//                    throw inputExceptionCustom;
                    throw new InputExceptionCustom("Can't convert input to int");
                }
                break;
//                double
            case 2:
                double number1 = Double.parseDouble(input);
                if(number1 < 0 ) {
//                    InputExceptionCustom inputExceptionCustom = new InputExceptionCustom("Can't convert input to number");
//                    throw inputExceptionCustom;
                    throw new InputExceptionCustom("Can't convert input to double");
                }
                break;
            default:
                throw new IOException("input invalid");
        }
    }

    public static void main(String[] args) {
//        try {
//            show();
//        } catch (Exception e) {
//            System.out.println(e.getMessage());
//            e.printStackTrace();
//        }

        Main m = new Main();
        try {
            m.inputValue("10", 1);
            m.inputValue("-10", 2);
            m.inputValue("10", 3);
        } catch (InputExceptionCustom e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        String[] subjects = {"toan", "ly", "hoa"};
        Student s0 = new Student(subjects);
        s0.showInfo();
        System.out.println(s0);

//        for (int i = 0; i < 10000000; i++) {
//            if (i == 999999) {
//                System.out.println(i);
//            }
//            System.out.println(i);
//        }
        // Enter
        Scanner sc = new Scanner(System.in);
        int id;
        while (true) {
            try {
                System.out.println("Enter id:");
                String idStr  = sc.nextLine();
                id = Integer.parseInt(idStr);
                break;
            } catch (NumberFormatException e) {
                System.out.println("Id invalid. Pls try again!!");
            }
        }

        System.out.println("Enter mark:");
        String markStr  = sc.nextLine();
        int mark = Integer.parseInt(markStr);
        Date date;
        while (true) {
            try {
                System.out.println("Enter date(yyyy-mm-dd):");
                String dateStr  = sc.nextLine();
                date = Date.valueOf(dateStr);
                break;
            } catch (Exception e) {
                System.out.println(e.getMessage());
                e.printStackTrace();
                System.out.println("Date invalid. Pls try again!!");
            }
        }

        System.out.println(date.toString());
        System.out.println("Enter all subject(split by \",\"):");
        String subject  = sc.nextLine();
        String[] subjects1 = subject.split(",");
        System.out.println(id + " " + mark + " " + date + " " + Arrays.toString(subjects1));
    }
}
