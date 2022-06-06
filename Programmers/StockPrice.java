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
    int[] answer = new int[prices.length];

    int low=0;
    for(int i=0; i<prices.length; i++){
        int now = prices[i];
        low = 0;
        for(int j=i+1; j<prices.length; j++){
            low++;
            if(prices[j] < now) break;
        }
        // System.out.println("now = " + now + "low = " +low);
        answer[i] = low;
    }
    return answer;
}
}
