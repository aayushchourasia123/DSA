class Solution {
    //tc=O(n* 2^n)
    //sc=O(n* 2^n)
    public List<List<String>> partition(String s) {
        List<List<String>> ans=new ArrayList<>();
        List<String> path=new ArrayList<>();

        func(s,0,path,ans);
        return ans;
    }
    
    public boolean isPalindrome(String s,int start,int end){
        while(start<=end){
            if(s.charAt(start++)!=s.charAt(end--)) return false;
        }
        return true;
    }

    public void func(String s,int index,List<String> path,List<List<String>> ans){
        if(index==s.length()){
            ans.add(new ArrayList<>(path)); //storing the copy of path not path because changes during backtrack can change ans
            return;
        }

        for(int i=index;i<s.length();i++){
            
            if(isPalindrome(s,index,i)){
                path.add(s.substring(index,i+1));
                func(s,i+1,path,ans);
                path.remove(path.size()-1);
            }
        }

    }
}