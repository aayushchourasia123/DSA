class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        //tc=O(n*k) //sc=O(n-k+1)
        // List<Integer> l=new ArrayList<>();
        // int n=nums.length;
        // for(int i=0;i<=n-k;i++){
        //     int max=Integer.MIN_VALUE;
        //     for(int j=i;j<i+k;j++){
        //         max=Math.max(nums[j],max);
        //     }
        //     l.add(max);
        // }
        // int ans[]=new int[l.size()];
        // for(int i=0;i<l.size();i++){
        //     ans[i]=l.get(i);
        // }
        // return ans;

        //tc=O(2n) sc=O(k)+O(n-k)
        Deque<Integer> dq=new ArrayDeque<>();
        int n=nums.length;
        int ans[]=new int[n-k+1];
        int idx=0;

        for(int i=0;i<n;i++){
            if(!dq.isEmpty() && dq.peekFirst()<=i-k){
                dq.pollFirst();
            }
            while(!dq.isEmpty()&&nums[dq.peekLast()]<=nums[i]){
                dq.pollLast();
            }
            dq.offerLast(i);
            if(i>=k-1) ans[idx++]=nums[dq.peekFirst()];
        }
        return ans;
    }
}