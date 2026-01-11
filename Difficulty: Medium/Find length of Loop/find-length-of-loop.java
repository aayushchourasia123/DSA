/*
class Node {
    int data;
    Node next;

    Node(int x) {
        data = x;
        next = null;
    }
}
*/

class Solution {
    // public int Count(Node slow){
    //     int count=1;
    //     Node temp=slow.next;
    //     while(slow!=temp){
    //         count++;
    //         temp=temp.next;
    //     }
    //     return count;
    // }
    public int lengthOfLoop(Node head) {
        // code here
        //tc=O(n)  sc=O(1)
        Node slow=head;
        Node fast=head;
        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
            
            if(slow==fast){
                int count=1;
                Node temp=slow.next;
                while(slow!=temp){
                    count++;
                    temp=temp.next;
                }
                return count;
            }
                
        }
        return 0;
    }
}
