package solution;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

/**
 * An implementation of minimum spanning tree with Prim's algorithm
 * using adjacency list graph representation based on the demo
 * and pseudo-code you've seen in class (on slides).
 */
public class Prims {

  public static int totalWeight;
  public static char[][] spanEdgeSet;
  public static Map<Character, Boolean> explored;
  public static PriorityQueue<CompEdge> pqueue;
  public static char vertexToExplore;
  public static char nextVertex;

  /**
   * Minimum Spanning Tree.
   *
   * @param vertices an array of characters representing each vertex.
   * @param edges    a M-by-2 array of characters.
   *                 Each row represents a directed edge by indicating its
   *                 endpoints (in the first and second columns, respectively).
   * @param weights  an array of integers representing the weights of each edge.
   */
  public static void mst(char[] vertices, char[][] edges, int[] weights) {
    Map<Character, List<Character>> outgoing = genAdjacencyMap(vertices, edges);
    Map<Character, List<Integer>> outgoingWeights =
            genWeightMap(outgoing, edges, weights);
    spanEdgeSet = new char[vertices.length - 1][2];
    totalWeight = 0;

    //DONE
    // maps any vertex to its explored boolean
    explored = new HashMap<>();
    // stores all of the possible edges and keeps them sorted
    pqueue = new PriorityQueue<>();

    // initialize all vertices to be false
    for (char v : vertices) {
      explored.put(v, false);
    }

    // start with one vertex
    vertexToExplore = 'A';

    explored.put(vertexToExplore, true);
    for (int i = 0; i < outgoing.get(vertexToExplore).size(); i++) {
      nextVertex = outgoing.get(vertexToExplore).get(i);

      // add all edges that are adjacent to vertexToExplore to pqueue
      pqueue.add(new CompEdge(vertexToExplore, nextVertex,
              outgoingWeights.get(vertexToExplore).get(i)));
    }

    loopPrims(vertices, outgoing, outgoingWeights);
  }

  private static void loopPrims(char[] vertices,
                                Map<Character, List<Character>> outgoing,
                                Map<Character, List<Integer>> outgoingWeights) {
    int numEdgeFound = 0;

    while (numEdgeFound < vertices.length - 1) {
      // get the edge with the minimum weight in pqueue
      CompEdge removedEdge = pqueue.remove();
      char[] incidentVertices = removedEdge.getVertices();

      // is left vertex of the edge explored
      boolean exploredL = explored.get(incidentVertices[0]);
      // is right vertex of the edge explored
      boolean exploredR = explored.get(incidentVertices[1]);

      // XOR : only one vertex should be explored
      if (exploredL ^ exploredR) {
        // add the in
        spanEdgeSet[numEdgeFound] = incidentVertices;
        totalWeight += removedEdge.getWeight();
        numEdgeFound++;

        // find the vertex that has not been explored
        vertexToExplore = incidentVertices[exploredL ? 1 : 0];

        // explore this vertex
        explored.put(vertexToExplore, true);

        for (int i = 0; i < outgoing.get(vertexToExplore).size(); i++) {
          nextVertex = outgoing.get(vertexToExplore).get(i);
          // if nextVertex has not been explored yet
          if (!explored.get(nextVertex)) {
            pqueue.add(new CompEdge(vertexToExplore, nextVertex,
                    outgoingWeights.get(vertexToExplore).get(i)));
          }
        }
      }
    }
  }


  // Adjacency list representation of Graph
  private static Map<Character, List<Character>> genAdjacencyMap(
          char[] vertices, char[][] edges) {
    //maps any vertex to the set of outgoing vertices from the original vertex
    Map<Character, Set<Character>> outgoing = new HashMap<>();

    for (int i = 0; i < vertices.length; i++) {
      outgoing.put(vertices[i], new HashSet<>());
    }

    for (int i = 0; i < edges.length; i++) {
      char v = edges[i][0];
      char u = edges[i][1];
      outgoing.get(v).add(u);
      outgoing.get(u).add(v);
    }

    //convert to maping any vertex to the LIST of outgoing vertices 
    // from the original vertex
    Map<Character, List<Character>> outgoingFinal = new HashMap<>();
    for (char key : outgoing.keySet()) {
      List<Character> list = new ArrayList<Character>(outgoing.get(key));
      outgoingFinal.put(key, list);
    }

    return outgoingFinal;
  }

  // Helper method : finds the weight of a edge given its two vertices
  private static int getWeight(char firstVertex,
                               char secondVertex,
                               char[][] edges,
                               int[] weights) {
    int weight = 0;
    for (int i = 0; i < edges.length; i++) {
      char v = edges[i][0];
      char u = edges[i][1];

      if ((firstVertex == v && secondVertex == u)
              || (firstVertex == u && secondVertex == v)) {
        weight = weights[i];
        break;
      }
    }
    return weight;
  }

  // Adjacency list representation of Graph
  private static Map<Character, List<Integer>> genWeightMap(
          Map<Character, List<Character>> outgoing,
          char[][] edges, int[] weights) {

    //maps any vertex to the list of weights corresponding to 
    // the outgoing vertices from the original vertex
    Map<Character, List<Integer>> outgoingWeights = new HashMap<>();
    for (char key : outgoing.keySet()) {
      outgoingWeights.put(key, new ArrayList<>());
    }

    for (char key : outgoing.keySet()) {
      for (char target : outgoing.get(key)) {
        int weight = getWeight(key, target, edges, weights);
        outgoingWeights.get(key).add(weight);
      }
    }

    return outgoingWeights;
  }

  /**
   * An implementation of edge object that is comparable based on its
   * weight.
   */
  private static class CompEdge implements Comparable<CompEdge> {
    char[] vertices = new char[2];
    Integer weight;

    CompEdge(char firstVertex, char secondVertex, int w) {
      vertices[0] = firstVertex;
      vertices[1] = secondVertex;
      weight = w;
    }

    public char[] getVertices() {
      return this.vertices;
    }

    public Integer getWeight() {
      return this.weight;
    }

    @Override
    public int compareTo(CompEdge otherEdge) {
      // compare CompEdges by their weights
      return this.weight.compareTo(otherEdge.getWeight());
    }
  }

}
