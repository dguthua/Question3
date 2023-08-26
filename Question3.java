import java.util.Scanner;

class TreeNode {
    int data;
    TreeNode left;
    TreeNode right;
}

public class Question3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int rootValue = scanner.nextInt();
        TreeNode root = new TreeNode();
        root.data = rootValue;

        buildTree(root, scanner);

        int v1 = scanner.nextInt();
        int v2 = scanner.nextInt();

        // Find the LCA
        TreeNode result = lca(root, v1, v2);
        System.out.println(result.data);
    }

    static void buildTree(TreeNode root, Scanner scanner) {
        int data = scanner.nextInt();
        if (data == -1) {
            return;
        }

        if (data < root.data) {
            root.left = new TreeNode();
            root.left.data = data;
            buildTree(root.left, scanner);
        } else if (data > root.data) {
            root.right = new TreeNode();
            root.right.data = data;
            buildTree(root.right, scanner);
        }
    }

    static TreeNode lca(TreeNode root, int v1, int v2) {
        if (root.data > v1 && root.data > v2) {
            return lca(root.left, v1, v2);
        }

        if (root.data < v1 && root.data < v2) {
            return lca(root.right, v1, v2);
        }

        return root;
    }
}
