/*
class Node{
    int data;
    Node next, prev;
    Node(int x){
        this.data = x;
        this.next = null;
        this.prev = null;
    }
}
*/
class Solution {
    Node removeDuplicates(Node head) {
        // Code Here.
        Node temp=head.next;
        //Node initial=head;
        while(temp!=null){
            if(temp.prev != null&&temp.data==temp.prev.data){
                Node initial=temp.prev;
                
                while(temp != null && temp.data==initial.data){
                    temp=temp.next;
                }
                if(temp==null){
                    initial.next=null;
                }
                else{
                initial.next=temp;
                temp.prev=initial;
                } 
            }
            else temp=temp.next;
        }
        return head;
    }
}
