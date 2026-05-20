// User function Template for Java

class Solution {
    static int pageFaults(int N, int C, int pages[]) {
        // code here
        //tc=O(N*C) sc=O(C)
        ArrayList<Integer> memory=new ArrayList<>();
        int fault=0;
        
        for(int i=0;i<N;i++){
            int page=pages[i];
            
            if(memory.contains(page)){//O(c)
                memory.remove(Integer.valueOf(page)); //int->INTEGER
                memory.add(page);
            }
            else{
                fault++;
                if(memory.size()==C) memory.remove(0);//O(c)
                memory.add(page);
            }
        }
        return fault;
    }
}