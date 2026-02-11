package linkList;

import vo.ListNode;

import java.util.PriorityQueue;

public class L23_mergeKLists_priorityQueue {

    PriorityQueue<ListNode> pq = new PriorityQueue<>(((o1, o2) -> {return  o1.val-o2.val;}));

    public ListNode mergeKLists_priorityQueue(ListNode[] lists) {
        for(ListNode node:lists){
            if(node!=null){
                pq.offer(node);
            }
        }
        ListNode dummy = new ListNode();
        ListNode cur = dummy;
        while(!pq.isEmpty()){
            ListNode s = pq.poll();
            cur.next = s;
            cur=cur.next;
            s = s.next;
            if(s!=null){
                pq.offer(s);
            }
        }
        return dummy.next;
    }

}
