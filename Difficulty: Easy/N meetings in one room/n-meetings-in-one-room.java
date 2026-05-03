class Solution {
    // Function to find the maximum number of meetings that can
    // be performed in a meeting room.
    public int maxMeetings(int start[], int end[]) {
        // add your code here
        int count=0;
        int prev=-1;
        int arr[][]=new int[start.length][2];
        
        for(int i=0;i<start.length;i++){
            arr[i][0]=start[i];
            arr[i][1]=end[i];
        }
        
        Arrays.sort(arr,(a,b)->a[1]-b[1]);
        
        for(int i=0;i<start.length;i++){
            if(prev==-1){
                prev=arr[i][1];
                count++;
            }
            else{
                if(prev<arr[i][0]){
                    prev=arr[i][1];
                    count++;
                }
            }
        }
        return count;
    }
}
