package LinkedlIist;

public class BubbleSortList {
    public static void main(String[] args) {
        ListNode node1 = new ListNode(4);
        ListNode node2 = new ListNode(3);
        ListNode node3 = new ListNode(2);
        ListNode node4 = new ListNode(3);
        ListNode node5 = new ListNode(5);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;

        sort(node1);

        ListNode node = node1;

        while (node != null) {
            System.out.println(node.val);
            node = node.next;
        }
    }

    public static ListNode sort(ListNode head) {
        if (head == null) {
            return null;
        }

        ListNode current = head;

        while (current != null) {
            ListNode next = current.next;

            while (next != null) {
                if (current.val > next.val) {
                    int temp = current.val;
                    current.val = next.val;
                    next.val = temp;
                }
                next = next.next;
            }

            current = current.next;
        }

        return head;
    }
}
