package LinkedlIist;

public class ReverseLinkedList {
    public static void main(String[] args) {
        ListNode node = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(-1);
        ListNode node5 = new ListNode(-2);

        node.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;

        ListNode result = reverseUsingRecursion(node);

        while (result != null) {
            System.out.println(result.val);
            result = result.next;
        }
    }

    public static void reverse(ListNode head) {
        if (head == null || head.next == null) {
            return;
        }

        ListNode previous = null, current = head, next = null;

        while (current != null) {
            next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }

        while (previous != null) {
            System.out.println(previous.val);
            previous = previous.next;
        }
    }

    public static ListNode reverseUsingRecursion(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode node = reverseUsingRecursion(head.next);
        node.next = head;
        head = null;

        return head;

    }
}

// 1 -> 2 -> 3 -> -1 -> -2 -> null