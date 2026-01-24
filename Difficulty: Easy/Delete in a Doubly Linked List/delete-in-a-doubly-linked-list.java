/*
Structure of a Doubly LinkList
class Node {
    int data;
    Node next;
    Node prev;

    Node(int val) {
        data = val;
        next = null;
        prev = null;
    }
}
*/
class Solution {
    public Node delPos(Node head, int x) {
        // code here
        Node temp=head;
        if(x==1){
            temp=temp.next;
            temp.prev=null;
            return temp;
        }
        for(int i=1;i<x;i++){
            temp=temp.next;
        }
        if(temp.next==null){
            temp=temp.prev;
            temp.next=null;
            return head;
        }
        
        Node save_next=temp.next;
        temp=temp.prev;
        temp.next=save_next;
        save_next.prev=temp;
        return head;
    }
}