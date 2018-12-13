import java.util.ArrayList;
import java.util.List;

/**
 * Created by YANGSONG on 2018-12-11.
 *//**
 * Definition of TreeNode:
 * public class TreeNode {
 *     public int val;
 *     public TreeNode left, right;
 *     public TreeNode(int val) {
 *         this.val = val;
 *         this.left = this.right = null;
 *     }
 * }
 */

public class BinaryTreeLongestConsecutiveSequence {
    /**
     * @param root: the root of binary tree
     * @return: the length of the longest consecutive sequence path
     */
    private static int maxLength = 0;
    public static int longestConsecutive(TreeNode root) {
        if (root == null) {
            return 0;
        }

        dfs(root, new ArrayList<Integer>(), 1);
        return maxLength;
    }

    private static void dfs(TreeNode root, List<Integer> list, int length) {
        if (root == null) return;
//        list.add(root.val);

        maxLength = Math.max(length, maxLength);
        System.out.println(root.val + "^^^^" + length);

        if (root.left != null) {
            if (root.left.val == root.val + 1) {
                dfs(root.left, list, length + 1);
            } else {
                dfs(root.left, list, 1);
            }

//            list.remove(list.size() - 1);
        }
        System.out.println(root.val + "VVVVVV" + length);
        if (root.right != null) {
            if (root.right.val == root.val + 1) {
                dfs(root.right, list, length + 1);
            } else {
                dfs(root.right, list, 1);
            }
//            list.remove(list.size() - 1);
        }
    }

    public static void main(String[] args) {
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        TreeNode n4 = new TreeNode(4);
        TreeNode n5 = new TreeNode(5);

        n1.left = n2;
        n1.right = n3;
        n2.left = n4;
        n2.right = n5;

        System.out.println(longestConsecutive(n1));

    }
}