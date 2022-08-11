package trees;

import java.util.Stack;

public class DepthFirstSearch {
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

        preOrderTraverse(head);
        System.out.println();
        inOrderTraverse(head);
        System.out.println();
        postOrderTraverse(head);
        System.out.println();
        inOrderUsingIteration(head);
    }

    public static void preOrderTraverse(TreeNode head) {
        if (head == null) {
            return;
        }
        System.out.print(head.value + " -> ");
        preOrderTraverse(head.left);
        preOrderTraverse(head.right);
    }

    public static void inOrderTraverse(TreeNode head) {
        if (head == null) {
            return;
        }
        inOrderTraverse(head.left);
        System.out.print(head.value + " -> ");
        inOrderTraverse(head.right);
    }

    public static void postOrderTraverse(TreeNode head) {
        if (head == null) {
            return;
        }
        postOrderTraverse(head.left);
        postOrderTraverse(head.right);
        System.out.print(head.value + " -> ");
    }

    public static void inOrderUsingIteration(TreeNode head) {
        if (head == null) {
            return;
        }

        Stack<TreeNode> stack = new Stack<>();
        TreeNode current = head;

        while (current != null || !stack.empty()) {

            while (current != null) {
                stack.push(current);
                current = current.left;
            }

            current = stack.pop();
            System.out.print(current.value + " -> ");
            current = current.right;
        }
    }
}
