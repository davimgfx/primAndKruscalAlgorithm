package simulado;

import java.util.Arrays;
import java.util.stream.Stream;

public class App {
    public static void main( String[] args ) {
        Vertex<String> vertexA = new Vertex<>("A");
        Vertex<String> vertexB = new Vertex<>("B");
        Vertex<String> vertexC = new Vertex<>("C");
        Vertex<String> vertexD = new Vertex<>("D");
        Vertex<String> vertexE = new Vertex<>("E");
        Vertex<String> vertexF = new Vertex<>("F");
        Vertex<String> vertexG = new Vertex<>("G");
        Vertex<String> vertexH = new Vertex<>("H");

        Edge edgeAB = new Edge(2);
        Edge edgeAC = new Edge(3);
        Edge edgeBD = new Edge(2);
        Edge edgeCD = new Edge(1);
        Edge edgeDE = new Edge(2);
        Edge edgeDF = new Edge(4);
        Edge edgeEF = new Edge(1);
        Edge edgeEG = new Edge(2);
        Edge edgeFG = new Edge(2);
        Edge edgeGH = new Edge(3);
        Edge edgeFH = new Edge(1);


        vertexA.addNeighbor(vertexB, edgeAB);
        vertexA.addNeighbor(vertexC, edgeAC);

        vertexB.addNeighbor(vertexA, edgeAB);
        vertexB.addNeighbor(vertexD, edgeBD);

        vertexC.addNeighbor(vertexA, edgeAC);
        vertexC.addNeighbor(vertexD, edgeCD);

        vertexD.addNeighbor(vertexB, edgeBD);
        vertexD.addNeighbor(vertexC, edgeCD);
        vertexD.addNeighbor(vertexE, edgeDE);
        vertexD.addNeighbor(vertexF, edgeDF);

        vertexE.addNeighbor(vertexD, edgeDE);
        vertexE.addNeighbor(vertexF, edgeEF);
        vertexE.addNeighbor(vertexG, edgeEG);

        vertexF.addNeighbor(vertexD, edgeDF);
        vertexF.addNeighbor(vertexE, edgeEF);
        vertexF.addNeighbor(vertexG, edgeFG);
        vertexF.addNeighbor(vertexH, edgeFH);

        vertexG.addNeighbor(vertexE, edgeEG);
        vertexG.addNeighbor(vertexF, edgeFG);
        vertexG.addNeighbor(vertexH, edgeGH);

        vertexH.addNeighbor(vertexF, edgeFH);
        vertexH.addNeighbor(vertexG, edgeGH);

        new Prim<>(Arrays.asList(vertexA, vertexB, vertexC, vertexD, vertexE, vertexF, vertexG, vertexH)).run();


        Integer minimum = Stream.of(
                        edgeAB, edgeAC, edgeBD, edgeCD, edgeDE, edgeDF,
                        edgeEF, edgeEG, edgeFG, edgeFH, edgeGH
                ).filter(Edge::isIncluded)
                .map(Edge::getWeight)
                .reduce(0, Integer::sum);
        System.out.println("Minimum Weight: " + minimum);

    }
}
