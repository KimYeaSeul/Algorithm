import java.util.*;
public class BigNumber {
  public static void main(String[] args) {
    BigNumber bn = new BigNumber();
    // 6210
    int[] numbers1={6, 10, 2};
    System.out.println(bn.solution(numbers1));

    // 9534330
    int[] numbers2={3, 30, 34, 5, 9};
    System.out.println(bn.solution(numbers2));
  }
  public String solution(int[] numbers) {
    String answer = "";
    
    List<String> listInt = new ArrayList<>();
    for(int bb : numbers) listInt.add(String.valueOf(bb));
    Collections.sort(listInt, new Comparator<String>() {

      @Override
      public int compare(String o1, String o2) {
        String v1 = o1 + o2;
        String v2 = o2 + o1;
        int v = Integer.parseInt(v2)-Integer.parseInt(v1);
        return v ;
      }
      
    });
      
    answer = String.join("", listInt);
    // 0 으로 시작한다는건 뒤에가 다 0이라는거지
    // 0보다 큰수가 있으면 맨 앞으로 왔을테니까!
    if(answer.startsWith("0"));
    return answer;
  }
}
