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
    public ListNode reverseKGroup(ListNode head, int k) {

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prevGroupEnd = dummy;

        while (true) {
            ListNode kthNode = prevGroupEnd;
            //check the kth group
            for (int i = 0; i < k; i++) {
                kthNode = kthNode.next;

                if (kthNode == null) {
                    return dummy.next;
                }
            }

            //Save the nextGroupStart node
            ListNode nextGroupStart = kthNode.next;

            //Reverse the current group of k nodes 
            ListNode prev = nextGroupStart;
            ListNode current = prevGroupEnd.next;

            for (int i = 0; i < k; i++) {
                ListNode next = current.next;
                current.next = prev;
                prev = current;
                current = next;
            }

            //connect the reversed group back to the main List
            ListNode groupStart = prevGroupEnd.next;
            prevGroupEnd.next = kthNode;
            prevGroupEnd = groupStart;

        }

    }
}