/**
 * Created by YANGSONG on 2018-12-08.
 */


/**
 * Definition of TreeNode:
 **/
class TreeNode {
    public int val;
    public TreeNode left, right;
    TreeNode(int val) {
        this.val = val;
        this.left = this.right = null;
    }
}

class ResultType {
    int minimumSum;
    int sum;
    TreeNode node;
    public ResultType(int minSum, TreeNode node, int sum) {
        this.minimumSum = minSum;
        this.node = node;
        this.sum = sum;
    }
}
public class minimumSubtree {
    /**
     * @param root: the root of binary tree
     * @return: the root of the minimum subtree
     */
    public TreeNode findSubtree(TreeNode root) {
        if (root == null) {
            return root;
        }
        ResultType res = divideConquer(root);
        return res.node;
    }

    private ResultType divideConquer(TreeNode node) {
        if (node == null) {
            return new ResultType(Integer.MAX_VALUE, node, 0);
        }
        ResultType left = divideConquer(node.left);
        ResultType right = divideConquer(node.right);

        ResultType res = new ResultType(left.sum + right.sum + node.val, node, left.sum + right.sum + node.val);
        if (left.minimumSum < res.minimumSum) {
            res.minimumSum = left.minimumSum;
            res.node = left.node;

        }
        if (right.minimumSum < res.minimumSum) {
            res.minimumSum = right.minimumSum;
            res.node = right.node;

        }
        return res;
        // if (left.node == null && right.node == null) {
        //     return new ResultType(node.val, node, node.val);
        // }
        // if (left.node == null) {
        //     if (right.minimumSum < (right.sum + node.val)) {
        //         return right;
        //     } else {
        //         return new ResultType(right.sum + node.val, node, right.sum + node.val);
        //     }
        // }

        // if (right.node == null) {
        //     if (left.minimumSum < (left.sum + node.val)) {
        //         return left;
        //     } else {
        //         return new ResultType(left.sum + node.val, node, left.sum + node.val);
        //     }
        // }

        // // left, right both are not null
        // ResultType res = left.minimumSum < right.minimumSum ? left : right;
        // return res.minimumSum < (left.sum + right.sum + node.val) ?
        // res : new ResultType(left.sum + right.sum + node.val, node, left.sum + right.sum + node.val);
    }




















}
