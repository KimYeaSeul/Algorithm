import java.util.*;
public class MiddleExem {
public static void main(String[] args) {
  MiddleExem me = new MiddleExem();
  int[] answers = {1,3,2,4,2};
  // [1, 2, 3]
  System.out.println(me.solution(answers));
}
public int[] solution(int[] answers) {
      
    int[] supoza1 = { 1, 2, 3, 4, 5 };  
    int[] supoza2 = { 2, 1, 2, 3, 2, 4, 2, 5 };
    int[] supoza3 = { 3, 3, 1, 1, 2, 2, 4, 4, 5, 5 };
    int supoza1Collect = collectAnswers(supoza1, answers);
    int supoza2Collect = collectAnswers(supoza2, answers);
    int supoza3Collect = collectAnswers(supoza3, answers);
    
    int max = 0;
    max = Math.max(supoza1Collect, max);
    max = Math.max(supoza2Collect, max);
    max = Math.max(supoza3Collect, max);
    
    ArrayList<Integer> l = new ArrayList<>();
    
    if(supoza1Collect == max) l.add(1);
    if(supoza2Collect == max) l.add(2);
    if(supoza3Collect == max) l.add(3);
    int[] answer = new int[l.size()];
    for(int i = 0 ; i<answer.length; i++){
        answer[i] = l.get(i);
    }
    
    return answer;
  }
  
  public int collectAnswers(int[] supoza, int[] answers){
    // 나머지가 1이면 첫번째(0)꺼 2이면 2번(1)째 3이면 3번(2)째 4이면 4번(3)째 0이면 다섯번째(4)
    int sl = supoza.length;
    int collect = 0;
    int supozaAnswer = 0;
    for(int a = 0; a<answers.length; a++){
        int turn = ((a+1)%sl); // 1/5 = 0 ... 1 5/5 = 1 ... 0
        if(turn == 0) supozaAnswer = supoza[sl-1];
        else supozaAnswer = supoza[turn-1];
        if(supozaAnswer == answers[a]) collect++;
    }
    return collect;        
  }
}
