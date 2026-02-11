package linkList;

import vo.ListNode;

public class L23_mergeKLists_recursion {
    public ListNode mergeKLists_recursion(ListNode[] lists) {
        if(lists == null || lists.length == 0){
            return null;
        }
        return mergeKLists_recursion(lists, 0, lists.length-1);
    }

    public ListNode mergeKLists_recursion(ListNode[] lists, int l, int r) {
        if(l==r){
            return mergeTwoLists(lists[l], null);
        }
        int mid = (l+r)/2;
        return mergeTwoLists(mergeKLists_recursion(lists, l, mid), mergeKLists_recursion(lists, mid+1, r));
    }

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
