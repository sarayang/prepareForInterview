import java.util.Stack;

/**
 * Created by YANGSONG on 2018-12-11.
 */
public class BSTLowerBound {
    // stack保存一路走到当前节点的所有节点
    public static Stack<Integer> getStack(TreeNode node, int target) {
        Stack<Integer> stack = new Stack<>();
        while (node != null) {
            stack.push(node.val);
            if (node.val < target) {
                node = node.right;
            } else {
                node = node.left;
            }
        }
        return stack;
    }

    public static void main(String[] args) {
        TreeNode n4 = new TreeNode(4);
        TreeNode n2 = new TreeNode(2);
        TreeNode n5 = new TreeNode(5);
        TreeNode n1 = new TreeNode(1);
        TreeNode n3 = new TreeNode(3);

        n4.left = n2;
        n4.right = n5;
        n2.left = n1;
        n2.right = n3;

        System.out.println(getStack(n4, 3));
    }
}
