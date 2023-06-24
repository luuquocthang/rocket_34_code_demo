public class Main {
    private int id;
    public static String str;
    public final float PI = 3.14f;

    public float getPI() {
        return PI;
    }

    public static void show() {
//        System.out.println(id); // trong hàm static thì không sử dụng được các field non-static của class đó
        System.out.println("This class has main method");
    }

    public static void main(String[] args) {
        Main main = new Main();
//        {
//            int a = 10;
//        }
//        System.out.println(a);
        System.out.println(str);
        main.show(); // nó cũng được gọi như các hàm thông thường
        show(); // nếu như mà hàm đấy được gọi tại main trong cùng class mà nó đc khai báo thì không cần tên Class
        Main.show(); // hàm static không cần khởi tạo đối tượng mà có thể gọi trực tiếp bằng tên class
        DateFormat df1 = new DateFormat("yyyy-MM-dd");
        DateFormat df2 = new DateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println(df1.DATE_F1);
        System.out.println(df2.DATE_F1);
    }

    static {
        str = "thang";
    }
}
