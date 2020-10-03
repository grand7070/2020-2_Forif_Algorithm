//https://leetcode.com/problems/merge-intervals/

class Solution {
    public int[][] merge(int[][] intervals) {
        int count = intervals.length;
        int[][] arr = new int[count][2];
        int arrNum = 0;
        int[] list = new int[3];
        int listNum = 0;
        
        Arrays.sort(intervals, new Comparator<int[]>(){
            public int compare(int[]t1, int[] t2){
                if(t1[0] == t2[0])
                    return t1[1] - t2[1];
                else
                    return t1[0] - t2[0];
            }
        });
        
        if(count == 1){
            return intervals;
        }
        
        for(int i = 0; i < count; i++){
            for(int j = 0; j < 2; j++){
                if(listNum == 0 || listNum == 1) {
                    list[listNum++] = intervals[i][j];
                    System.out.println(list[0] + " " + list[1]);
                }else{ //listNum = 2
                    if(list[1] < intervals[i][j] && j == 1){
                        list[1] = intervals[i][j];
                        System.out.println(list[0] + " " + list[1]);
                    }
                    else if(list[1] < intervals[i][j] && j == 0){
                        arr[arrNum++] = new int[] {list[0], list[1]};
                        listNum = 0;
                        list[0] = 0;
                        list[1] = 0;
                        list[listNum++] = intervals[i][j];
                        System.out.println(list[0] + " " + list[1]);
                    }
                    else if(list[0] > intervals[i][j]){
                        list[0] = intervals[i][j];
                    }
                    else{
                        
                    }
                }
            }
            if(i == count-1){
                arr[arrNum++] = new int[] {list[0], list[1]};
            }
        }
        
        int[][] newArr = new int[arrNum][2];
        for(int i = 0; i < arrNum; i++){
            newArr[i] = arr[i];
        }
        return newArr;
    }
}