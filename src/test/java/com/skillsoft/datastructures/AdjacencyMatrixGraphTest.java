package com.skillsoft.datastructures;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class AdjacencyMatrixGraphTest {

    @Test
    void testGetNumVertices() {
        Graph g = new AdjacencyMatrixGraph(5, Graph.GraphType.DIRECTED);
        assertEquals(5, g.getNumVertices());
    }

    @Test
    void testAddEdgeDirected() {
        Graph g = new AdjacencyMatrixGraph(3, Graph.GraphType.DIRECTED);
        g.addEdge(0, 1);
        List<Integer> adj0 = g.getAdjacentVertices(0);
        List<Integer> adj1 = g.getAdjacentVertices(1);
        assertTrue(adj0.contains(1));
        assertFalse(adj1.contains(0));
    }

    @Test
    void testAddEdgeUndirected() {
        Graph g = new AdjacencyMatrixGraph(3, Graph.GraphType.UNDIRECTED);
        g.addEdge(0, 1);
        assertTrue(g.getAdjacentVertices(0).contains(1));
        assertTrue(g.getAdjacentVertices(1).contains(0));
    }

    @Test
    void testGetIndegree() {
        Graph g = new AdjacencyMatrixGraph(4, Graph.GraphType.DIRECTED);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(3, 2);
        assertEquals(3, g.getIndegree(2));
        assertEquals(0, g.getIndegree(0));
    }

    @Test
    void testInvalidVertexThrows() {
        Graph g = new AdjacencyMatrixGraph(3, Graph.GraphType.DIRECTED);
        assertThrows(IllegalArgumentException.class, () -> g.addEdge(0, 5));
        assertThrows(IllegalArgumentException.class, () -> g.getAdjacentVertices(-1));
    }

    @Test
    void testAdjacentVerticesSorted() {
        Graph g = new AdjacencyMatrixGraph(5, Graph.GraphType.DIRECTED);
        g.addEdge(0, 4);
        g.addEdge(0, 1);
        g.addEdge(0, 3);
        List<Integer> adj = g.getAdjacentVertices(0);
        assertEquals(List.of(1, 3, 4), adj);
    }
}
