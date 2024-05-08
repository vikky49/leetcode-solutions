/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public void deleteNode(ListNode node) {
        //override the node value with the next node value
        node.val = node.next.val;
        //change the pointers to the next of the next
        node.next = node.next.next;
        
    }
}
