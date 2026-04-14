package ru.matthew8913.linked_list;

public class ReverseList2 {

    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (head == null || left == right) return head;

        ListNode dummy = new ListNode(0);
        dummy.next = head;

        // 1. Находим узел ПЕРЕД зоной реверса
        ListNode nodeBefore = dummy;
        for (int i = 1; i < left; i++) {
            nodeBefore = nodeBefore.next;
        }

        // 2. Стандартный реверс внутри границ
        ListNode curr = nodeBefore.next; // Это станет хвостом после реверса
        ListNode prev = null;
        for (int i = 0; i < (right - left + 1); i++) {
            ListNode nextTemp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextTemp;
        }

        // 3. Переподключаем границы
        // nodeBefore.next всё еще указывает на бывшее начало (теперь хвост)
        // prev теперь указывает на новое начало участка (бывшее право)
        // curr теперь указывает на узел сразу после участка

        ListNode segmentTail = nodeBefore.next;
        ListNode segmentHead = prev;
        ListNode nodeAfter = curr;

        nodeBefore.next = segmentHead;
        segmentTail.next = nodeAfter;

        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1,
                new ListNode(2,
                        new ListNode(3,
                                new ListNode(4,
                                        new ListNode(5)))));

        ReverseList2 sol = new ReverseList2();
        ListNode result = sol.reverseBetween(head, 2, 4);
        printList(result);
    }

    private static void printList(ListNode node) {
        while (node != null) {
            System.out.print(node.val + (node.next != null ? " -> " : ""));
            node = node.next;
        }
        System.out.println();
    }
}