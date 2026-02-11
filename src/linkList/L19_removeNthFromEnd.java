package linkList;

import vo.ListNode;

public class L19_removeNthFromEnd {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode root = new ListNode();
        root.next = head;
        ListNode index = head;
        ListNode preTheNth = root;
        ListNode theNth = head;
        while (index.next !=null){
            if(n == 1){
                preTheNth = preTheNth.next;
                theNth = theNth.next;
            }else {
                n--;
            }
            index = index.next;
        }
        preTheNth.next = theNth.next;
        return root.next;
    }
}
