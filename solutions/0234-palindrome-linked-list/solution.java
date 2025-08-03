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
    public boolean isPalindrome(ListNode head) {
        if(head == null || head.next == null) {
            return true;
        }
        ListNode secondHalf = secondHalfListNode(head);
        ListNode reversedSecondHalf = reversed(secondHalf);

        //compare the first half and the second secondHalf
        ListNode p1 = head;
        ListNode p2 = reversedSecondHalf;

        boolean result = true;
        while(result && p2 != null) {
            if(p1.val != p2.val) {
                result = false;
            }
            p1 = p1.next;
            p2 = p2.next;
        }

        return result;
        
    }

    private ListNode secondHalfListNode(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;

        while(fast.next != null && fast.next.next !=null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        return slow.next;
    }

    private ListNode reversed(ListNode head) {
        ListNode current = head;
        ListNode prev = null;
        ListNode next = null;

        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }

        return prev;
    }
}
