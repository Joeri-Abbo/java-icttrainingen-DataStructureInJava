package com.skillsoft.datastructures;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class MainSortSearchTest {

    @Test
    void bubbleSortSortsArray() {
        int[] arr = {5, 3, 8, 1, 2};
        Main.bubbleSort(arr);
        assertArrayEquals(new int[]{1, 2, 3, 5, 8}, arr);
    }

    @Test
    void selectionSortSortsArray() {
        int[] arr = {4, 2, 7, 1, 9};
        Main.selectionSort(arr);
        assertArrayEquals(new int[]{1, 2, 4, 7, 9}, arr);
    }

    @Test
    void shellSortSortsArray() {
        int[] arr = {9, 3, 6, 1, 5};
        Main.shellSort(arr);
        assertArrayEquals(new int[]{1, 3, 5, 6, 9}, arr);
    }

    @Test
    void mergeSortSortsArray() {
        String[] arr = {"banana", "apple", "cherry", "date"};
        Main.mergeSort(arr);
        assertArrayEquals(new String[]{"apple", "banana", "cherry", "date"}, arr);
    }

    @Test
    void linearSearchFindsElement() {
        String[] arr = {"a", "b", "c", "d"};
        assertEquals(2, Main.linearSearch(arr, "c"));
    }

    @Test
    void linearSearchMissingElement() {
        String[] arr = {"a", "b", "c"};
        assertEquals(-1, Main.linearSearch(arr, "z"));
    }

    @Test
    void interpolationSearchFindsElement() {
        int[] arr = {1, 3, 5, 7, 9, 11};
        assertEquals(2, Main.interpolationSearch(arr, 5));
    }

    @Test
    void bstInsertAndLookup() {
        Node<Integer> root = null;
        root = Main.insert(root, 5);
        root = Main.insert(root, 3);
        root = Main.insert(root, 7);

        assertNotNull(Main.lookup(root, 3));
        assertNotNull(Main.lookup(root, 7));
        assertNull(Main.lookup(root, 99));
    }

    @Test
    void isBinarySearchTreeValid() {
        Node<Integer> root = null;
        root = Main.insert(root, 5);
        root = Main.insert(root, 3);
        root = Main.insert(root, 7);
        assertTrue(Main.isBinarySearchTree(root));
    }

}
