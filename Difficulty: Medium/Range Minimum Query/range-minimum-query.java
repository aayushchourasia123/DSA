class Solution {
    int SegTree[];
        int n;
        public void builtTree(int arr[]){
            built(0,0,n-1,arr);
        }

        private void built(int i,int l,int r,int arr[]){
            if(l==r){
                SegTree[i]=arr[l];
                return;
            }
            int mid=(l+r)/2;
            built(2*i+1,l,mid,arr);
            built(2*i+2,mid+1,r,arr);
            SegTree[i]=Math.min(SegTree[2*i+1],SegTree[2*i+2]);
        }

        public int query(int st,int ed){
            return query(st,ed,0,0,n-1);
        }

        private int query(int st,int ed,int i,int l,int r){
            if(l>ed || r<st){
                return Integer.MAX_VALUE;
            }
            if(l>=st && r<=ed){
                return SegTree[i];
            }
            int mid=(l+r)/2;
            return Math.min(query(st,ed,2*i+1,l,mid)
                    ,query(st,ed,2*i+2,mid+1,r));
        }
        
    public ArrayList<Integer> rangeMinQuery(int[] arr, int[][] queries) {
        // code here
        n=arr.length;
        SegTree=new int[4*n];
        builtTree(arr);
        ArrayList<Integer> ans=new ArrayList<>();

        for(int q[]:queries){
            int l=q[0];
            int r=q[1];
            ans.add(query(l,r));
        }
        return ans;
    }
}