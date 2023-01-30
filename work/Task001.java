
// На вход некоторому исполнителю
// подаётся два числа (a, b).

// У исполнителя есть две команды
// - команда 1 (к1): увеличить в с раз (xC), а умножается на c
// - команда 2 (к2): увеличить на d ( +d ), к a прибавляется d
// написать программу, которая выдаёт общее количество
// возможных преобразований a в b.

// a < b; a, b, c, d - натуральные

// Пример 1: а = 2, b = 7, c = 2, d = 1 ответ 3

// Подумать как можно показать хотя бы один маршрут преобразования

// ответ: (+1) (x2) (+1) или (х2) (+1) (+1) (+1)
// Пример 2: а = 11, b = 7, c = 2, d = 1
// ответ: нет решения.



package work;

import java.util.ArrayList;

public class Task001 {

    static ArrayList<String> arr = new ArrayList<>();

    static void qwerty(int a, int b, int c, int d, String str) {
        if (a == b) {
           arr.add(str);
        }
        if (a < b) {
           qwerty(a * c, b, c, d, str + "*" + c  );
           qwerty(a + d, b, c, d, str + "+" + d  );
        }
    }

     

    public static void main(String[] aaa) {

        int a = 5;
        int b = 60;
        int c = 6;
        int d = 5;
        qwerty(a, b, c, d, a + "");

            StringBuilder route = new StringBuilder();

            route.append(arr);
            System.out.println(route + " = " + b);
        }
    }
