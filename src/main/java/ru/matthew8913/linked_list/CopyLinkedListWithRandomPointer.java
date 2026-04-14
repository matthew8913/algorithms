package ru.matthew8913.linked_list;

import java.util.HashMap;
import java.util.Map;

public class CopyLinkedListWithRandomPointer {
    public Node copyRandomList(Node head) {
        if(head == null) return null;

        Map<Node,Node> map = new HashMap<>();
        Node p1 = head;
        Node res = p1;
        while(p1!=null) {
            map.put(p1, new Node(p1.val));
            p1 = p1.next;
        }

        Node p2 = head;
        while(p2!=null){
            map.get(p2).random = map.get(p2.random);
            map.get(p2).next = map.get(p2.next);
            p2 = p2.next;
        }

        return map.get(res);
    }

    private static class Node{
            int val;
            Node next;
            Node random;

            public Node(int val) {
                this.val = val;
                this.next = null;
                this.random = null;
            }
    }

    public static void main(String[] args) {
        CopyLinkedListWithRandomPointer solution = new CopyLinkedListWithRandomPointer();

        // Создаём список: [[7,null],[13,0],[11,4],[10,2],[1,0]]
        Node node1 = new Node(7);
        Node node2 = new Node(13);
        Node node3 = new Node(11);
        Node node4 = new Node(10);
        Node node5 = new Node(1);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;

        node1.random = null;
        node2.random = node1;
        node3.random = node5;
        node4.random = node3;
        node5.random = node1;

        System.out.println("Original list:");
        printList(node1);

        Node copied = solution.copyRandomList(node1);

        System.out.println("\nCopied list:");
        printList(copied);

        System.out.println("\nVerification (original != copied but values equal):");
        System.out.println("Original head: " + node1);
        System.out.println("Copied head: " + copied);
    }

    private static void printList(Node head) {
        Node current = head;
        int index = 0;
        while (current != null) {
            String randomStr = (current.random != null) ?
                    String.valueOf(getIndex(head, current.random)) : "null";
            System.out.printf("[%d] val=%d, random=%s (node:%s)%n",
                    index, current.val, randomStr, current);
            current = current.next;
            index++;
        }
    }

    private static int getIndex(Node head, Node target) {
        int index = 0;
        Node current = head;
        while (current != null) {
            if (current == target) return index;
            current = current.next;
            index++;
        }
        return -1;
    }
}
