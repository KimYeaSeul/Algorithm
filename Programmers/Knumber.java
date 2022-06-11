import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Knumber {
  public int[] solution(int[] array, int[][] commands) {
    int[] answer = new int[commands.length];
    List<Integer> list = new ArrayList<>();

    for(int i=0; i < commands.length; i++){
        int start =commands[i][0]-1;
        int end = commands[i][1];
        for(int j=start; j<end; j++){
            list.add(array[j]);
        }
        list.sort(Comparator.naturalOrder());
        answer[i] = list.get(commands[i][2]-1);
        list.clear();
    }        
    return answer;
  }
}
