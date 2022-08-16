package com.skillsoft.datastructures;

public class MaxHeap<T extends Comparable<T>> extends Heap<T> {

    public MaxHeap(Class<T> clazz) {
        super(clazz);
    }

    @Override
    protected void siftDown(int index) {
        System.out.println("Sifting down: " + getElementAtIndex(index));

        int leftIndex = getLeftChildIndex(index);
        int rightIndex = getRightChildIndex(index);

        //NOTE: Find the larger of the left and right child elements.
        int largerIndex = -1;

        if (leftIndex != -1 && rightIndex != -1) {

            T leftElement = getElementAtIndex(leftIndex);
            T rightElement = getElementAtIndex(rightIndex);

            largerIndex = leftElement.compareTo(rightElement) > 0 ? leftIndex : rightIndex;
        } else if (leftIndex != -1) {
            largerIndex = leftIndex;
        } else if (rightIndex != -1) {
            largerIndex = rightIndex;
        }

        //NOTE: If the left and right child do not exist stop sifting down.
        if (largerIndex == -1) {
            System.out.println("Stopping sift down, found position ");
            return;
        }
        System.out.println("Larger child: " + getElementAtIndex(largerIndex));

        //NOTE: Compare the larger child with the current index to see if a swap and further sift down is needed
        if (getElementAtIndex(largerIndex).compareTo(getElementAtIndex(index)) > 0) {
            swap(largerIndex, index);
            System.out.println("Swap: " + this.toString());

            siftDown(largerIndex);
        }

    }

    @Override
    protected void siftUp(int index) {
        System.out.println("Sifting up: " + getElementAtIndex(index));

        int parentIndex = getParentIndex(index);

        if (parentIndex == -1) {
            System.out.println("Stopping sift up, found position ");
            return;
        }

        System.out.println("Parent: " + getElementAtIndex(parentIndex));

        if (getElementAtIndex(index).compareTo(getElementAtIndex(parentIndex)) > 0) {
            swap(index, parentIndex);
            System.out.println("Swap: " + this.toString());
            siftUp(parentIndex);
        }
    }
}
