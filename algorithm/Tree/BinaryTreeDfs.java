package Tree;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class BinaryTreeDfs {

    public static class TreeNode {
        int value;
        TreeNode left;
        TreeNode right;

        public TreeNode(int value) {
            this.value = value;
        }
    }

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(6);
        TreeNode node7 = new TreeNode(7);
        TreeNode node8 = new TreeNode(8);
        TreeNode node9 = new TreeNode(9);
        TreeNode node10 = new TreeNode(10);

        node1.left = node2;
        node1.right = node3;

        node2.left = node4;
        node2.right = node5;

        node3.right = node6;

        node4.left = node8;
        node4.right = node9;

        node6.left = node7;
        node6.right = node10;

        System.out.println(dfs3(node1));
    }

    //解法一、 二叉树的深度优先遍历（前序 非递归）
    public static List<Integer> dfs(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Deque<TreeNode> deque = new LinkedList<>();
        deque.add(root);
        list.add(root.value);

        boolean flag = true;
        while (!deque.isEmpty()) {
            // 从栈的尾部取出一个树节点，但不删除
            TreeNode node = deque.peekLast();
            // 如果当前树节点有左子树,并且没有找过左子树，则循环将左子树添加到 栈 的尾部,直到左子树为 null
            while (node.left != null && flag) {
                node = node.left;
                list.add(node.value);
                deque.add(node);
            }

            // 当 当前树节点的左子树为 null 时，则开始寻找右子树
            // 当开始寻找右子树的时候，则需要将该树节点出栈
            deque.pollLast();
            // 如果有右子树，则将右子树的节点添加到栈中，并且又从左子树开始循环
            if (node.right != null) {
                node = node.right;
                list.add(node.value);
                deque.add(node);
                flag = true;
            } else {
                // 如果没有，则将当前的树节点出栈，并且告诉栈中下一个元素，不需要找左子树了
                flag = false;
            }
        }

        return list;
    }


    // 解法二、(非递归 思路较清晰)
    public static List<Integer> dfs2(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Deque<TreeNode> deque = new LinkedList<>();

        // 新建一个游标节点为根节点
        TreeNode node = root;
        // 当遍历到最后一个节点的时候，无论它的左右子树都为空，并且栈也为空
        // 所以，只要不同时满足这两点，都需要进入循环
        while (node != null || !deque.isEmpty()) {
            // 若当前考查节点非空，则输出该节点的值
            // 由考查顺序得知，需要一直往左走
            while (node != null) {
                list.add(node.value);
                // 为了之后能找到该节点的右子树，暂存该节点
                deque.add(node);
                node = node.left;
            }
            // 一直到左子树为空，则开始考虑右子树
            // 如果栈已空，就不需要再考虑
            // 弹出栈顶元素，将游标等于该节点的右子树
            // 如果该节点的右子树为空，也需要复制防止上面的左子树循环，
            // 在找下一个节点的右子树
            if (!deque.isEmpty()) {
                node = deque.pollLast();
                node = node.right;
            }
        }

        return list;
    }


    // 解法三、 递归
    public static List<Integer> dfs3(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        recursionPreorderTraversal(root, list);
        return list;
    }

    //先输出节点的值，再递归遍历左右子树。中序和后序的递归类似，改变根节点输出位置即可。
    private static void recursionPreorderTraversal(TreeNode root, List<Integer> list) {
        if (root != null) {
            list.add(root.value);
            recursionPreorderTraversal(root.left, list);
            recursionPreorderTraversal(root.right, list);
        }
    }

}
