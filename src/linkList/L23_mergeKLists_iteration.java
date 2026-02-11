package linkList;

import vo.ListNode;

public class L23_mergeKLists_iteration {

    public ListNode mergeKLists_recursion(ListNode[] lists) {
        if(lists == null || lists.length == 0){
            return null;
        }

        int len = lists.length;
        for(int step=1; step < len; step=step*2){
            for(int i=0; i<len-step; i= i + step*2 ){
                lists[i] = mergeTwoLists(lists[i], lists[i + step]);
            }
        }

        return lists[0];
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
