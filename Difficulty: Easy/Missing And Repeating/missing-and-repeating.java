class Solution {
    ArrayList<Integer> findTwoElement(int arr[]) {
        // code here
        //tc=O(n) sc=O(1)
        int n=arr.length;
        long sn=(long)n*(n+1)/2;
        long s2n=(long)n*(n+1)*(2*n +1)/6;
        long s2=0;
        long s=0;
        
        for(int i=0;i<n;i++){
            s+=arr[i];
            s2+=(long)arr[i]*arr[i];
        }
        long val1=s-sn;   //x-y
        long val2=s2-s2n; //x^2 -y^2
        val2=val2/val1;   //x+y
        int x=(int)(val1+val2)/2; //repeating
        int y=(int)val2-x;        //missing
        ArrayList<Integer> ans=new ArrayList<>();
        ans.add(x);
        ans.add(y);
        return ans;
    }
}
