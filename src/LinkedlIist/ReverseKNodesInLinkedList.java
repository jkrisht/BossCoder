package LinkedlIist;

public class ReverseKNodesInLinkedList {
    public static void main(String[] args) {
        ListNode node = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);

        node.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;

        ListNode no = reverseKNodes(node, 3);

        while (no != null) {
            no = no.next;
        }
    }

    public static ListNode reverseKNodes(ListNode node, int k) {
        ListNode node1 = node;

        while (node1.next != null) {
            ListNode temp = reverseKNodes(node1, k, 1);
            ListNode no = temp;
            while (no != null) {
                System.out.println(no.val);
                no = no.next;
            }
            node1.next = null;
        }

        return node1;
    }

    public static ListNode reverseKNodes(ListNode node, int k, int count) {
        if (count == k || node.next == null) {
            return node;
        }

        ListNode temp = reverseKNodes(node.next, k, count + 1);
        node.next.next = node;
        node.next = null;
        return temp;
    }
}
