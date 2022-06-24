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
    Arrays.sort(numbers);
    // sort는 아니다.그렇다고 한글자씩 떼서 볼 수도 없다.
    Integer[] refInt = new Integer[numbers.length];
    for(int i =0; i<numbers.length; i++){
      refInt[i] = numbers[i];
    }
    Arrays.sort(refInt, new Comparator<Integer>() {
      // Override된 compare 함수를 어떻게 정의하냐에 따라서 다양한 정렬이 가능해집니다
      @Override
      public int compare(Integer o1, Integer o2) {
          String v1 = "" + o1 + o2;
            String v2 = "" + o2 + o1;
            int v = Integer.parseInt(v2)-Integer.parseInt(v1);
          // System.out.println(o1 + " - "+ o2 + " = "+v  );
          return v;
      }
    });
      
      for(int n : refInt){
        answer += n;
      }
      if(answer.startsWith("0"));
    return answer;
  }
}
