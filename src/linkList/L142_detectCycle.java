package linkList;

import vo.ListNode;

public class L142_detectCycle {
    public ListNode detectCycle(ListNode head) {
        if(head == null || head.next == null || head.next.next == null){
            return null;
        }
        ListNode fast = head.next.next;
        ListNode slow = head.next;
        while (fast.next != null && fast.next.next != null){
            if(slow == fast){
                break;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        if(slow != fast){
            return null;
        }
        ListNode exr = head;
        while (exr != slow){
            slow = slow.next;
            exr = exr.next;
        }
        return exr;
    }
}
