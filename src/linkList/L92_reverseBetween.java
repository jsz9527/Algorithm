package linkList;

import vo.ListNode;

//反转链表
//给你单链表的头指针 head 和两个整数 left 和 right ，其中 left <= right 。请你反转从位置 left 到位置 right 的链表节点，返回 反转后的链表 。
public class L92_reverseBetween {

    public ListNode reverseBetween(ListNode head, int left, int right) {
        if(left == right){
            return head;
        }
        ListNode preHead = new ListNode();
        preHead.next = head;
        ListNode indexFront = preHead;
        ListNode index = head;
        ListNode preTail = null;
        ListNode betweenHead = null;
        ListNode betweenTail = null;
        ListNode postHead = null;
        boolean isBetween = false;
        int i = 0;
        while (index != null){
            i++;
            if(i == left){
                preTail = indexFront;
                betweenTail = index;

                ListNode temp = index.next;
                index.next = null;

                indexFront = index;
                index = temp;

                isBetween = true;
                continue;
            }
            if(isBetween){
                ListNode temp = index.next;
                index.next = indexFront;

                if(i == right){
                    preTail.next = index;
                    betweenTail.next = temp;

                    isBetween = false;
                }

                indexFront = index;
                index = temp;

                continue;
            }
            indexFront = index;
            index = index.next;
        }

        return preHead.next;
    }

}
