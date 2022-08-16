package com.skillsoft.datastructures;

import java.lang.reflect.Array;
import java.util.Arrays;

public abstract class Heap<T extends Comparable<T>> {
    private static int MAX_SIZE = 10;

    private T[] array;
    private int count = 0;

    @SuppressWarnings("unchecked")
    public Heap(Class<T> clazz) {
        array = (T[]) Array.newInstance(Comparable.class, MAX_SIZE);
    }

    public int getCount() {
        return count;
    }

    public boolean isEmpty() {
        return count == 0;
    }

    public boolean isFull() {
        return count == array.length;
    }

    public T getElementAtIndex(int index) {
        return array[index];
    }

    public int getLeftChildIndex(int parentIndex) {

        if (parentIndex < 0) {
            return -1;
        }

        int leftChildIndex = 2 * parentIndex + 1;

        if (leftChildIndex >= count) {
            return -1;
        }

        return leftChildIndex;
    }

    public int getRightChildIndex(int parentIndex) {

        if (parentIndex < 0) {
            return -1;
        }

        int rightChildIndex = 2 * parentIndex + 1;

        if (rightChildIndex >= count) {
            return -1;
        }

        return rightChildIndex;
    }

    public int getParentIndex(int childIndex) {
        if (childIndex <= 0 || childIndex >= count) {
            return -1;
        }
        return (childIndex - 1) / 2;
    }

    protected void swap(int index1, int index2) {
        T tempValue = array[index1];
        array[index1] = array[index2];
        array[index2] = tempValue;
    }

    protected abstract void siftDown(int index);

    protected abstract void siftUp(int index);

    public T getHighestPriority() throws HeapEmptyException {

        if (count == 0) {
            throw new HeapEmptyException("Empty heap!");
        }
        return array[0];
    }

    public void insert(T value) throws HeapFullException {
        if (count >= array.length) {
            throw new HeapFullException("Heap is full!");
        }

        array[count] = value;
        count++;

        System.out.println("Inserted: " + value + " " + this.toString());

        siftUp(count - 1);
    }

    public T removeHighestPriority() throws HeapEmptyException {
        T first = getHighestPriority();

        array[0] = array[count - 1];
        array[count - 1] = null;

        count--;

        siftDown(0);

        return first;
    }

    @Override
    public String toString() {
        return Arrays.toString(array);
    }

}
