package simulado;

import lombok.Data;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

@Data
public class Vertex<T> {

    private final T data;
    private boolean visited;
    private List<Neighbor<T>> neighbors = new LinkedList<>();

    public void addNeighbor(Vertex<T> vertex, Edge edge) {
        neighbors.add(new Neighbor<>(vertex, edge));
    }

    @Override
    public String toString() {
        return "Vertex " + data + " -> " + neighbors.stream()
                .filter(n -> n.getVertex().isVisited() && n.getEdge().isIncluded())
                .map(n -> n.getVertex().getData() + "|" + n.getEdge().getWeight())
                .collect(Collectors.joining(" - "));
    }
}
