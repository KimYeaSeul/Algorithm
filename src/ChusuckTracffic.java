import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
// 추석트래픽
public class ChusuckTracffic{
  public static void main(String[] args) throws ParseException {
  }
  public int solution(String[] lines){
    int answer = 0;
    
    List<Integer> starts = new ArrayList<>();
    List<Integer> startTimes = new ArrayList<>();
    List<Integer> endTimes = new ArrayList<>();
    // SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.S");
    
    for(int i=0; i<lines.length; i++){
        String[] date = lines[i].split(" ");
        String time = date[1];
        int n = (int) (Double.parseDouble(date[2].replace("s","")) * 1000);
        int t = parseTimeToSeconds(time);
        startTimes.add(t-n+1); // 왜 더 하죠 ?!
        endTimes.add(t);
    }
    starts.addAll(startTimes);
    starts.addAll(endTimes);
    
    for(int i=0; i<starts.size(); i++){
        int count = 0;
        int start = starts.get(i);
        int end = start + 1000;
        for(int j=0; j<startTimes.size(); j++){
            boolean condition1 = start <= startTimes.get(j) && startTimes.get(j) < end;
            boolean condition2 = start <= endTimes.get(j) && endTimes.get(j) < end;
            boolean condition3 = start >= startTimes.get(j) && endTimes.get(j) >= end;
            if(condition1 || condition2 || condition3){
                count++;
            }
        }
        
        answer = Math.max(count, answer);
    }
    return answer;
}
public int parseTimeToSeconds(String str){
    String[] slices = str.split(":");
    int h = Integer.parseInt(slices[0])*60*60*1000;
    int m = Integer.parseInt(slices[1])*60*1000;
    int s = (int) (Double.parseDouble(slices[2])*1000);
    return h+m+s;
}
}