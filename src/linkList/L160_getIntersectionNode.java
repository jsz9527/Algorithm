package linkList;

import vo.ListNode;

public class L160_getIntersectionNode {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA == null || headB == null){
            return null;
        }
        ListNode indexA = headA;
        ListNode indexB = headB;

        //null == null 为true
        while (indexA != indexB){
            indexA = indexA==null?headB:indexA.next;
            indexB = indexB==null?headA:indexB.next;
        }

        return indexA;
    }
}
