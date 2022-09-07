import java.util.ArrayList;
import java.util.List;

public class alrg {
  public static void main(String[] args) {
    alrg a = new alrg();
    int n = 4;
    boolean horizontal=true;
    a.solution(n, horizontal);
  }
  public int[][] solution(int n, boolean horizontal) {
    int[][] answer = new int[n][n];
    boolean[][] visited= new boolean[n][n];
    
    int x = 0;
    int y = 0;
    int count = 1;
    while(count<=(n*n)){
      // robot now = list.get(0);
      visited[x][y]= true;
      if(x == 0 && y==0){
        answer[0][0] = count;
        if(horizontal){
          x=0; y=1;
        } // 수직
        else{
          x=1; y=0;
        } //  수평
        
        count++;
        System.out.println(count+ "번째에서 left " + x +", "+ y);
        answer[x][y] = count;
        continue;
      }

      int max = Math.max(x, y);
      System.out.println(count+ "max =  " + max);
      // 수직
      if(!horizontal) {
        if(x == max){
          while(y>0){
            x--;
            count++;
            System.out.println(count + "번째 Up"+ x +", "+y);
          }
        }
        if(x == 0){
          while(y<max){
            x++;
            count++;
            System.out.println(count + "번째 Down"+ x +", "+y);
          }
        }
          
      }else if(horizontal){ // 수평
        if(y == max){
          while(y>0){
            y--;
            count++;
            System.out.println(count + "번째 left"+ x +", "+y);
          }
        }
        if(y == 0){
          while(y<max){
            y++;
            count++;
            System.out.println(count + "번째 right"+ x +", "+y);
          }
        }
      }

      if(x==y || x==0 || y==0){horizontal = !horizontal;}
      System.out.println(horizontal);
    }    
    return answer;
  }
}
// 1, 2, 9, 10
// 4, 3, 8, 11
// 5, 6, 7, 12
// 16, 15, 14, 13