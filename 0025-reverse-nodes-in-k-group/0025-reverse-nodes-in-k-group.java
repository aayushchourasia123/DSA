/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    //tc=O(2n) sc=O(1)
    public ListNode findKthNode(ListNode head,int k){
        ListNode temp=head;
        k--; // because head itself is 1st node
        while(temp!=null && k>0){
            temp=temp.next;
            k--;
        }
        return temp;
    }
    public void reverse(ListNode head){
        ListNode prev=null;
        ListNode curr=head;
        while(curr!=null){
            ListNode save_next=curr.next;
            curr.next=prev;
            prev=curr;
            curr=save_next;
        }
    }
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode temp=head;
        ListNode nextNode,prevNode=null;
        while(temp!=null){
            ListNode kthNode=findKthNode(temp,k);
            if(kthNode==null){
                if(prevNode!=null){
                    prevNode.next=temp;
                }
                break;
            }
            nextNode=kthNode.next;
            kthNode.next=null;
            reverse(temp);
            if(temp==head){
                head=kthNode;
            }
            else{
                prevNode.next=kthNode;
            }
            prevNode=temp;
            temp=nextNode;
        }
        return head;
    }
}