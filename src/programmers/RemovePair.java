import java.util.*;

class RemovePair{
  public static void main(String[] args) {
    RemovePair rp = new RemovePair();
    String s = "baabaa";
    // 1
    System.out.println(rp.solution(s));
  }
  public int solution(String s) {
    char[] arrCh = s.toCharArray();
    Stack<Character> stack = new Stack<>();
    stack.push(arrCh[0]);
    for(int i=1; i< s.length(); i++){
        if(stack.size() == 0) {
            stack.push(arrCh[i]);
            continue;
        }
        
        char now = stack.peek();
        char next = arrCh[i];
        
        if(now == next) stack.pop();
        else stack.push(next);
    }
    if(stack.size() == 0) return 1;
    else return 0;
  }
}