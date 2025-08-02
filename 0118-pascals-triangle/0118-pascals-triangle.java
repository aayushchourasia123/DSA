class Solution {
    //tc=(n^2)
    public List<Integer> ncr(int row){
        ArrayList<Integer> temp=new ArrayList<>();
        temp.add(1);
        int ans=1;
        for(int col=1;col<row;col++){
            ans=ans*(row-col);
            ans=ans/col;
            temp.add(ans);
        }
        return temp;
    }
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ans=new ArrayList<>();
        
        for(int i=1;i<=numRows;i++){
            ans.add(ncr(i));
        }
        return ans;
    }
}