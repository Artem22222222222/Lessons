package org.example;

import java.util.ArrayList;
import java.util.Objects;

public class Graph {
    private ArrayList<Node> peaks;
    public Graph(){
        peaks = new ArrayList<>();
    }
    public void addVertex(int vertex) throws graphException {
        if (!hasVertex(vertex)){
            peaks.add(new Node(vertex));
        }else {
            throw new graphException("vertex exist");
        }
    }
    public void addEdge(int source, int destination) throws graphException {
        if (!hasEdge(source, destination) && hasVertex(source) && hasVertex(destination)){
            peaks.stream().filter(x -> x.getName() == source).findFirst().get().getConnectedNodes()
                    .add(destination);
        }else if (!hasVertex(source) || !hasVertex(destination)){
            throw new graphException("vertex does`t exist");
        }else {
            throw new graphException("edge exist");
        }
    }
    public void removeVertex(int vertex) throws graphException {
        if (hasVertex(vertex)) {
            peaks.stream().peek(x -> {
                x.getConnectedNodes().stream().peek(a -> {
                    if (a == vertex){
                        x.getConnectedNodes().remove(a);
                    }
                });
            });
            peaks.remove(peaks.stream().filter(x -> x.getName() == vertex).findFirst().get());
        } else {
            throw new graphException("vertex does`t exist");
        }
    }
    public boolean hasVertex(int vertex){
        return peaks.stream().anyMatch(x-> x.getName()==vertex);
    }
    public boolean hasEdge(int source, int destination){
        return peaks.stream().anyMatch(x-> {
            return x.getConnectedNodes().stream().anyMatch(b->b == destination) && x.getName()==source ||
            x.getConnectedNodes().stream().anyMatch(a->a == source) && x.getName()==destination;
        });
    }
}
class Node {
    private int name;
    private ArrayList<Integer> connectedNodes;

    public Node(int name) {
        this.name = name;
        connectedNodes = new ArrayList<>();
    }

    public int getName() {
        return name;
    }

    public ArrayList<Integer> getConnectedNodes() {
        return connectedNodes;
    }

    public void setConnectedNodes(ArrayList<Integer> connectedNodes) {
        this.connectedNodes = connectedNodes;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Node node = (Node) o;
        return getName() == node.getName();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getConnectedNodes());
    }
}
