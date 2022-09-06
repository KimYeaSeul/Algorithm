public class Square {
  public static void main(String[] args){
    Square s = new Square();
    int w = 8;
    int h = 12;
    // 80
    System.out.println(s.solution(w, h));
  }

  public long solution(int w, int h) {    
    long width = Long.valueOf(w);
    long height = Long.valueOf(h);
    
    long big = Math.max(width,height);
    long small = Math.min(width,height);
        
    // 최대공약수 구하기 - 1 
    // long gcb = 0;
    // for(long i=1; i<= small ; i++){
    //   if(width % i == 0 && height % i == 0){
    //     gcb = i;
    //   }
    // }

    // 최대공약수 구하기 - 2
    while ( small != 0 ) {
      long nmg = big % small ;
      big = small;
      small = nmg;
    }
    
    // 공식 : 전체 사각형 갯수 - ((높이+길이)-최대공약수))
    return (width*height) - ((width+height)-big);
  }
}
