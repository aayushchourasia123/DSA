class Solution {
    public int candy(int[] ratings) {
        //tc=O(3n) sc=O(n)
        int arr[]=new int[ratings.length];
        Arrays.fill(arr,1);
        //left to right
        for(int i=1;i<ratings.length;i++){
            if(ratings[i]>ratings[i-1]){
                arr[i]=arr[i-1]+1;
            }
        }
        //right to left
        for(int i=ratings.length-2;i>=0;i--){
            if(ratings[i]>ratings[i+1]){
                arr[i]=Math.max(arr[i+1]+1,arr[i]);
                
            }
        }
        int count = 0;
        for (int x : arr) {
            count += x;
        }

        return count;
    }
}