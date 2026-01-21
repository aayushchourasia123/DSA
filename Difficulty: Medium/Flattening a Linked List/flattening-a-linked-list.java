/*
class Node {
    int data;
    Node next;
    Node bottom;

    Node(int x) {
        data = x;
        next = null;
        bottom = null;
    }
}
*/
class Solution {
    public Node flatten(Node root) {
        // code here
        //tc=O(n*mlogn*m)+O(2*n*m) sc=O(n)
        // List<Integer> l1=new ArrayList<>();
        // Node temp=root;
        // while(temp!=null){
            
        //     Node t2=temp;
            
        //     while(t2!=null){
        //         l1.add(t2.data);
        //         t2=t2.bottom;
        //     }
        //     temp=temp.next;
        // }
        // Collections.sort(l1);
        
        // Node ans=new Node(l1.get(0));
        // Node curr = ans;

        // for (int i = 1; i < l1.size(); i++) {
        //     curr.bottom = new Node(l1.get(i));
        //     curr = curr.bottom;
        // }
        // return ans;
        
        //tc=O(2*n*m) sc=O(n) recursive stack space
        if(root==null || root.next==null) return root;
        
        Node merge=flatten(root.next);
        return merge2list(root,merge);
    }
    public Node merge2list(Node l1,Node l2){
        Node dummy=new Node(-1);
        Node res=dummy;
        while(l1!=null && l2!=null){
            if(l1.data<l2.data){
                res.bottom=l1;
                res=l1;
                l1=l1.bottom;
            }
            else{
                res.bottom=l2;
                res=l2;
                l2=l2.bottom;
            }
            res.next=null;
        }
        if(l1!=null) res.bottom=l1;
        else res.bottom=l2;
        
        return dummy.bottom;
    }
}