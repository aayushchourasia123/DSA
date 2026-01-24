/*
class Node
{
    int data;
    Node next;
    Node prev;
    Node(int data)
    {
        this.data = data;
        next = prev = null;
    }
}
*/

class Solution {
    Node insertAtPos(Node head, int p, int x) {
        // code here
        Node t=new Node(x);
        Node temp=head;
        if(p==0){
            Node save_next=temp.next;
            save_next.prev=t;
            t.prev=temp;
            temp.next=t;
            t.next=save_next;
            return head;
        }
        
        for(int i=0;i<p;i++){
            temp=temp.next;
        }
        if(temp.next==null){
            temp.next=t;
            t.prev=temp;
            t.next=null;
            return head;
        }
        Node save_next=temp.next;
        save_next.prev=t;
        t.prev=temp;
        temp.next=t;
        t.next=save_next;
        return head;
        
    }
}