import java.util.ArrayList;

class KeyPad {
  public static void main(String[] args) {
    KeyPad kp = new KeyPad();
    int[] numbers = { 1, 3, 4, 5, 8, 2, 1, 4, 5, 9, 5 };
    String hand = "right";
    // "LRLLLRLLRRL"
    System.out.println(kp.solution(numbers, hand));
  }

  int[][] keyPad = {{3,1},{0,0},{0,1},{0,2},{1,0},{1,1},{1,2},{2,0},{2,1},{2,2}};
  int[] L = {3,0};
  int[] R = {3,2};
  ArrayList<String> list = new ArrayList<>();

  public String solution(int[] numbers, String hand) {
        
    for(int n : numbers){
        int row = keyPad[n][1];
        if(row==0) finger("L", n);
        else if(row==2) finger("R", n);
        else if(row==1){
            int lll = distance(n, L);
            int rrr = distance(n, R);
            if(lll < rrr || (lll == rrr && hand.equals("left"))){
                finger("L", n);
            }else if(lll > rrr || (lll == rrr && hand.equals("right"))){
                finger("R", n);
            }
        }
    }
    return String.join("",list);
  }

  public void finger(String thum, int n){
      if(thum.equals("R")) R=keyPad[n];
      else if(thum.equals("L")) L=keyPad[n];
      list.add(thum);
  }

  public int distance(int n, int[] thum){
      return Math.abs(keyPad[n][0]-thum[0]) + Math.abs(keyPad[n][1]-thum[1]);
  }
}