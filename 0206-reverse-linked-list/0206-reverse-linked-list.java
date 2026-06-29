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
    public ListNode reverseList(ListNode head) {
    //     //tc=O(n)
    //     //sc=O(n) recursive stack space
    if(head==null || head.next==null) return head;
    ListNode newHead=reverseList(head.next);
    ListNode front=head.next;
    front.next=head;
    head.next=null;
    return newHead;

    // //tc=O(n) sc=O(1)
    // ListNode curr=head;
    // ListNode prev=null;
    // while(curr!=null){
    //     ListNode temp=curr.next;
    //     curr.next=prev;
    //     prev=curr;
    //     curr=temp;
    // }
    // return prev;
      
    }
}