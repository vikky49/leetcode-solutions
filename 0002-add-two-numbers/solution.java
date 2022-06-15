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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        
        ListNode result = new ListNode(0);
        ListNode p  = l1;
        ListNode q =  l2; 
        ListNode current = result;
        int carry = 0;
        
       while (p != null || q != null ) {
           
           int val1 = (p != null) ? p.val : 0;
           int val2 = (q != null) ? q.val : 0;
           
           int sum = carry + val1 + val2;
           carry = sum / 10;
           
           current.next = new ListNode(sum % 10);
           current = current.next;
           
           if(p != null) p = p.next;
           if(q != null) q = q.next;
                                
       }
        
        if(carry > 0) {
            current.next = new ListNode(carry);
        }
        
        return result.next;
        
    }
}
