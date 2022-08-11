package LinkedlIist;

import java.util.HashSet;
import java.util.Set;

public class FindRepeatCycleUsingSet {
    public static void main(String[] args) {
        ListNode node = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);

        node.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node;

        System.out.println(isCycleExists(node));
    }

    public static boolean isCycleExists(ListNode head) {
        if (head == null) {
            return false;
        }

        Set<ListNode> set = new HashSet<>();
        ListNode node = head;

        while (node != null) {
            if (!set.add(node)) {
                return true;
            }
            node = node.next;
        }

        return false;
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}