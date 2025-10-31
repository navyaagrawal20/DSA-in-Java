# Heap Data Structure

A Heap is a specialized tree-based data structure that satisfies the heap property. It is a complete binary tree, which means all levels of the tree are completely filled, except possibly the last level, which is filled from left to right. This property allows heaps to be efficiently stored in an array or list.

This implementation is a **Max-Heap**, where for any given node `P`, the value of `P` is greater than or equal to the values of its children. The largest element is always at the root of the heap.

## How It Works

The heap is implemented using an `ArrayList` in Java. The parent-child relationship is maintained using array indices:
- For a node at index `i`:
  - Its parent is at index `(i - 1) / 2`
  - Its left child is at index `2 * i + 1`
  - Its right child is at index `2 * i + 2`

### Core Operations

1.  **`insert(T value)`**:
    - The new element is added to the end of the `ArrayList`, which corresponds to the next open spot at the bottom level of the tree.
    - To maintain the max-heap property, the new element is "sifted up". It's compared with its parent, and if it's larger, they are swapped.
    - This process continues until the element is in its correct position (i.e., it's smaller than its parent) or it reaches the root.

2.  **`remove()` (Extract Max)**:
    - The largest element is always at the root (index 0). This element is saved for return.
    - To fill the vacancy at the root, the *last* element in the heap is moved to the root's position.
    - This new root is likely out of place. To restore the heap property, it is "sifted down". It's compared with its children, and if it's smaller than either of them, it's swapped with the *larger* of the two children.
    - This process continues until the element is in its correct position (i.e., it's larger than both its children) or it becomes a leaf node.

3.  **`heapSort()`**:
    - This method demonstrates how a heap can be used for sorting.
    - It works by repeatedly calling the `remove()` method on the heap. Since `remove()` always extracts the maximum element, calling it until the heap is empty yields all the elements in descending sorted order.

## Time Complexity

| Operation | Average Case | Worst Case |
| :--- | :--- | :--- |
| **Insert** | `O(log n)` | `O(log n)` |
| **Remove (Extract Max)** | `O(log n)` | `O(log n)` |
| **Peek (Get Max)** | `O(1)` | `O(1)` |
| **Search** | `O(n)` | `O(n)` |
| **Heap Sort** | `O(n log n)` | `O(n log n)` |

-   **Logarithmic Time (O(log n))**: Insertion and removal operations depend on the height of the tree, which is `log n` for a complete binary tree with `n` elements.
-   **Constant Time (O(1))**: Finding the maximum element is a simple lookup at the root of the heap.
-   **Linear Time (O(n))**: Searching for an arbitrary element requires traversing the entire heap in the worst case, as the heap property does not provide ordering between siblings or cousins.

## Where to Use Heaps

Heaps are the perfect data structure for any application where you need to frequently and efficiently find and extract the minimum or maximum element.

Common use cases include:
1.  **Priority Queues**: Heaps are the most common way to implement priority queues. The element with the highest (or lowest) priority is always at the root, ready to be processed.
2.  **Heap Sort**: A fast and efficient comparison-based sorting algorithm.
3.  **Graph Algorithms**: Used in algorithms like Dijkstra's shortest path and Prim's minimum spanning tree to efficiently retrieve the next vertex to process.
4.  **Finding the Kth Largest/Smallest Element**: A heap can find the kth largest element in a collection in `O(n log k)` time.
5.  **Event Simulation**: Managing events in a discrete event simulation, where the next event to be processed is the one with the earliest timestamp.
