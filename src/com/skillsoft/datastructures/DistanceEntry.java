package com.skillsoft.datastructures;

public class DistanceEntry {

    private int distance;
    private int lastVertex;

    public DistanceEntry() {
        // The initial distance to all nodes is assumed infinite
        distance = Integer.MAX_VALUE;
        lastVertex = -1;
    }

    public int getDistance() {
        return distance;
    }

    public int getLastVertex() {
        return lastVertex;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    public void setLastVertex(int lastVertex) {
        this.lastVertex = lastVertex;
    }
}
