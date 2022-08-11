package curriculum.C28;

public class RemoveDuplicatesFromSortedList {
    public static void main(String[] args) {
        ListNode node = new ListNode(1);
        ListNode node2 = new ListNode(1);
        ListNode node3 = new ListNode(2);
        ListNode node4 = new ListNode(3);
        ListNode node5 = new ListNode(3);
        ListNode node6 = new ListNode(3);
        ListNode node7 = new ListNode(3);
        ListNode node8 = new ListNode(3);
        ListNode node9 = new ListNode(3);

        node.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        node6.next = node7;
        node7.next = node8;
        node8.next = node9;

        ListNode result = new RemoveDuplicatesFromSortedList().deleteDuplicates(node);

        while (result != null) {
            System.out.println(result.val);
            result = result.next;
        }
    }

    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return null;
        }

        ListNode previous = head;
        ListNode next = previous.next;

        while (next != null) {
            while (next != null && previous.val == next.val) {
                previous.next = next.next;
                next = next.next;
            }
            previous = next;
            next = next != null ? next.next : null;
        }

        return head;
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
