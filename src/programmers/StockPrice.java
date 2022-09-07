import java.util.Stack;
public class StockPrice {
  public static void main(String[] args) {
    StockPrice sp = new StockPrice();
    int[] prices = {1, 2, 3, 2, 3};
    int[] result = sp.solution(prices);
    // {4 3 1 1 0}
    System.out.print("{ ");
    for(int r : result){
      System.out.print(r+" ");
    }
    System.out.print("}");
  }
  public int[] solution(int[] prices) {
    int leng = prices.length;
    int[] answer = new int[leng];

    Stack<Integer> s = new Stack<>();
    
    s.push(0);
    for(int i=1; i<leng; i++){
        while(!s.empty() && prices[s.peek()] > prices[i]){
            int idx = s.pop();
            answer[idx] = i-idx;
        }
        s.push(i);
    }
    
    while(!s.empty()){
        int idx = s.pop(); 
        answer[idx] = leng - idx - 1;
    }
    return answer;
  }
}
