class Solution {
    public static void print_divisors(int n) {
        // code here
        //tc=O(root(n))
        
        //List<Integer> ans =new Array
        int i;
        for(i=1;i*i<=n;i++){ //smallest divisor first
            if(n%i==0){
                System.out.print(i+" ");
                // if(i!=n/i){
                //   System.out.print(n/i+" ");  
                // }
            }
        }
        i-=1;
        //by doing this dont need extra space and sort it to get ans in ascending order
        for(;i>=1;i--){ //largest divisor second 
            if(n%i==0 && i!=n/i){
                System.out.print(n / i+" ");
            }
        }
    }
}
