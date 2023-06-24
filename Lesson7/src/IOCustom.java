import java.io.*;

public class IOCustom {

    public static File createFile(String path) {
        File f1 = new File(path);
        if(!f1.exists()) {
            try {
                f1.createNewFile();
            } catch (IOException e) {
                System.out.println(e.getMessage());
                e.printStackTrace();
            }
        }
        return f1;
    }

    public static void main(String[] args) {
        // read & write byte
        File file1 = createFile("file1.txt");
        try {
            FileInputStream fis = new FileInputStream(file1);
//            int a = fis.read();
//            char a1 = (char) a;
//            int b = fis.read();
//            char b1 = (char) b;
//            System.out.println(a1);
//            System.out.println(b1);
//            cách 1
//            int temp = fis.read();
//            while (temp != -1) {
//                System.out.print((char) temp);
//                temp = fis.read();
//            }
//            System.out.println();

//            cách 2 + 3
//            int lengthFile = fis.available();
//            byte[] data = new byte[lengthFile];
//            fis.read(data);

            byte[] data = fis.readAllBytes();
            for (int i = 0; i < data.length; i++) {
                System.out.print((char) data[i]);
            }
            System.out.println();
            fis.close();

//            write file
            FileOutputStream fos = new FileOutputStream(file1, true);
            String content = "\nluu quoc thang";
            byte[] dataWrite = content.getBytes();
            fos.write(dataWrite);
            fos.close();

        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }

        // read + write String

        System.out.println("=======File2========");
        File file2 = createFile("file2.txt");
        try {
            FileReader fr = new FileReader(file2);
            //only use FileReader
//            char[] content = new char[1000];
//            fr.read(content);
//            System.out.println(content);
//            int temp = fr.read();
//            while (temp != -1) {
//                System.out.print((char) temp);
//                temp = fr.read();
//            }
            BufferedReader br =new BufferedReader(fr);
            String line = br.readLine();
            while (line != null && line.length() > 0) {
                System.out.println(line);
                line = br.readLine();
            }
            br.close();
            fr.close();
            FileWriter fw = new FileWriter(file2, true);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write("\nluu thang 1");
            bw.flush();
            bw.close();
            fw.close();
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }

        File file3 = createFile("file3.txt");
        try {
            FileOutputStream fos = new FileOutputStream(file3);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            DateFormat df1 = new DateFormat("yyyy-mm");
            oos.writeObject(df1);
            oos.close();
            fos.close();

            FileInputStream fis = new FileInputStream(file3);
            ObjectInputStream ois = new ObjectInputStream(fis);
            DateFormat df2 = (DateFormat)ois.readObject();
            System.out.println(df2.DATE_F1);

        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }
}
