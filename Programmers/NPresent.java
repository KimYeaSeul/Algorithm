import java.util.*;
public class NPresent {
  public int solution(int N, int number) {
    List<Set<Integer>> list = new ArrayList<>();
    for(int i=0; i<9; i++){
      list.add(new HashSet<>());
    }
    list.get(1).add(N);
    if(number == N) return 1;
    for(int i=2; i<9; i++){
      for(int j=1; j<=i/2; j++){
        numberParse(list.get(i), list.get(i-j), list.get(j));
        numberParse(list.get(i), list.get(j), list.get(i-j));
      }
        String str = String.valueOf(N);
        list.get(i).add(Integer.parseInt(str.repeat(i)));
      for(Integer n : list.get(i)){
        if(n == number){
          return i;
        }
      }
    }
  return -1;
  }
  public void numberParse(Set<Integer> unionSet, Set<Integer> fibo1, Set<Integer> fibo2){
    for(Integer f1 : fibo1){
      for(Integer f2 : fibo2){
        unionSet.add(f1+f2);
        unionSet.add(f1-f2);
        unionSet.add(f1*f2);
        if(f2!=0) unionSet.add(f1/f2);
      }
    }
  }
}
