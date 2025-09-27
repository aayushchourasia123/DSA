class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {

        //Building frequency map: O(N log N) (TreeMap inserts)
        //Checking groups: O(N log N) (since we remove each card once, log N for TreeMap ops)
        //\U0001f449 Overall: O(N log N)
        if(hand.length % groupSize!=0) return false;
        
        TreeMap<Integer,Integer> count=new TreeMap<>(); //treemap is ordered whereas hashmap is not
        for(Integer no: hand){
            count.put(no,count.getOrDefault(no,0)+1);
        }

        while(!count.isEmpty()){
            int first=count.firstKey(); //smallest avaliable card
            for(int i=0;i<groupSize;i++){
                int card=first+i;
                if(!count.containsKey(card)) return false;

                count.put(card,count.get(card)-1);
                if(count.get(card)==0){
                    count.remove(card);
                }
            }
        }
        return true;
    }
}