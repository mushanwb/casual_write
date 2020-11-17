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
        BinaryTreeBfs.TreeNode node1 = new TreeNode(3);
        BinaryTreeBfs.TreeNode node2 = new TreeNode(9);
        BinaryTreeBfs.TreeNode node3 = new TreeNode(20);
        BinaryTreeBfs.TreeNode node4 = new TreeNode(15);
        BinaryTreeBfs.TreeNode node5 = new TreeNode(7);

        node1.left = node2;
        node1.right = node3;

        node3.left = node4;
        node3.right = node5;

        System.out.println(bfs(node1));
    }


    // 将二叉树遍历成下面这个结构
//                3
//               / \
//               9  20
//               /  \
//               15   7

//          [
//            [3],
//            [9,20],
//            [15,7]
//          ]

    public static List<List<Integer>> bfs(TreeNode root) {

        List<List<Integer>> val = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        Queue<Integer> num = new LinkedList<>();
        q.add(root);

        num.add(1);
        int a = 0;
        int b = 0;
        List<Integer> tempVal = new ArrayList<>();

        while (q.size() != 0) {
            TreeNode temp = q.poll();
            tempVal.add(temp.value);
            a++;

            if (temp.left != null) {
                q.add(temp.left);
                b++;
            }

            if (temp.right != null) {
                q.add(temp.right);
                b++;
            }

            if (a == num.peek()) {
                val.add(tempVal);
                a = 0;
                num.poll();
                tempVal = new ArrayList<>();
                num.add(b);
                b = 0;
            }
        }

        return val;
    }



// 将二叉树遍历成下面这个结构
//                3
//               / \
//               9  20
//               /  \
//               15   7

//          [3,9,20,15,7]
    public static List<Integer> bfs2(TreeNode root) {
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
