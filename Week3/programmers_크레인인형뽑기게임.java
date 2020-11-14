//https://programmers.co.kr/learn/courses/30/lessons/64061?language=java
	
import java.util.Stack;

public class Solution {
    public int solution(int[][] board, int[] moves) {
        int answer = 0;
        int n = board[0].length;
        int count = moves.length;
        Stack<Integer> st = new Stack<Integer>();
        
        for(int i = 0; i < count; i++) {
            int j = 0;
            while(j < n-1 && board[j][moves[i]-1] == 0) {
                j++;
            }
            if(board[j][moves[i]-1] == 0) continue;
            
            if(!st.empty()) {
                if(st.peek() == board[j][moves[i]-1]) {
                    st.pop();
                    board[j][moves[i]-1] = 0;
                    answer += 2;
                    continue;
                }
            }
            st.push(board[j][moves[i]-1]);
            board[j][moves[i]-1] = 0;
        }
        return answer;
    }
}