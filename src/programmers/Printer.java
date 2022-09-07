  
  import java.util.*;
  public class Printer {
    public static void main(String[] args) {
      Printer p = new Printer();
      int[] priorities = {2, 1, 3, 2};
      int location = 2;
      // 1
      System.out.println(p.solution(priorities, location));
    }
    public int solution(int[] priorities, int location) {
        // queue에 priorities 넣어 놓기
        Queue<Doc> q = new LinkedList<>();
        for(int i = 0; i<priorities.length; i++) q.add(new Doc(i, priorities[i]));
        // max를 구해서 max랑 같으면 list에 넣어주고
        // max가 아니면 맨 뒤에 넣어주기
        List<Doc> list = new LinkedList<>();
        while(!q.isEmpty()){
            int max = findPri(q);
            Doc now = q.poll();
            if(now.priority==max) list.add(now);
            else q.add(now);
        }
        // 원하는 location이 몇번째인지 구하기
        int answer = 1;
        for(Doc l : list){
            if(l.location == location) break;
            answer++;
        }
        
        return answer;
    }
    // 우선순위가 제일 높은값을 구하는 함수
    public int findPri(Queue<Doc> q){
        int max = 0;
        for(Doc qq : q) max = Math.max(qq.priority, max);
        return max;
    }
    // 프린터의 원래 위치와 우선순위를 저장한 클래스
    class Doc{
        int location = 0;
        int priority = 0;
        Doc(int l, int p){
            this.location = l;
            this.priority = p;
        }
    }
}
