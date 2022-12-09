package work;

import java.util.Scanner;

public class Task007 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in); 
        System.out.println("Введите размер массива: ");
        int n = input.nextInt();
    }

    public static int func(int n){
            return n * (n + 1) / 2;
        }

    public static void showResult(int n, int result){
        System.out.println(n + "-е треугольное число равно: " + result);
}
}

