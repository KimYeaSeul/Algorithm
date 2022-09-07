import java.util.*;
class DevelopFunc {
  public static void main(String[] args) {
    DevelopFunc df = new DevelopFunc();
    int[] progresses={93,30,55};
    int[] speeds = {1, 30, 5};
    System.out.println(df.solution(progresses, speeds));
  }
  public int[] solution(int[] progresses, int[] speeds) {
      
    int work = progresses.length;
    
    List<Integer> list = new ArrayList<>();
    
    int[] day = new int[work];
    for(int i=0; i<work; i++){
        day[i] = (int)Math.ceil((double)(100 - progresses[i]) / speeds[i]);
    }
    
    int launchingDay = day[0];
    int num = 1;
    for(int j = 1; j<day.length; j++){
        if(launchingDay >= day[j]){
            num++;
        }else{
            launchingDay= day[j];
            list.add(num);
            num=1;
        }
        if(j == day.length-1) list.add(num);
    }
    
    int[] answer = new int[list.size()];
    for(int k=0; k<list.size(); k++){
        answer[k] = list.get(k);
    }
    return answer;
  }
}