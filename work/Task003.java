package work;

import java.util.Arrays;
 

public class task003 {
    
    public static int[] A = {19, -123, 823, 15, 7, -6, 1, 5, -6, 0};    
    

    public static void Arr(int[] A) {
        if (A.length == 1 || A.length == 0)
            return;
        int middleIndex = A.length / 2;
        int[] l = new int[middleIndex];
        int[] r = new int[A.length - middleIndex];
        

        for (int i = 0; i < middleIndex; i++)
            l[i]=A[i];
        for (int i=middleIndex; i<A.length; i++)
           r[i - middleIndex] = A[i];

        Arr(l);
        Arr(r);
        Merge(A, l, r);      
    }

    public static void Merge(int [] A , int [] l, int [] r) {
        int n = 0 , m = 0 ,k = 0 ;
        while( n < l.length  && m < r.length) {
            if (l[n] <= r[m]) {
               A[k] = l[n];
                n++; 
            } else {
                A[k] = r[m];
                m++;
            }
            k++;
        }
        while (n < l.length) {
            A[k] = l[n];
            n++;
            k++;
        }
        while (m < r.length){
            A[k] = r[m];
            m++;
            k++;
        }
          
    }
    
    public static void main(String[] args) {
        
        System.out.println(Arrays.toString(A)); 
        Arr(A);              
        System.out.println(Arrays.toString(A)); 
    }
}

    





      
    


