package LinkedlIist;

public class FindRepeatCycle {
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

        ListNode slow = head;
        ListNode fast = slow.next;
        int count = 0;

        while (fast != slow) {
            slow = fast;
            fast = fast.next;
            count++;
        }

        System.out.println(count);

        return false;
    }
}