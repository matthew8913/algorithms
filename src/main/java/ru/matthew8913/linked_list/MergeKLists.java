package ru.matthew8913.linked_list;

public class MergeKLists {
    public ListNode mergeKLists(ListNode[] lists) {
        for(int i = 1; i< lists.length; i++){
            lists[i] = merge(lists[i-1], lists[i]);
        }

        return lists[lists.length - 1];
    }

    public ListNode merge(ListNode l1, ListNode l2){
        ListNode dummy = new ListNode();
        dummy.next = l1;

        ListNode prev = dummy;
        while(l1 != null && l2!=null){
            if(l2.val < l1.val){
               ListNode t2 = l2.next;
               prev.next = l2;
               l2.next = l1;

               prev = l2;
               l2 = t2;
            }else{
                prev = l1;
                l1 = l1.next;
            }
        }

        if(l2!=null){
            prev.next = l2;
        }
        return dummy.next;
    }
}
