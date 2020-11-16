import java.util.Queue;
import java.util.LinkedList;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {;
        int[] temp = new int[100];
        Queue<Integer> queue = new LinkedList<>();
        for(int i = 0; i < progresses.length; i++) {
            queue.add(progresses[i]);
        }
        
        int progCurNum = 0; //���° �������
        int answerCnt = 0; //answer�� �ε���
        
        while(queue.peek() != null) {
        	int answerNum = 0; //�Ϸ�� ��ɰ���
        	int day = (int)(Math.ceil((float)(100 - queue.peek())/(float)speeds[progCurNum]));

        	while(queue.peek() != null && queue.peek() + day*speeds[progCurNum] >= 100) {
        		queue.remove();
        		progCurNum++;
        		answerNum++;
        	}
        	
            temp[answerCnt++] = answerNum;
        }
        
        int[] answer = new int[answerCnt];
        for(int i = 0; i < answerCnt; i++) {
        	answer[i] = temp[i];
        }
        return answer;
    }
}