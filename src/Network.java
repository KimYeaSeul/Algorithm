import java.util.*;

public class Network {
  public static void main(String[] args) {
    Network nw = new Network();
    int n =3;
    int[][] computers = {{1, 1, 0},{1, 1, 0},{0, 0, 1}};
    // 2
    System.out.println(nw.solution(n, computers));
  }
  public int solution(int n, int[][] computers) {
    int answer = 0;
    List<Node> list = new LinkedList<>();
    Queue<Node> q = new LinkedList<>();
    
    for(int l=0; l<n; l++) list.add(new Node(l)); // 0, 1, 2
    
    for(int i = 0; i<n; i++){
        for(int j = 0; j<n; j++){
            if(i==j) continue;
            if(computers[i][j] == 1){
                list.get(i).links.add(list.get(j));
            }
        }
    }
    
    for(Node w : list){
        if(q.isEmpty()) {
            if(w.visit) continue;
            q.add(w);
            answer++;
        }
        while(!q.isEmpty()){
          Node now = q.poll();
            now.visit = true;
            for(Node ww : now.links){
                if(ww.visit) continue;
                q.add(ww);
            }
        }
    }
    return answer;
}

  class Node{
      int i = 0;
      List<Node> links = new ArrayList<>();
      boolean visit = false;
      Node(int i) { this.i = i;}
  }
}
