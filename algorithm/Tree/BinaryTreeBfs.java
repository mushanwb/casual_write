package Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeBfs {

    public static class TreeNode {
        int value;
        BinaryTreeBfs.TreeNode left;
        BinaryTreeBfs.TreeNode right;

        public TreeNode(int value) {
            this.value = value;
        }
    }

    public static void main(String[] args) {
        BinaryTreeBfs.TreeNode node1 = new TreeNode(1);
        BinaryTreeBfs.TreeNode node2 = new TreeNode(2);
        BinaryTreeBfs.TreeNode node3 = new TreeNode(3);
        BinaryTreeBfs.TreeNode node4 = new TreeNode(4);
        BinaryTreeBfs.TreeNode node5 = new TreeNode(5);
        BinaryTreeBfs.TreeNode node6 = new TreeNode(6);
        BinaryTreeBfs.TreeNode node7 = new TreeNode(7);
        BinaryTreeBfs.TreeNode node8 = new TreeNode(8);
        BinaryTreeBfs.TreeNode node9 = new TreeNode(9);
        BinaryTreeBfs.TreeNode node10 = new TreeNode(10);

        node1.left = node2;
        node1.right = node3;

        node2.left = node4;
        node2.right = node5;

        node3.right = node6;

        node4.left = node8;
        node4.right = node9;

        node6.left = node7;
        node6.right = node10;

        System.out.println(bfs(node1));
    }

    public static List<Integer> bfs(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Queue<BinaryTreeBfs.TreeNode> queue = new LinkedList<>();
        queue.add(root);
        // 使用队列存储树节点
        while (queue.size() != 0) {
            BinaryTreeBfs.TreeNode tempRoot = queue.poll();
            list.add(tempRoot.value);
            if (tempRoot.left != null) {
                queue.add(tempRoot.left);
            }
            if (tempRoot.right != null) {
                queue.add(tempRoot.right);
            }
        }
        return list;
    }
}
