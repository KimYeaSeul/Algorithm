import java.util.*;
class CrainGameWithKakao {
    public static void main(String[] args){
        CrainGameWithKakao cgwk = new CrainGameWithKakao();
        int[][] board = {{0,0,0,0,0},{0,0,1,0,3},{0,2,5,0,1},{4,2,4,4,2},{3,5,1,3,1}};
        int[] moves = {1,5,3,5,1,2,1,4};
        // 4
        System.out.println(cgwk.solution(board, moves));
    }

    public int solution(int[][] board, int[] moves) {
        int answer = 0;
        int boardLength = board.length;
        Stack[] ground = new Stack[boardLength];
        
        for(int l=0; l<boardLength; l++){
            ground[l] = new Stack<Integer>();
        }
        
        for(int i = board.length-1; i>=0;i--){
            for(int j = 0; j<board[0].length; j++)
                if(board[i][j] != 0)
                    ground[j].push(board[i][j]);
        }

        Stack<Integer> q = new Stack<>();
        int now=0;
        for(int m : moves){
            if(ground[m-1].empty()) continue;
            now = (int) ground[m-1].pop();
            if(q.empty()) { 
                q.push(now); 
            }else{
                if(now == q.peek()) {
                    q.pop();
                    answer = answer+2;
                }else{
                    q.push(now);
                }
            }
        }
        return answer;
    }
}