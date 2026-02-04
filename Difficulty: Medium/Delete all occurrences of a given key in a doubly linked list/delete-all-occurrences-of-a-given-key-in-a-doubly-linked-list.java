/* Structure of Doubly Linked List
class Node
{
    int data;
    Node next;
    Node prev;
}*/
class Solution {
    static Node deleteAllOccurOfX(Node head, int x) {
        // code here
        Node temp=head;
        while(temp!=null){
            if(temp.data==x){
                if(temp.prev==null){
                    head=temp.next;
                    if(head!=null){
                        head.prev=null;
                    }
                }
                else{
                    temp.prev.next=temp.next;
                    if(temp.next!=null){
                        temp.next.prev=temp.prev;
                    }
                }
            }
            temp=temp.next;
        }
        return head;
    }
}