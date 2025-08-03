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
    public void reorderList(ListNode head) {
        List<ListNode> aList = new ArrayList<>();
        ListNode current = head;

        while(current != null) {
            aList.add(current);
            current = current.next;
        }

        int start = 0;
        int end = aList.size() - 1;

        while (start < end) {
            aList.get(start).next = aList.get(end);
            start ++;

            //break the loop if we are in the middle
            if(start == end) {
                break;
            }

            aList.get(end).next = aList.get(start);
            end --;
        }
        //The left node is the middle node and points to the last node possible. so we need to end the list .
        aList.get(start).next = null;
        
    }
}
