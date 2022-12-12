
package work;


import java.util.LinkedList;
import java.util.Random;


public class Task006 {

   
    public static class Model {
        int [] start = new int[0];
        int [] finish = new int[0];
        int [] finish2 = new int[0];
        int [][] ind = {{-1, 0}, {0, -1}, {0, 1}, {1, 0}, {-1, -1}, {-1, 1}, {1, -1}, {1, 1}};
    
       
        public int[][] craftMap(int[] size){
            int[][] map = new int [size[0]][size[1]];
    
            for (int i = 0; i < size[1]; i++) map[0][i] = -1;
            for (int i = 0; i < size[1]; i++) map[size[0] - 1][i] = -1;
            for (int i = 0; i < size[0]; i++) map[i][0] = -1;
            for (int i = 0; i < size[0]; i++) map[i][size[1] - 1] = -1;
    
            Random random = new Random();
            int temp;
    
            for(int i = 1; i < size[0] - 1; i++){
                for(int j = 1; j < size[1] - 1; j++){
                    temp = random.ints(0, 8).findFirst().getAsInt();
                    if (temp == 7) map[i][j] = -1;
                }
            }
            int s = -2;
            int f = -3;
            start = pick(s, map);
            finish = pick(f, map);
            finish2 = pick(f, map);
            return map;
        }
    
     
        public void fillMap(int[][] map){
            LinkedList<int[]> point = new LinkedList<int[]>();
            point.offer(start);
            while(point.peek() != null){
                int[] flux = point.poll();
                for (int i = -1; i < 2; i++){
                    for (int j = -1; j < 2; j++){
                        if(map[flux[0] + i][flux[1] + j] == 0){
                            int[] temp = new int [3];
                            temp[0] = flux[0] + i;
                            temp[1] = flux[1] + j;
                            temp[2] = flux[2] + 1;
                            point.offer(temp);
                            map[flux[0] + i][flux[1] + j] = temp[2];
                        }
                    }
                }
            }
        }
   
        public void shortWay (int[][] map){
            MinWay(finish, map);
            MinWay(finish2, map);
            int min = 0;
            int[] flux = new int [2];
            if(finish[2] < finish2[2]){
                flux[0] = finish[0] + ind[finish[3]][0];
                flux[1] = finish[1] + ind[finish[3]][1];
                min = finish[2];
            }
            else{
                flux[0] = finish2[0] + ind[finish2[3]][0];
                flux[1] = finish2[1] + ind[finish2[3]][1];
                min = finish2[2];
            }
            map[flux[0]][flux[1]] = -4;
    
            while (min > 0){
                for (int i = 0; i < 8; i++){
                    if(map[flux[0] + ind[i][0]][flux[1] + ind[i][1]] < min
                    && (map[flux[0] + ind[i][0]][flux[1] + ind[i][1]] > 0 || map[flux[0] + ind[i][0]][flux[1] + ind[i][1]] == -2)){
                        min = map[flux[0] + ind[i][0]][flux[1] + ind[i][1]];
                        flux[0] = flux[0] + ind[i][0];
                        flux[1] = flux[1] + ind[i][1];
                        if (min == -2);
                        else map[flux[0]][flux[1]] = -4;
                        break;
                    }
                }  
            }   
        }
    
        
        public int[] pick(int sign, int[][] map){
            int sizeY = map.length - 1;
            int sizeX = map[0].length - 1;
            int y;
            int x;
            int[] point = new int [4]; 
            Random random = new Random();
            y = random.ints(1, sizeY).findFirst().getAsInt();
            x = random.ints(1, sizeX).findFirst().getAsInt();
            while(map[y][x] == 0){  
                    map[y][x] = sign;
                    point[0] = y;
                    point[1] = x;
                    point[2] = 0;
                    point[3] = 0;
                    break;
                } 
            
            return point;
        }
    
        
        public void MinWay(int[] point, int[][] map){
            for (int i = 0; i < 8; i++){
                    if(map[point[0] + ind[i][0]][point[1] + ind[i][1]] > 0 && point[2] > map[point[0] + ind[i][0]][point[1] + ind[i][1]]){
                        point[2] = map[point[0] + ind[i][0]][point[1] + ind[i][1]];
                        point[3] = i;
                    }
                    else if(map[point[0] + ind[i][0]][point[1] + ind[i][1]] > 0 && point[2] == 0){
                        point[2] = map[point[0] + ind[i][0]][point[1] + ind[i][1]];
                        point[3] = i;
                }
            }
        }
    }
  
        public static void Map(int[][] map){
            int sizeY = map.length;
            int sizeX = map[0].length;
            for (int i = 0; i < sizeY; i++){
                for(int j = 0; j < sizeX; j++){
                    if(map[i][j] == -1)System.out.print('#');
                    else if(map[i][j] == 0)System.out.print(' ');
                    else if(map[i][j] == -2)System.out.print('S');
                    else if(map[i][j] == -3)System.out.print('F');
                    else if(map[i][j] == -4)System.out.print('@');
                    else System.out.print(" ");
                }
                System.out.println();
            }
        }
    
    
    
    
        public static void Main(){
            int height = 20;
            int width = 40;
            int[] size = {height, width};
            Model map2 = new Model();
            int[][] map = map2.craftMap(size);
            map2.fillMap(map);
            map2.shortWay (map);
            Map(map);
        }
    
    public static void main(String[] args) {
        Main();
    }
}
