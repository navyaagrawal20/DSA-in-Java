public class BinaryTree{
    public class Node {
        private int value;
        private int height;
        private Node left;
        private Node right;

        public Node(int value) {
            this.value = value;
        }
        public int getValue() {
            return value;
        }
    }
    private Node root;

    public BinaryTree() {
        this.root = null;   
    }
    public int height(Node node) {
        if (node == null) {
            return 0;
        }
        return node.height;
    }
    public boolean isEmpty() {
        return root == null;
    }
    public void display() {
        display(root);
    }

    private void display(Node node) {
        if (node == null) {
            return;
        }
        System.out.println("Value: " + node.value + ", Height: " + node.height);
        display(node.left);
        display(node.right);
    }

    public void insert(int value) {
        root = insert(value, root);
    }
    private Node insert(int value, Node node) {
        if (node == null) {
            node = new Node(value);
            return node;
        }

        if (value < node.value) {
            node.left = insert(value, node.left);
        }

        if (value > node.value) {
            node.right = insert(value, node.right);
        }

        node.height = Math.max(height(node.left), height(node.right)) + 1;
        return node;
    }
    public boolean balanced() {
        return balanced(root);
    }   
    private boolean balanced(Node node) {
        if (node == null) {
            return true;
        }

        int balanceFactor = height(node.left) - height(node.right);
        if (Math.abs(balanceFactor) > 1) {
            return false;
        }

        return balanced(node.left) && balanced(node.right);
    }
    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        int[] values = {5, 3, 7, 2, 4, 6, 8};
        for (int value : values) {
            tree.insert(value);
        }

        tree.display();
        System.out.println("Is the tree balanced? " + tree.balanced());
    }
}