package linkList;

import vo.ListNode;

public class L206_reverseList {
    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode index = head;
        while (index != null) {
            ListNode next = index.next;
            index.next = prev;
            prev = index;
            index = next;
        }
        return prev;
    }

}
