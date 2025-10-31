# Trees — Overview & Concepts

This file explains fundamental concepts of tree data structures, common types, operations, traversals, complexity, and typical uses. It also briefly maps these concepts to the `BinaryTree.java` implementation in this folder.

## What is a Tree?
A tree is a hierarchical, non-linear data structure composed of nodes connected by edges. It has:
- A single root node.
- Nodes with zero or more children.
- Parent/child relationships (each node has at most one parent).
- Leaves: nodes with no children.
- Path, depth (distance from root), and height (max depth of subtree).

Trees are often stored using node objects with references to children or using arrays for complete trees (heaps).

## Common Tree Types
- Binary Tree: each node has at most two children (left, right).
- Binary Search Tree (BST): a binary tree where left subtree values < node < right subtree values (used for ordered storage).
- Balanced Trees: AVL, Red-Black — maintain height ~ O(log n).
- Complete/Perfect/Full Trees: describe fullness of levels/children.
- Heaps (binary heap): complete tree with heap property (max- or min-heap).
- B-Trees / B+ Trees: used in databases/filesystems for disk-friendly balanced search.

## Basic Operations
- Search: find a node (BST: descend left/right using comparisons).
- Insert: add a node (binary tree vs BST differ in placement).
- Delete: remove a node (handle 0/1/2 child cases in BST).
- Traversals: visit nodes in specific order (see below).

## Traversals
- Pre-order (Root, Left, Right) — useful for copying tree or prefix expressions.
- In-order (Left, Root, Right) — yields sorted order for BSTs.
- Post-order (Left, Right, Root) — useful for deleting trees or postfix expressions.
- Level-order (Breadth-first) — uses a queue; visits by depth.

All full-tree traversals visit each node once: O(n) time, O(n) space worst-case (recursion / queue).

## Time & Space Complexity
- Traversal: O(n) time, O(h) recursion stack where h = tree height.
- Search/Insert/Delete in BST:
  - Average (balanced-like): O(log n) time.
  - Worst (degenerate chain): O(n) time.
- Balanced trees (AVL/Red-Black): guaranteed O(log n) for search/insert/delete.
- Space: O(n) to store n nodes.

## Where to Use Trees
- Hierarchical data (file systems, DOM).
- Sorted/indexed data (BSTs, B-trees for databases).
- Priority operations (heaps for priority queues).
- Expression parsing and compilers (parse trees).
- Graph algorithms, routing, AI game trees, autocomplete/trie variants.

## Notes on Trees/BinaryTree.java in this folder
- `BinaryTree.java` implements a simple Binary Search Tree style class:
  - Inner `Node` with `value`, `height`, `left`, `right`.
  - `insert(int)` inserts following BST ordering (no balancing).
  - `height(Node)` stores subtree height updated at insert.
  - `balanced()` checks height difference <= 1 recursively (not a self-balancer).
  - `display()` does a pre-order traversal and prints node values + heights.
- Because this tree is not self-balancing, performance can degrade to O(n) for skewed input.

## Compile & Run (Windows)
Open a terminal in the folder and run:
```shell
javac "Trees\BinaryTree.java"
java -cp . Trees.BinaryTree
```

## Further Reading / Next Steps
- Implement traversals (in-order, post-order, level-order) and unit tests.
- Explore AVL or Red-Black trees for guaranteed balancing.
- Study B-Trees / Tries for database and prefix-search use-cases.
