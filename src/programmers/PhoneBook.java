import java.util.*;
public class PhoneBook {

  public static void main(String[] args) {
    PhoneBook pb = new PhoneBook();
    String[] phone_book={"119","97674223","11955245421"};
    // false
    System.out.println(pb.solution(phone_book));
  }

  public boolean solution(String[] phone_book) {        
      Set<Integer> length = new HashSet<>();
      for(String p: phone_book) length.add(p.length());
      Integer[] y = length.toArray(new Integer[length.size()]);
      
      HashMap<String, Integer> hm = new HashMap<>();
      for(String p: phone_book) hm.put(p, 1);
      
      for(String p: phone_book){
          for(int i=0; i<y.length; i++){
              // 같은 전화번호가 중복해서 들어있지 않으므로 <= 으로 변경
              if(p.length() <= y[i]) break;
              String c = p.substring(0, y[i]);
              // 미리 HashMap에 값을 다 넣어놓고 비교!
              if(hm.containsKey(c)) return false;
          }
      }
      return true;
  }
}
