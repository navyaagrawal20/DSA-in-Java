
import java.lang.reflect.Array;
import java.util.*;
import java.util.ArrayList;
import java.util.NoSuchElementException;
class Heap <T extends Comparable<T>> {
    private ArrayList<T> list;
    public Heap(){
        list = new ArrayList<>();
    }
    private void swap(int i, int j){
        T temp = list.get(i);
        list.set(i, list.get(j));
        list.set(j, temp);
    } 
    private int parent(int index){
        return (index - 1) / 2;
    }
    private int left(int index){
        return 2 * index + 1;
    }
    private int right(int index){
        return 2 * index + 2;
    } 
    public void insert(T value){
        list.add(value);
        int index = list.size() - 1;
        while(index > 0){
            int parentIndex = parent(index);
            if(list.get(index).compareTo(list.get(parentIndex)) > 0){
                swap(index, parentIndex);
                index = parentIndex;
            } else {
                break;
            }
        }
    }
    // public T remove() throws Exception {
    //     if(list.isEmpty()){
    //         throw new Exception("Heap is empty");
    //     }
    //     T temp = list.get(0);
    //     T last = list.remove(list.size() - 1);
    //     if(!list.isEmpty()){
    //         list.set(0, last);
    //         downheap(0);
    //     }
    //     return temp;
    // } 
    

public T remove() {
    if(list.isEmpty()){
        throw new NoSuchElementException("Heap is empty");
    }
    T temp = list.get(0);
    T last = list.remove(list.size() - 1);

    if(!list.isEmpty()){
        list.set(0, last);
        downheap(0);
    }
    return temp;
}

    private void downheap(int index){
    int size = list.size();
    while(true){
        int leftIndex = left(index);
        int rightIndex = right(index);
        int max = index;

        if(leftIndex < size && list.get(leftIndex).compareTo(list.get(max)) > 0){
            max = leftIndex;
        }
        if(rightIndex < size && list.get(rightIndex).compareTo(list.get(max)) > 0){
            max = rightIndex;
        }

        if(max != index){
            swap(index, max);
            index = max;
        } else {
            break;
        }
    }
}

    public ArrayList<T> heapSort() throws Exception {
        ArrayList<T> sortedList = new ArrayList<>();
        Heap<T> tempHeap = new Heap<>();
        for(T item : list){
            tempHeap.insert(item);
        }
        while(!tempHeap.list.isEmpty()){
            sortedList.add(tempHeap.remove());
        }
        return sortedList;
    }
    public static void main(String args[]){
        System.out.println("This is Heap Data Structure");
        Heap<Integer> heap = new Heap<>();
        int[] values = {5, 3, 8, 1, 4, 7, 6, 2};
        for(int value : values){
            heap.insert(value);
        }
        System.out.println("Heap after insertions: " + heap.list);
        try {
            ArrayList<Integer> sorted = heap.heapSort();
            System.out.println("Sorted elements: " + sorted);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        System.out.println(heap.remove  ());
    }
}
