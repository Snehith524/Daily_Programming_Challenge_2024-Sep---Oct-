import java.util.Scanner;

public class Solution {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) return root;
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if (left != null && right != null) return root;
        return left != null ? left : right;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the number of nodes in the tree:");
        int n = scanner.nextInt();

        TreeNode[] nodes = new TreeNode[n];
        for (int i = 0; i < n; i++) {
            System.out.println("Enter the value of node " + (i + 1) + ":");
            int val = scanner.nextInt();
            nodes[i] = new TreeNode(val);
        }

        System.out.println("Enter the parent of each node (0 for root, -1 for no parent):");
        for (int i = 0; i < n; i++) {
            System.out.println("Enter the parent of node " + (i + 1) + ":");
            int parent = scanner.nextInt();
            if (parent != -1) {
                if (parent == 0) {
                    nodes[i].left = nodes[0];
                } else {
                    nodes[parent - 1].left = nodes[i];
                }
            }
        }

        System.out.println("Enter the right child of each node (0 for root, -1 for no child):");
        for (int i = 0; i < n; i++) {
            System.out.println("Enter the right child of node " + (i + 1) + ":");
            int child = scanner.nextInt();
            if (child != -1) {
                if (child == 0) {
                    nodes[i].right = nodes[0];
                } else {
                    nodes[i].right = nodes[child - 1];
                }
            }
        }

        System.out.println("Enter the values of the two nodes for which to find the LCA:");
        int pVal = scanner.nextInt();
        int qVal = scanner.nextInt();

        TreeNode p = null;
        TreeNode q = null;
        for (TreeNode node : nodes) {
            if (node.val == pVal) {
                p = node;
            }
            if (node.val == qVal) {
                q = node;
            }
        }

        Solution solution = new Solution();
        TreeNode lca = solution.lowestCommonAncestor(nodes[0], p, q);

        System.out.println("Lowest Common Ancestor of " + pVal + " and " + qVal + ": " + lca.val);
    }
}
