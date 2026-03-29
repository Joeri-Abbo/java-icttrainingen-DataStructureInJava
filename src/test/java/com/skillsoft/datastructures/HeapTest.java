package com.skillsoft.datastructures;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HeapTest {

    @Test
    void minHeapSingleElement() throws HeapFullException, HeapEmptyException {
        MinHeap<Integer> heap = new MinHeap<>(Integer.class);
        assertTrue(heap.isEmpty());
        heap.insert(42);
        assertFalse(heap.isEmpty());
        assertEquals(42, heap.getHighestPriority());
    }

    @Test
    void minHeapOrdersTwoElements() throws HeapFullException, HeapEmptyException {
        MinHeap<Integer> heap = new MinHeap<>(Integer.class);
        heap.insert(10);
        heap.insert(3);
        assertEquals(3, heap.getHighestPriority());
    }

    @Test
    void minHeapRemoveHighestPriority() throws HeapFullException, HeapEmptyException {
        MinHeap<Integer> heap = new MinHeap<>(Integer.class);
        heap.insert(5);
        heap.insert(2);
        heap.insert(8);
        assertEquals(2, heap.removeHighestPriority());
        assertEquals(2, heap.getCount());
    }

    @Test
    void maxHeapSingleElement() throws HeapFullException, HeapEmptyException {
        MaxHeap<Integer> heap = new MaxHeap<>(Integer.class);
        heap.insert(7);
        assertEquals(7, heap.getHighestPriority());
    }

    @Test
    void maxHeapOrdersTwoElements() throws HeapFullException, HeapEmptyException {
        MaxHeap<Integer> heap = new MaxHeap<>(Integer.class);
        heap.insert(3);
        heap.insert(10);
        assertEquals(10, heap.getHighestPriority());
    }

    @Test
    void maxHeapRemoveHighestPriority() throws HeapFullException, HeapEmptyException {
        MaxHeap<Integer> heap = new MaxHeap<>(Integer.class);
        heap.insert(5);
        heap.insert(9);
        heap.insert(1);
        assertEquals(9, heap.removeHighestPriority());
        assertEquals(2, heap.getCount());
    }

    @Test
    void emptyHeapThrowsOnRemove() {
        MinHeap<Integer> heap = new MinHeap<>(Integer.class);
        assertThrows(HeapEmptyException.class, heap::getHighestPriority);
    }

    @Test
    void fullHeapThrowsOnInsert() throws HeapFullException {
        MaxHeap<Integer> heap = new MaxHeap<>(Integer.class);
        for (int i = 0; i < 10; i++) {
            heap.insert(i);
        }
        assertThrows(HeapFullException.class, () -> heap.insert(99));
    }
}
