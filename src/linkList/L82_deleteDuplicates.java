package linkList;

import vo.ListNode;

import java.util.HashMap;
import java.util.HashSet;

public class L82_deleteDuplicates {
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null){
            return null;
        }

        ListNode root = new ListNode();
        root.next = head;

        ListNode preIndex = root;
        ListNode index = head;

        int compare = head.val;
        boolean isRemove = false;
        while (index.next != null){
            if(compare == index.next.val ){
                index = index.next;
                isRemove = true;
                if(index.next == null){
                    preIndex.next = null;
                }
            }else {
                if(isRemove){
                    index = index.next;
                    preIndex.next = index;
                    isRemove = false;
                }else {
                    preIndex = index;
                    index = index.next;
                }
                compare = index.val;
            }
        }
        return root.next;
    }

    public ListNode deleteDuplicates1(ListNode head) {
        ListNode index = head;
        int compare = head.val;
        while (index.next != null){
            if(compare == index.next.val ){
                ListNode temp = index.next.next;
                index.next = temp;
            }else {
                index = index.next;
                compare = index.val;
            }
        }
        return head;
    }
}
