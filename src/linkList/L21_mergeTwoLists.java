package linkList;

import vo.ListNode;

public class L21_mergeTwoLists {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode result = new ListNode(-1);
        ListNode index = result;
        while (list1 != null || list2 != null) {
            if (list1 != null && list2 != null) {
                if (list1.val < list2.val) {
                    index.next = list1;
                    list1 = list1.next;
                } else {
                    index.next = list2;
                    list2 = list2.next;
                }
            } else {
                if (list1 == null) {
                    index.next = list2;
                    list2 = list2.next;
                } else {
                    index.next = list1;
                    list1 = list1.next;
                }
            }
            index = index.next;
        }
        return result.next;
    }
}
