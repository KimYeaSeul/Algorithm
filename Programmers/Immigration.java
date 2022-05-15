import java.util.*;
class Immigration {
  public long solution(int n, int[] times) {
      long answer = n * (long) times[times.length-1];
      Arrays.sort(times);
      
      long start =1; 
      long end = answer; 
      long mid = 0;
      
      while(start <= end ){
          long p = 0;
          mid = (start + end)/2;
          for(int time : times) {
              p += mid/time; 
          }
          if(p>=n) {
              answer = Math.min(answer,mid);
              end = mid-1;
          }else{
              start = mid+1;
          }
      }
      
      return (long)answer;
  }
}