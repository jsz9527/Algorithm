package linkList;

import vo.ListNode;

/*
143. 重排链表
给定一个单链表 L 的头节点 head ，单链表 L 表示为：
L0 → L1 → … → Ln - 1 → Ln
请将其重新排列后变为：
L0 → Ln → L1 → Ln - 1 → L2 → Ln - 2 → …
不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。

方法一：遍历一遍，改用数组存储，空间换时间

方法二：找中点（快慢指针 时间复杂度 n/2） + 反转 后半部分链表（L206） + 合并链表（L21）
 */
public class L143_reorderList {
    public void reorderList(ListNode head) {

    }
}
