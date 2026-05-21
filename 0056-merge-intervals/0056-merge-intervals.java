class Solution {
    public int[][] merge(int[][] intervals) {
        //tc=O(n log n)+O(n)
        Arrays.sort(intervals,(a,b)->a[0]-b[0]);
        ArrayList<int[]> ans=new ArrayList<>();
        int newInterval[]=intervals[0];
        ans.add(newInterval);
        int n=intervals.length;
        
        for(int interval[]:intervals){
            if(interval[0]<=newInterval[1]){
                newInterval[1]=Math.max(newInterval[1],interval[1]);
            }
            else{
                newInterval=interval;
                ans.add(newInterval);
            }
        }
        return ans.toArray(new int[ans.size()][]);
    }
}