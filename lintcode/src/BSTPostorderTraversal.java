import java.util.ArrayList;
import java.util.Stack;

/**
 * Created by YANGSONG on 2018-12-08.
 */
public class BSTPostorderTraversal {
    // postorder traversal: left, right, root
    public static ArrayList<Integer> postorderTraversal(TreeNode root) {
        ArrayList<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode prev = null;
        TreeNode cur = null;
        if (root == null) return res;
        stack.push(root);
        while (!stack.isEmpty()) {
            cur = stack.peek();
            if (prev == null || prev.left == cur || prev.right == cur) {
                if (cur.left != null) {
                    stack.push(cur.left);
                } else if (cur.right != null) {
                    stack.push(cur.right);
                }
            } else if (cur.left == prev) {
                if (cur.right != null) {
                    stack.push(cur.right);
                }
            } else {
                res.add(cur.val);
                stack.pop();
            }
            prev = cur;
        }
        return res;
    }

    // left root right
    public static ArrayList<Integer> inorderTraversal(TreeNode root) {
        ArrayList<Integer> res = new ArrayList<>();
        if (root == null) return res;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        while (cur != null) {
            stack.push(cur);
            cur = cur.left;
        }
        while (!stack.isEmpty()) {
            TreeNode node = stack.peek();
            res.add(node.val);
            if (node.right != null) {
                node = node.right;

                while (node != null) {
                    stack.push(node);
                    node = node.left;
                }
            } else {
                node = stack.pop();
                while (!stack.isEmpty() && stack.peek().right == node) {
                    node = stack.pop();
                }
            }
        }
        return res;
    }

    // preorder: root, left, right
    public static ArrayList<Integer> preorderTraversal(TreeNode root) {
        ArrayList<Integer> res = new ArrayList<>();
        if (root == null) return res;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            res.add(node.val);
            if (node.right != null) {
                stack.push(node.right);
            }
            if (node.left != null) {
                stack.push(node.left);
            }
        }
        return res;
    }



    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode root_left = new TreeNode(2);
        TreeNode root_right = new TreeNode(3);
        TreeNode root_left_left = new TreeNode(4);
        TreeNode root_left_right = new TreeNode(5);
        TreeNode root_right_left = new TreeNode(6);

        root.left = root_left;
        root.right = root_right;
        root_left.left = root_left_left;
        root_left.right = root_left_right;
        root_right.left = root_right_left;
        /**
         *        A1
         *     B2     C3
         *  D4    E5  F6
         *
         *  post-order traversal
         *  D E B F C A
         *  4 5 2 6 3 1
         *
         *  inorder traversal
         *  D B E A F C
         *  4 2 5 1 6 3
         *
         *  preorder
         *  A B D E C F
         *  1 2 4 5 3 6
         */
//        System.out.println(postorderTraversal(root));
//        System.out.println(inorderTraversal(root));
        System.out.println(preorderTraversal(root));
    }

}
