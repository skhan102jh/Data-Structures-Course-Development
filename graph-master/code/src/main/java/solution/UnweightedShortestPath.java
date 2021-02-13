package solution;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * An implementation of unweighted shortest path using
 * adjacency list graph representation based on the demo
 * and pseudo-code you've seen in class (on slides).
 */

public class UnweightedShortestPath {

  /**
   * Unweighted Shortest Path (modified BFS).
   *
   * @param vertices  an array of characters representing each vertex.
   * @param edges     a M-by-2 array of characters.
   *                  Each row represents a directed edge by indicating its
   *                  endpoints (in the first and second columns, respectively).
   * @param initialVertex a character indicating the vertex to initiate the
   *                      shortest path algorithm with
   * @return a map that maps any vertex to its previous vertex on the shortest
   *         path from the initialVertex.
   */
  private static Map<Character, Character> findAllPath(
          char[] vertices, char[][] edges, char initialVertex) {
    Map<Character, Set<Character>> outgoing = genAdjacencyMap(vertices, edges);

    // maps any vertex to the boolean determining if it is explored or not
    Map<Character, Boolean> visited = new HashMap<>();

    // maps any vertex to its previous vertex
    // on the shortest path from the initialVertex.

    // output
    Map<Character, Character> prevVertices = new HashMap<>();

    for (char vertex : vertices) {
      // initializing each vertex in visited and prevVertices
      visited.put(vertex, false);
      prevVertices.put(vertex, null);
    }

    //DONE
    // holds all vertices that can be explored next
    // acts as a queue
    List<Character> visitNext = new ArrayList<>();

    char curVertex = initialVertex;
    visitNext.add(curVertex);
    visited.put(curVertex, true);

    // continue loop if visitNext is not empty
    while (!visitNext.isEmpty()) {

      // obtain and remove the first element
      curVertex = visitNext.remove(0);

      // Add all adjacent neighboring vertices if not already explored
      for (char vertex : outgoing.get(curVertex)) {
        if (!visited.get(vertex)) {
          // vertex can be visited next
          visitNext.add(vertex);
          // mark vertex as visited
          visited.put(vertex, true);
          // establish the linkage from curVertex and vertex
          prevVertices.put(vertex, curVertex);
        }
      }
    }


    return prevVertices;
  }

  // Adjacency list representation of Graph
  private static Map<Character, Set<Character>> genAdjacencyMap(
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
    }

    return outgoing;
  }

  // Generate Path based on the prevVertices map and the inquiryVertex
  private static List<Character> genPath(
          Map<Character, Character> prevVertices, char inquiryVertex) {
    //keeps track of vertices on the shortest path
    // from the initial vertex to the inquiry vertex

    //output
    List<Character> path = new ArrayList<>();

    Character curVertex = inquiryVertex;

    while (curVertex != null) {
      path.add(0, curVertex);
      curVertex = prevVertices.get(curVertex);
    }

    return path;
  }

  /**
   * verify the implementation.
   * @param vertices     a list of vertices
   * @param initVertex   a character, initial vertex of the path
   * @param keyPath      a map, maps character to solution string
   * @param prevVertices map containing the shortest map
   * @return boolean determining if the implementation is correct
   */
  public static boolean verify(char[] vertices,
                               char initVertex,
                               Map<Character, String> keyPath,
                               Map<Character, Character> prevVertices) {

    boolean correctOverall = true;
    for (char vertex : vertices) {
      if (vertex != initVertex) {
        String studentPath =
                UnweightedShortestPath.genPath(prevVertices, vertex).toString();

        System.out.println(
                "Student path from A to " + vertex + ": " + studentPath);
        System.out.println(
                "Key path from A to " + vertex + ":     "
                        + keyPath.get(vertex));

        if (!studentPath.equals(keyPath.get(vertex))) {
          System.out.println("Inconsistent with the key.");
          correctOverall = false;
        }
        System.out.println();
      }
    }

    return correctOverall;
  }

  /**
   * generate the correct shortest unweighted path from A.
   * @return keyPath that maps characters to correct solutions
   */
  public static Map<Character, String> getKeyPath() {
    Map<Character, String> keyPath = new HashMap<>();
    keyPath.put('B', "[A, B]");
    keyPath.put('C', "[A, B, C]");
    keyPath.put('D', "[A, B, G, D]");
    keyPath.put('E', "[A, B, C, E]");
    keyPath.put('F', "[A, B, C, H, F]");
    keyPath.put('G', "[A, B, G]");
    keyPath.put('H', "[A, B, C, H]");
    keyPath.put('I', "[A, B, C, E, I]");
    keyPath.put('J', "[A, B, C, E, I, J]");
    keyPath.put('K', "[A, B, C, L, K]");
    keyPath.put('L', "[A, B, C, L]");
    keyPath.put('M', "[A, B, C, L, M]");

    return keyPath;
  }


  /**
   * A demo program that replicates a worksheet exercise.
   *
   * @param args command-line arguments - not used here.
   */
  public static void main(String[] args) {
    char[] vertices = new char[]
        {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M'};
    char[][] edges = new char[][]{
        {'A', 'B'}, {'B', 'C'}, {'B', 'G'}, {'C', 'E'}, {'C', 'H'}, {'C', 'L'},
        {'D', 'C'}, {'D', 'F'}, {'E', 'I'}, {'F', 'E'}, {'F', 'J'}, {'F', 'M'},
        {'G', 'D'}, {'H', 'F'}, {'I', 'J'}, {'I', 'M'}, {'K', 'H'}, {'L', 'K'},
        {'L', 'M'}, {'M', 'J'}
    };

    char initVertex = 'A';

    System.out.println("\n=====Unweighted Shortest Path=====");

    Map<Character, Character> prevVertices =
            UnweightedShortestPath.findAllPath(vertices, edges, initVertex);

    if (verify(vertices, initVertex, getKeyPath(), prevVertices)) {
      System.out.println("Unweighted Shortest Path implementation is correct!");
    } else {
      System.out.println("Unweighted Shortest Path test failed.");
    }
    System.out.println();
  }
}
