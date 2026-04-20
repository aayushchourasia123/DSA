
class Solution {
    class Items{
        int val,weight;
        Items(int v,int w){
            val=v;
            weight=w;
        }
    }
    public double fractionalKnapsack(int[] val, int[] wt, int capacity) {
        // code here
        Items t1[]=new Items[val.length];
        for(int i=0;i<val.length;i++){
            t1[i]=new Items(val[i],wt[i]);
        }
        Arrays.sort(t1,(a,b)->
            Double.compare((double)b.val/b.weight,(double)a.val/a.weight)
        );
        double totalVal=0.0;
        for(Items t:t1){
            if(capacity>=t.weight){
                totalVal+=t.val;
                capacity-=t.weight;
            }
            else{
                totalVal+=((double)t.val/t.weight)*capacity;
                break;
            }
        }
        return totalVal;
    }
}