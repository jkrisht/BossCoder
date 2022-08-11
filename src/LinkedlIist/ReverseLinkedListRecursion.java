package LinkedlIist;

public class ReverseLinkedListRecursion {
    public static void main(String[] args) {
        System.out.println(1 > 1);
    }
    public static void main1(String[] args) {
        ListNode node = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(-1);

        node.next = node2;
        node2.next = node3;
        node3.next = node4;
        // ListNode head = reverse(null, node, null);
        ListNode head = reverse(node);

        while (head != null) {
            System.out.println(head.val);
            head = head.next;
        }
    }

    public static ListNode reverse(ListNode prev, ListNode current, ListNode next) {
        if (current == null) {
            return prev;
        }

        next = current.next;
        current.next = prev;
        prev = current;
        current = next;
        return reverse(prev, current, next);
    }

    public static ListNode reverse(ListNode head) {
        if (head.next == null) {
            return head;
        }

        ListNode temp = reverse(head.next);
        head.next.next = head;
        head.next = null;
        return temp;
    }
}

// 1 -> 2 -> 3 -> null