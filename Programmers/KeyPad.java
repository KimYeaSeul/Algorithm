class KeyPad {
  public static void main(String[] args) {
    KeyPad kp = new KeyPad();
    int[] numbers = { 1, 3, 4, 5, 8, 2, 1, 4, 5, 9, 5 };
    String hand = "right";
    // "LRLLLRLLRRL"
    System.out.println(kp.solution(numbers, hand));
  }

  public String solution(int[] numbers, String hand) {
    String answer = "";
    int[][] keyPad = { { 3, 1 }, { 0, 0 }, { 0, 1 }, { 0, 2 }, { 1, 0 }, { 1, 1 }, { 1, 2 }, { 2, 0 }, { 2, 1 },
        { 2, 2 } };
    int[] L = { 3, 0 };
    int[] R = { 3, 2 };

    for (int n : numbers) {
      int row = keyPad[n][1];
      if (row == 0) {
        L = keyPad[n];
        answer += "L";
      } else if (row == 2) {
        R = keyPad[n];
        answer += "R";
      } else if (row == 1) {
        int lll = Math.abs(keyPad[n][0] - L[0]) + Math.abs(keyPad[n][1] - L[1]);
        int rrr = Math.abs(keyPad[n][0] - R[0]) + Math.abs(keyPad[n][1] - R[1]);
        if (lll > rrr) {
          R = keyPad[n];
          answer += "R";
        } else if (lll < rrr) {
          L = keyPad[n];
          answer += "L";
        } else if (lll == rrr && hand.equals("left")) {
          L = keyPad[n];
          answer += "L";
        } else if (lll == rrr && hand.equals("right")) {
          R = keyPad[n];
          answer += "R";
        }
      }
    }
    return answer;
  }
}