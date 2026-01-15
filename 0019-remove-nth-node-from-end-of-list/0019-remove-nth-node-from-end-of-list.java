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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        // //tc=O(len)+O(len-n)
        // //sc=O(1)
        // if(head==null || head.next==null) return null;
        // int count=0;
        // ListNode temp=head;
        // while(temp!=null){
        //     count++;
        //     temp=temp.next;
        // }
        // if(n==count){
        //     return head.next;
        // }
        // int idx=count-n;
        // temp=head;
        
        // for(int i=1;i<idx;i++){
        //     temp=temp.next;
        // }
        // temp.next=temp.next.next;

        // return head;

        //tc=O(len) sc=O(1)
        ListNode fast=head;
        for(int i=0;i<n;i++){
            fast=fast.next;
        }
        // if head must be removed
        if (fast == null) {
            return head.next;
        }
        ListNode slow=head;
        while(fast.next!=null){
            slow=slow.next;
            fast=fast.next;
        }
        slow.next=slow.next.next;
        return head;
    }
}