package com.dsa.datastructure.heap;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;

public class Heap <T> {
    private final List<T> heap;
    private final Comparator<T> comparator;

    public Heap(Comparator<T> comparator) {
        this.heap = new ArrayList<>();
        this.comparator = comparator;
    }

    // ========== Core APIs ==========

    public int size() {
        return heap.size();
    }

    public boolean isEmpty() {
        return heap.isEmpty();
    }

    public T peek() {
        if(heap.isEmpty()) throw new NoSuchElementException();
        return heap.getFirst();
    }

    public void add(T val) {
        heap.add(val);
        siftUp(heap.size() - 1);
    }

    public T poll() {
        if (isEmpty()) throw new NoSuchElementException();
        T root = heap.getFirst();
        T last = heap.removeLast();
        if(!heap.isEmpty()) {
            heap.set(0 , last);
            siftDown();
        }
        return root;
    }

    // ========== Heap Helpers ==========

    private void siftUp(int idx) {
        while (idx > 0) {
            int parent = (idx - 1) / 2;
            if (comparator.compare(heap.get(idx), heap.get(parent)) >= 0) break;
            swap(idx, parent);
            idx = parent;
        }
    }

    private void siftDown() {
        int idx = 0;
        int size = heap.size();
        while (true) {
            int left = 2 * idx + 1;
            int right = 2 * idx + 2;
            int smallest = idx;

            if (left < size && comparator.compare(heap.get(left), heap.get(smallest)) < 0) {
                smallest = left;
            }
            if (right < size && comparator.compare(heap.get(right), heap.get(smallest)) < 0) {
                smallest = right;
            }

            if (smallest == idx) break;

            swap(idx, smallest);
            idx = smallest;
        }
    }

    private void swap(int i, int j) {
        T temp = heap.get(i);
        heap.set(i, heap.get(j));
        heap.set(j, temp);
    }
}
