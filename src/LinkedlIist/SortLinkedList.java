package LinkedlIist;

public class SortLinkedList {
    public static void main(String[] args) {
        ListNode node1 = new ListNode(4);
        ListNode node2 = new ListNode(3);
        ListNode node3 = new ListNode(2);
        ListNode node4 = new ListNode(1);
        ListNode node5 = new ListNode(5);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;

        mergeSort(node1);
    }

    public static ListNode mergeSort(ListNode head) {
        if (head.next == null) {
            return head;
        }

        return null;
    }
}
