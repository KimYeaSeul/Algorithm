import java.util.*;
public class EngEndTalk {
  public static void main(String[] args) {
    EngEndTalk eet = new EngEndTalk();
    int n = 3;
    String[] words = {"tank", "kick", "know", "wheel", "land", "dream", "mother", "robot", "tank"};
    //[3, 3]
    int[] result = eet.solution(n, words);
    System.out.println("[ "+result[0]+", "+result[1]+"]");
  }
  public int[] solution(int n, String[] words) {
    int[] answer = new int[2];
    
    List<String> list = new ArrayList<>();
    list.add(words[0]);
    
    // 탈락인지 통과인지 -> 전글자의 마지막 글자와 현재 글자의 첫번째 글자 비교 & 나왔던 글자인지 확인
    for(int i=1; i<words.length; i++){
        String now = words[i];
        String lastWord = words[i-1].substring(words[i-1].length()-1);
        String firstWord = now.substring(0,1);
        
        if(list.contains(now) || !lastWord.equals(firstWord)){
            answer[0] = (i%n) + 1;
            answer[1] = (i/n) + 1;
            break;
        }else{
            list.add(now);
        }
    }
    return answer;
}
}
