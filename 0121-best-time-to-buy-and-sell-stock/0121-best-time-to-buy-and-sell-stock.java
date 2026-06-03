class Solution {
    public int maxProfit(int[] prices) {
        //tc=O(n) sc=O(1)
        int mini=prices[0],profit=0;
        for(int i=1;i<prices.length;i++){
            int cost=prices[i]-mini;
            profit=Math.max(cost,profit);
            mini=Math.min(prices[i],mini);
        }
        return profit;
    }
}