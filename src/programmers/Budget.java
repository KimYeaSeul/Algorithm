import java.util.Arrays;

public class Budget {
    public static void main(String[] args) {
        Budget b = new Budget();
        int[] d = {1, 3, 2, 5, 4};
        int budget = 9;
        // 3
        System.out.println(b.solution(d, budget));
    }
  public int solution(int[] d, int budget) {
        Arrays.sort(d);
        int answer = 0;
        // 덧셈
        // int useBudget=0;
        // for(int i=0; i<d.length; i++){
        //     useBudget = useBudget+d[i];
        //     if(useBudget > budget) break;
        //     answer++;
        // }

        // 뺄셈
        for(int i=0; i<d.length;i++){
            budget -= d[i];
            if(budget<0) break;
            answer++;
        }
        return answer;
    }


}