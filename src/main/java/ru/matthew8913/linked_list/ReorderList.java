package ru.matthew8913.linked_list;

public class ReorderList {

    public void reorderList(ListNode head) {
        ListNode middle = findMiddle(head);
        ListNode head2 = reverse(middle.next);
        middle.next = null;

        mergeAlternating(head, head2);
    }

    public ListNode reverse(ListNode head) {
        ListNode cur = head;
        ListNode prev = null;

        while(cur != null){
            ListNode tmp = cur.next;
            cur.next = prev;
            prev = cur;
            cur = tmp;
        }
        return prev;
    }

    public ListNode findMiddle(ListNode head){
        ListNode slow = head;
        ListNode fast = head;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public void mergeAlternating(ListNode l1, ListNode l2){
        ListNode cur1 = l1;
        ListNode cur2 = l2;

        while(cur2!=null){
            ListNode tmp1 = cur1.next;
            ListNode tmp2 = cur2.next;
            cur1.next = cur2;
            cur2.next = tmp1;
            cur1 = tmp1;
            cur2 = tmp2;
        }
    }
}
