class Solution {
    public int countPrimes(int n) {
        //tc=O(n)+O(n log log n)+O(n)
        if(n<=1) return 0;
        int prime[]=new int[n+1];
        Arrays.fill(prime,1);//O(n)
        for(int i=2;i*i<=n;i++){//O(n log log n)
            if(prime[i]==1){
                for(int j=i*i;j<=n;j+=i){
                    prime[j]=0;
                }
            }
        }
        int count=0; 
        for(int i=2;i<n;i++){//O(n)
            if(prime[i]==1) count++;
        }
        return count;
    }
}