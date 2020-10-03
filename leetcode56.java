//https://leetcode.com/problems/merge-intervals/

class Solution {
    public int[][] merge(int[][] intervals) {
        int count = intervals.length; //들어온 인자수
        int[][] tempArr = new int[count][2];
        int tempArrNum = 0;
          
        Arrays.sort(intervals, new Comparator<int[]>(){
            public int compare(int[]t1, int[] t2){
                if(t1[0] == t2[0])
                    return t1[1] - t2[1];
                else
                    return t1[0] - t2[0];
            }
        });
        
        
        for(int i = 0; i < count-1; i++){
            if(intervals[i][1] >= intervals[i+1][0]){
                intervals[i+1][0] = intervals[i][0];
                if(intervals[i][1] >= intervals[i+1][1]){
                    intervals[i+1][1] = intervals[i][1];
                }
            }
            else{
                 tempArr[tempArrNum][0] = intervals[i][0];
                tempArr[tempArrNum++][1] = intervals[i][1];
            }
            
            if(i == count-2){
                tempArr[tempArrNum][0] = intervals[i+1][0];
                tempArr[tempArrNum++][1] = intervals[i+1][1];
            }
        }
        
        if(count == 1){
            tempArr[tempArrNum][0] = intervals[0][0];
            tempArr[tempArrNum++][1] = intervals[0][1];
        }
        
        int [][] returnArr = new int [tempArrNum][2];
        for(int i = 0; i < tempArrNum; i++){
            returnArr[i] = tempArr[i];
        }
        
        return returnArr;
    }
}