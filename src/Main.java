import java.io.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        writeFile();

        copyFile("data.txt", "data-copy.txt");
    }
    private static void writeFile() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập nội dung cần copy");
        String arr = scanner.nextLine();
        String PATH_FILE = "C:\\Users\\Asus\\Module2\\bai17\\Bai17-BT2-copy-file-nhi-phan\\src\\data.txt";
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(PATH_FILE);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(arr);

            fileOutputStream.close();
            objectOutputStream.close();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static void copyFile(String src, String dest) {
        File infile = new File("C:\\Users\\Asus\\Module2\\bai17\\Bai17-BT2-copy-file-nhi-phan\\src\\data.txt");
        File outfile = new File("C:\\Users\\Asus\\Module2\\bai17\\Bai17-BT2-copy-file-nhi-phan\\src\\data-copy.txt");
        FileInputStream instream = null;
        FileOutputStream outstream = null;

        try
        {
            instream = new FileInputStream(infile);
            outstream = new FileOutputStream(outfile);
            byte[] buffer = new byte[1024];
            int length;
            while ((length = instream.read(buffer)) > 0) {
                outstream.write(buffer, 0, length);
            }
            instream.close();
            outstream.close();
            System.out.println("Copy thành công");

        } catch (IOException e) {
            throw new RuntimeException();
        }
    }
}