import java.util.*;
class MoreHot {
  public static void main(String[] args) {
    MoreHot mh = new MoreHot();
    int[] scoville={1, 2, 3, 9, 10, 12};
    int K = 7;
    // 2
    System.out.println(mh.solution(scoville, K));
  }
  public int solution(int[] scoville, int K) {
      
    int answer = 0;
    int scv = 0;
    PriorityQueue<Integer> pq = new PriorityQueue<>();
    for(int s : scoville) pq.add(s);
    
    while(pq.size() > 1 && pq.peek() < K){
      int n1 = pq.poll();
      int n2 = pq.poll();
      scv = n1 + (n2 * 2);
      pq.add(scv);
      answer++;
    }
    return pq.peek() < K ? -1 : answer ;
  }
}