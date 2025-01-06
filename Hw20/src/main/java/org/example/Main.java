package org.example;

public class Main {
    public static void main(String[] args) throws graphException {
        Graph graph= new Graph();
        graph.addVertex(1);
        graph.addVertex(2);
        graph.addEdge(1, 2);
        System.out.println(graph.hasVertex(1));
        System.out.println(graph.hasVertex(2));
        System.out.println(graph.hasEdge(1, 2));
        graph.removeVertex(1);
        System.out.println(graph.hasVertex(1));
        System.out.println(graph.hasEdge(1, 3));

    }
}