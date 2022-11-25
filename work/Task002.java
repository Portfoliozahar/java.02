package work;

import java.io.*;
import java.util.Scanner;

public class Task002 {


    public static int pow(int n, int deg) {
        int result = n;
        for (int i = 1; i < deg; i++)
            result *= n;
        return result;
    }

    public static int resultPow(int n, int deg) {
        if (deg > 0) return pow(n, deg);
        else if (deg < 0) return 1 / pow(n, -deg);
        else return 1;
    }

    public static void file_read() throws Exception {
        FileReader file_read = new FileReader("input.txt");
        Scanner scan = new Scanner(file_read);
        int a = 0, b = 0;
        while (scan.hasNextLine()) {
            String data_line = scan.nextLine();
            String[] data_file = data_line.split(" ");
            if (data_file[0].equals("a")) {
                a = Integer.parseInt(data_file[1]);
            } else if (data_file[0].equals("b")) {
                b = Integer.parseInt(data_file[1]);
            }
        }

        System.out.println("Число " + a + " в степени " + b + " равно " + resultPow(a, b));
        file_read.close();
    }

    
public static void main(String[] args) throws Exception {
  
    Scanner input = new Scanner(System.in);
    System.out.print("Введите название файла: ");
    String example = input.nextLine().replace(" ", "") + ",";
    if (example.contains(".txt")) file_read();
   
}

}
