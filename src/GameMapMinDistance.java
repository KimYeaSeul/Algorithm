import java.util.Stack;

public class GameMapMinDistance {
  public static void main(String[] args) {
    GameMapMinDistance gmmd = new GameMapMinDistance();
    int[][] maps = {{1,0,1,1,1},{1,0,1,0,1},{1,0,1,1,1},{1,1,1,0,1},{0,0,0,0,1}};
    System.out.println(gmmd.solution(maps));
  }
  public int solution(int[][] maps){
    int answer = maps.length*maps[0].length;
    boolean[][] visited = new boolean[maps.length][maps[0].length];

    Stack<Robot> stack = new Stack<>();

    stack.push(new Robot(0 , 0, 1));

    while(!stack.isEmpty()){
      Robot now = stack.pop();
      if(now.x<0 || now.x >=maps.length) continue;
      if(now.y<0 || now.y >=maps[0].length) continue;
      if(visited[now.x][now.y]) continue;
      
      visited[now.x][now.y] = true;
      if(maps[now.x][now.y] != 0) {
        stack.push(now.left());
        stack.push(now.right());
        stack.push(now.up());
        stack.push(now.down());
      }
      if(now.x == maps.length-1 && now.y == maps[0].length-1){
        answer = Math.min(answer, now.count);
      }
    }
    return answer;
  }

  public class Robot{
    int x = 0;
    int y = 0;
    int count = 0;
    Robot(int x, int y, int c){
      this.x = x; this.y = y; this.count = c;
    }
    Robot left(){ return new Robot(this.x-1, this.y, this.count+1);} 
    Robot right(){return new Robot(this.x+1, this.y, this.count+1);} 
    Robot up(){ return new Robot(this.x, this.y-1, this.count+1); }
    Robot down(){ return new Robot(this.x, this.y+1, this.count+1); }
  }
}