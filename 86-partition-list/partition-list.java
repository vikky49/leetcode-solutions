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
    public ListNode partition(ListNode head, int x) {
        ListNode smallerNodeDummy = new ListNode(0);
        ListNode biggerNodeDummy = new ListNode(0);

        ListNode smallerTail = smallerNodeDummy;
        ListNode bigNodeTail = biggerNodeDummy;

        ListNode current = head;

        while (current != null) {
            if (current.val < x) {
                smallerTail.next = current;
                smallerTail = current;
            } else {
                bigNodeTail.next = current;
                bigNodeTail = current;
            }
            current = current.next;
        }

        //Terminate the list
        bigNodeTail.next = null;
        smallerTail.next = biggerNodeDummy.next;

        return smallerNodeDummy.next;

    }
}