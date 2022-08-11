package trees;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class BreadthFirstSearch {
    public static void main(String[] args) {
        TreeNode head = new TreeNode(5);
        TreeNode node1 = new TreeNode(4);
        TreeNode node2 = new TreeNode(3);
        TreeNode node3 = new TreeNode(2);
        TreeNode node4 = new TreeNode(1);
        TreeNode node5 = new TreeNode(0);
        TreeNode node6 = new TreeNode(-1);

        head.left = node2;
        head.right = node1;
        head.left.left = node3;
        head.left.right = node4;
        head.right.left = node5;
        head.right.right = node6;

        depthFirstSearch(head);
        System.out.println();

        PriorityQueue<Integer> queue = new PriorityQueue<>();
        queue.add(3);
        queue.add(1);
        queue.add(2);
        System.out.println(queue.poll());
    }

    public static void depthFirstSearch(TreeNode head) {
        if (head == null) {
            return;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(head);

        while (!queue.isEmpty()) {
            TreeNode current = queue.poll();

            if (current != null) {
                System.out.print(current.value +" -> ");
                queue.add(current.left);
                queue.add(current.right);
            }
        }
    }
}
