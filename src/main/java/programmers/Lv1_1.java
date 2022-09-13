package programmers;

import java.util.*;

public class Lv1_1 {
    // https://school.programmers.co.kr/learn/courses/30/lessons/12937
    public String _짝수와_홀수(int num){
        return num%2==0? "Even" : "Odd";
    }

    // https://school.programmers.co.kr/learn/courses/30/lessons/12916
    public boolean _문자열_내_p와_y의_개수(String s){
        String lowS = s.toLowerCase();
//        int result = 0;
//        if(!lowS.contains("p")&&!lowS.contains("y")){
//            return true;
//        }
//        for(int i=0; i<s.length();i++){
//            if(lowS.charAt(i) == 'p'){
//                result++;
//            }else if(lowS.charAt(i) == 'y'){
//                result--;
//            }
//        }
//
//        return result == 0;
        return lowS.chars().filter(e -> 'p'==e).count() == lowS.chars().filter(e -> 'y'==e).count();
    }
}
