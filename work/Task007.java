package work;

import java.util.Scanner;

public class Task007 {
      
    public static int num() {
        Scanner input = new Scanner(System.in);
            System.out.println("Введите число: ");
            int n = input.nextInt(); 
            return n;
    }
    public static int func(int n){
        return n * (n + 1) / 2;
    }

    public static void res(int n, int resault){
        System.out.println(n + " треугольное число равно: " + resault);
    }

    public static void main(String[] args) {
        int n = num();
        int res = func(n);
        res(n, res);
    }
}


    

       