import java.util.ArrayList;
import java.util.List;

/**
 * Created by YANGSONG on 2018-12-10.
 */

/**
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

public class BinaryTreePaths {
    /**
     * @param root: the root of the binary tree
     * @return: all root-to-leaf paths
     */


    public List<String> binaryTreePaths(TreeNode node) {
        List<String> res = new ArrayList<>();
        if (node == null) {
            return res;
        }
        if (node.left == null && node.right == null) {
            res.add(node.val + "");
            return res;
        }
        List<String> leftSubpaths = binaryTreePaths(node.left);
        List<String> rightSubpaths = binaryTreePaths(node.right);
        for (String path : leftSubpaths) {
            res.add(node.val + "->" + path);
        }

        for (String path : rightSubpaths) {
            res.add(node.val + "->" + path);
        }

        // leftSubpaths = [] and rightSubpaths = []
        // if (res.size() == 0) {
        //     res.add(node.val + "");
        // }
        return res;
    }


    // traversal/dfs
    // public List<String> binaryTreePaths(TreeNode root) {
    //     List<String> res = new ArrayList<>();
    //     if (root == null) {
    //         return res;
    //     }
    //     dfs(root, new ArrayList<>(), res);
    //     return res;
    // }

    // private void dfs(TreeNode node, List<String> subres, List<String> res) {
    //     if (node.left == null && node.right == null) {
    //         subres.add(node.val + "");
    //         // System.out.println("====" + subres);
    //         StringBuffer sb = new StringBuffer();
    //         for (int i = 0; i < subres.size(); i++) {
    //             sb.append(subres.get(i));
    //             if (i != subres.size() - 1) {
    //                 sb.append("->");
    //             }
    //         }
    //         res.add(sb.toString());
    //         subres.remove(subres.size() - 1);
    //         // System.out.println("----" + subres);
    //         return;
    //     }
    //     if (node.left != null) {
    //         subres.add(Integer.toString(node.val));
    //         // System.out.println("node.left add: " + subres);
    //         dfs(node.left, subres, res);
    //         subres.remove(subres.size() - 1);
    //         // System.out.println("node.left remove: " + subres);
    //     }

    //     if (node.right != null) {
    //         subres.add(Integer.toString(node.val));
    //         // System.out.println("node.right add: " + subres);
    //         dfs(node.right, subres, res);
    //         subres.remove(subres.size() - 1);
    //         // System.out.println("node.right remove: " + subres);
    //     }
    // }
}