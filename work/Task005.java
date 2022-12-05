package work;

import java.util.ArrayList;

public class Task005 {

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

     
    
    static String Min(ArrayList<String> arr) {

        String Min = arr.get(0);

        for (String elem : arr) {

            if (elem.length() < Min.length()) Min = elem;

        }
        return Min;
    }


    
    public static void main(String[] aaa) {

        int a = 5;
        int b = 60;
        int c = 6;
        int d = 2;
        qwerty(a, b, c, d, a + "");

         
        StringBuilder route = new StringBuilder();

       

        

       
        // route.append(arr);
        // System.out.println(route);
        route.append(Min(arr));
        System.out.println(route);

    }
}