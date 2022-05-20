import java.util.*;
class ColoringBook {

  Queue<Paint> q = new LinkedList<>();
  int area = 0;

  public static void main(String[] args) {
    ColoringBook cb = new ColoringBook();
    int m = 6;
    int n = 4;
    int[][] picture = {{1, 1, 1, 0}, {1, 2, 2, 0}, {1, 0, 0, 1}, {0, 0, 0, 1}, {0, 0, 0, 3}, {0, 0, 0, 3}};
    // {4, 5}
    System.out.println(cb.solution(m, n, picture));
  }

  public int[] solution(int m, int n, int[][] picture) {
      int numberOfArea = 0;
      int maxSizeOfOneArea = 0;

      int[] answer = new int[2];
      boolean[][] b = new boolean[picture.length][picture[0].length];

      for(int i =0; i<picture.length; i++){
          for(int j =0; j<picture[0].length; j++){
              if(picture[i][j] != 0 && !b[i][j]){
                  q.offer(new Paint(i, j));
                  b[i][j] = true;
                  area = 1;
                  maxSizeOfOneArea = Math.max(Area(i, j, b, picture) , maxSizeOfOneArea);
                  numberOfArea++;
              }
          }
      }
      answer[0] = numberOfArea;
      answer[1] = maxSizeOfOneArea;

    return answer;
  }

  public int Area(int x, int y, boolean[][] b, int[][] picture){
      if(q.isEmpty()) return area;
      Paint now = q.poll();
    // 상 하 좌 우
    int[][] move = {{now.x, now.y+1}, {now.x, now.y-1}, {now.x-1,now.y}, {now.x+1,now.y}};
    for(int i = 0; i< move.length; i++){
        int mX = move[i][0];
        int mY = move[i][1];
      if(mX < 0 || mX >= picture.length) continue;
      if(mY < 0 || mY >= picture[0].length) continue;
      if(b[mX][mY]) continue;
      if(picture[mX][mY] == picture[now.x][now.y]){
          q.offer(new Paint(mX, mY));
          b[mX][mY] = true;
          area++;
          Area(mX, mY, b, picture);
      }
    }
    return area;
  }

  class Paint{
    int x = 0;
    int y = 0;
    Paint(int x, int y){
        this.x=x;
        this.y=y;
    }        
  }
}