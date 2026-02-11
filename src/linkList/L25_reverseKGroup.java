package linkList;

import vo.ListNode;

//25. K 个一组翻转链表
//206. 反转链表
public class L25_reverseKGroup {

    public static void main(String[] args) {
        ListNode s1 = new ListNode();
        s1.val = 1;
        ListNode s2 = new ListNode();
        s2.val = 2;
        ListNode s3 = new ListNode();
        s3.val = 3;
        ListNode s4 = new ListNode();
        s4.val = 4;
        ListNode s5 = new ListNode();
        s5.val = 5;

        s1.next=s2;
        s2.next=s3;
        s3.next=s4;
        s4.next=s5;

        s1 = new L25_reverseKGroup().reverseKGroup(s1,2);
        System.out.println(s1);

    }

    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode a = new ListNode();
        ListNode b, c,h;
        int i = 0;
        a.next = head;
        h = a;
        b = head;
        c = head;
        while (b != null ){
            i++;
            if( i== k ){
                ListNode d =  b;
                b = b.next;
                ListNode e =  c;
                c = b;

                ListNode t = e;
                ListNode e1 = e;
                ListNode h1 = new ListNode();
                int j = 0;
                do{
                    j++;
                    ListNode tmp = t.next;
                    t.next = h1;
                    h1 = t;
                    t =  tmp;

                }while (j<k);


                h.next = d;
                h = e;
                e.next = c;
                i = 0;
            }else {
                b = b.next;
            }
        }
        return a.next;
    }

}
