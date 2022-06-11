import java.util.*;

public class Knumber {
  public static void main(String[] args) {
    Knumber kn = new Knumber();
    int[] array = {1, 5, 2, 6, 3, 7, 4};
    int[][] commands = {{2, 5, 3}, {4, 4, 1}, {1, 7, 3}};
    int[] result = kn.solution(array, commands);
    //[5, 6, 3]
    for(int r : result ) System.out.print(r+ ", ");
  }
  public int[] solution(int[] array, int[][] commands) {
    int[] answer = new int[commands.length];
        for(int i=0; i<commands.length; i++){
            int[] temp = Arrays.copyOfRange(array, commands[i][0]-1, commands[i][1]);
            Arrays.sort(temp);
            answer[i] = temp[commands[i][2]-1];
        }

        return answer;
  }
}
