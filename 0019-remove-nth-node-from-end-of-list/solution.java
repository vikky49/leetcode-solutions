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
        int length = 0;
        ListNode current = head;
        while(current != null) {
            length ++;
            current = current.next;
        }

        //Now that we know the lenght of the list lets find the target index 
        int targetIndex = length - n;

        //Edge case 
        //if the index is 0 we know its the first element so we just pass the second one
        if(targetIndex == 0) {
            return head.next;
        }

        //naviage it to the that pointer 
        current = head;
        for(int i = 0; i < targetIndex -1 ; i++) {
          current = current.next;
        }

        //Now remove the pointer by manipulating it 
        current.next = current.next.next;

        return head;
         
    }
}
