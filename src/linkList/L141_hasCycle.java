package linkList;

import vo.ListNode;

public class L141_hasCycle{
        public boolean hasCycle(ListNode head) {
                if(head==null){
                        return false;
                }
                ListNode quick = head.next;
                ListNode slow = head;
                while (quick != slow && quick!=null && slow!=null){
                        quick=quick.next;
                        if(quick!=null){
                                quick=quick.next;
                        }
                        slow=slow.next;
                }
                if(quick==null){
                        return false;
                }else {
                        return true;
                }
        }
}
