import java.util.*;
// 다단계
public class Dadangae {
  public static void main(String[] args) {
    Dadangae dd = new Dadangae();
    String[] enroll = {};
    String[] referral = {};
    String[] seller = {};
    int[] amount = {};
    int[] result = dd.solution(enroll, referral, seller, amount);
    for(int i : result){ System.out.println(i);}
  }
  public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
    int[] answer= new int[enroll.length];
    Map<String, String> enre = new HashMap<>();
    Map<String, Integer> memberIndex = new HashMap<>();

    for(int i =0; i<enroll.length; i++){
      enre.put(enroll[i], referral[i]); // 등록자와 추천자
        memberIndex.put(enroll[i], i); // 등록자와 등록자의 순서 enroll 순서에 맞게 return 하기 위하여
    }

    for(int j =0; j<seller.length; j++){
      String now = seller[j];
      int eran =  amount[j] * 100; // 셀러의 수입
      while(!now.equals("-")){
        int recommenderBenefit = eran/10; // 추천자의 수익
        int nowProfit = eran - recommenderBenefit; // 판매자의 수익

        answer[memberIndex.get(now)] += nowProfit;

        now = enre.get(now); // 부모
        eran = recommenderBenefit;

        if(eran < 1){ break;}
      }
    }
    return answer;
  }

 
  public class Atomy{
      String enroller= "";
      // List<Atomy> referer = new LinkedList<>();
      Atomy referer;
      int money=0;
      Atomy(String enroll){
          this.enroller = enroll;
      }        

      public void recommender(Atomy person){
        // referer.add(new Atomy(person));
        this.referer = person;
      }

      public String getRecommender(){
        return this.referer.enroller;
      }

      public void earn(int m){
        this.money += m;
      }
  }
}
