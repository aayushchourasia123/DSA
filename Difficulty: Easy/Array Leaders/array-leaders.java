class Solution {
    static ArrayList<Integer> leaders(int arr[]) {
        // code here
        
        //Time Complexity: O(n)
        //Auxiliary Space: O(1)
        
        int max=arr[arr.length-1];
        ArrayList<Integer> ans=new ArrayList<>();
        ans.add(arr[arr.length-1]); // The rightmost element is always a leader
        
        for(int i=arr.length-2;i>=0;i--){
          if(arr[i]>=max){
              max=arr[i];
              ans.add(max);
          }  
        }
         // Reverse to get leaders in original order
        Collections.reverse(ans);
        return ans;
       
    }
}
