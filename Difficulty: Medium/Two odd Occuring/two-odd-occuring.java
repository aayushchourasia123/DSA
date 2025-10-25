class Solution {
    ArrayList<Integer> twoOddNum(int[] arr) {
        // code here
        int xor=0;
        for(int i=0;i<arr.length;i++){
            xor^=arr[i];
        }
        int rightmost=(xor&(xor-1))^xor;
        int b1=0,b2=0;
        for(int i=0;i<arr.length;i++){
            if((arr[i]&rightmost)!=0){
                b1^=arr[i];
            }
            else b2^=arr[i];
        }
        ArrayList<Integer> ans=new ArrayList<>();
        if(b1>b2){
            ans.add(b1);
            ans.add(b2);
        }
        else{
            ans.add(b2);
            ans.add(b1);
        }
        return ans;
    }
}
