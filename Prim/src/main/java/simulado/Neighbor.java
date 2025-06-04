package simulado;

import lombok.Data;

@Data
public class Neighbor<T> {

    private final Vertex<T> vertex;
    private final Edge edge;

    public boolean isVisited() {
        return edge.isIncluded() || vertex.isVisited();
    }
}
