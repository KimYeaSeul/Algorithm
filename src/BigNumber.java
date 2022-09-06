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
    String.join("", listInt);
    StringBuilder stringBuilder = new StringBuilder();
    for (int i = 0; i < listInt.size(); i++){
        stringBuilder.append(listInt.get(i));
    }
    answer = stringBuilder.toString();

    // 0 으로 시작한다는건 뒤에가 다 0이라는거지
    // 0보다 큰수가 있으면 맨 앞으로 왔을테니까!
    if(answer.startsWith("0"));
    return answer;
  }
}
// 얘는 안나오네?
// String answer = "";
//         answer = Arrays.stream(numbers)
//         .mapToObj(String::valueOf)
//         .sorted((s1, s2) -> -s1.concat(s2).compareTo(s2.concat(s1)))
//         .reduce("", (s1, s2) -> s1.equals("0") && s2.equals("0") ? "0" : s1.concat(s2));
//         return answer;
// // 얘는 stream import하라고 나오고 // lexical compare?
// List<String> result = Arrays.stream(numbers)
//   .mapToObj(n -> String.valueOf(n))
//   .collect(Collectors.toList());
// Collections.sort(result, (s1, s2) -> (s2+s1).compareTo(s1+s2));

// if(result.get(0).equals("0")) {  return "0"; }

// return result.stream().collect(Collectors.joining());