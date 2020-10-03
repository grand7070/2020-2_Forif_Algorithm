//https://programmers.co.kr/learn/courses/30/lessons/42626

import java.util.PriorityQueue;

class Solution {
    public int solution(int[] scoville, int K) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        for(int i = 0; i < scoville.length; i++){
            priorityQueue.add(scoville[i]); //offer?
        }
        int count = 0;
        
        while(true){
            
            int temp = priorityQueue.poll();
            if(priorityQueue.isEmpty()){
                if(temp >= K){
                    return count;
                }
                return -1;
            }
            priorityQueue.add(temp);
            
            if(priorityQueue.peek() < K){
                int first = priorityQueue.poll();
                int second = priorityQueue.poll();
                priorityQueue.add(first+(second*2));
                count++;
                continue;
            }
            break;
        }
        return count;
    }
}