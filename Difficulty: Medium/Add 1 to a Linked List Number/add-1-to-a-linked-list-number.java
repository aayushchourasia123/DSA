/*
class Node{
    int data;
    Node next;

    Node(int x){
        data = x;
        next = null;
    }
}
*/

class Solution {
    //tc=O(n) sc=O(n) recursive stack space
    public int helper(Node head){
        if(head==null) return 1;
        
        int carry=helper(head.next);
        head.data=head.data+carry;
        
        if(head.data<10) return 0;
        head.data=0;
        return 1;
    }
    public Node addOne(Node head) {
        // code here.
        int carry=helper(head);
        if(carry==1){
            Node node=new Node(1);
            node.next=head;
            head=node;
        }
        return head;
    }
}