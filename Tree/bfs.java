import java.util.*;

public class bfs {
    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        int[] values = {5, 3, 7, 2, 4, 6, 8};
        for (int v : values) tree.insert(v);

        List<Integer> levelOrder = bfsTraversal(tree);
        System.out.println("BFS (level-order) traversal: " + levelOrder);

        // search examples
        int target1 = 4;
        int target2 = 10;
        System.out.println("Search " + target1 + ": " + (bfsSearch(tree, target1) ? "found" : "not found"));
        System.out.println("Search " + target2 + ": " + (bfsSearch(tree, target2) ? "found" : "not found"));
    }

    private static List<Integer> bfsTraversal(BinaryTree tree) {
        List<Integer> result = new ArrayList<>();
        BinaryTree.Node root = tree.getRoot();
        if (root == null) return result;

        Queue<BinaryTree.Node> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            BinaryTree.Node cur = q.poll();
            result.add(cur.getValue());
            if (cur.getLeft() != null) q.add(cur.getLeft());
            if (cur.getRight() != null) q.add(cur.getRight());
        }
        return result;
    }

    // New: BFS-based search for a target value
    private static boolean bfsSearch(BinaryTree tree, int target) {
        BinaryTree.Node root = tree.getRoot();
        if (root == null) return false;

        Queue<BinaryTree.Node> q = new LinkedList<>();
        q.add(root); 
        while (!q.isEmpty()) {
            BinaryTree.Node cur = q.poll();
            if (cur.getValue() == target) return true;
            if (cur.getLeft() != null) q.add(cur.getLeft());
            if (cur.getRight() != null) q.add(cur.getRight());
        }
        return false;
    }
     
}