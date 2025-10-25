import java.util.*;

public class dfs {
    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        int[] values = {5, 3, 7, 2, 4, 6, 8};
        for (int v : values) tree.insert(v);

        List<Integer> preorder = dfsTraversal(tree);
        System.out.println("DFS (pre-order) traversal: " + preorder);

        int target1 = 4;
        int target2 = 10;
        System.out.println("Search " + target1 + ": " + (dfsSearch(tree, target1) ? "found" : "not found"));
        System.out.println("Search " + target2 + ": " + (dfsSearch(tree, target2) ? "found" : "not found"));
    }

    // DFS traversal (pre-order)
    private static List<Integer> dfsTraversal(BinaryTree tree) {
        List<Integer> result = new ArrayList<>();
        dfsHelper(tree.getRoot(), result);
        return result;
    }

    private static void dfsHelper(BinaryTree.Node node, List<Integer> result) {
        if (node == null) return;
        // preorder: node, left, right
        result.add(node.getValue());
        dfsHelper(node.getLeft(), result);
        dfsHelper(node.getRight(), result);
    }

    // DFS-based search (recursive)
    private static boolean dfsSearch(BinaryTree tree, int target) {
        return dfsSearchHelper(tree.getRoot(), target);
    }

    private static boolean dfsSearchHelper(BinaryTree.Node node, int target) {
        if (node == null) return false;
        if (node.getValue() == target) return true;
        if (dfsSearchHelper(node.getLeft(), target)) return true;
        return dfsSearchHelper(node.getRight(), target);
    }
}