package solution;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

/**
 * An implementation of topological sort using adjacency
 * list graph representation based on the demo
 * and pseudo-code you've seen in class (on slides).
 */

public class Topological {

  /**
   * Topological Sort.
   *
   * @param vertices an array of characters representing each vertex.
   * @param edges    a M-by-2 array of characters.
   *                 Each row represents a directed edge by indicating its
   *                 endpoints (in the first and second columns, respectively).
   * @return a list of vertices in (correct topological) order.
   */
  private static List<Character> sort(char[] vertices, char[][] edges) {
    Map<Character, Set<Character>> outgoing = genAdjacencyMap(vertices, edges);
    Map<Character, Integer> indegree = genInDegreeMap(vertices, edges);

    // holds all vertices with indegree 0
    Stack<Character> visitNext = new Stack<>();

    // add all vetices with indegree 0 into visitNext
    for (char vertex : vertices) {
      if (indegree.get(vertex) == 0) {
        visitNext.push(vertex);
      }
    }

    // This list will hold the vertices in (correct topological) order
    List<Character> sortedOrder = new ArrayList<>(); // output

    //DONE

    // continue untill visitNext becomes empty
    while (!visitNext.isEmpty()) {

      //pop one element of our visitNext and add it to sortedOrder
      char v = visitNext.pop();
      sortedOrder.add(v);

      //since v is removed, check all vertices that v points to
      for (char u : outgoing.get(v)) {
        // reduce u's indegree by 1 and update indegree map
        int newIndegree = indegree.get(u) - 1;
        indegree.put(u, newIndegree);
        // if the new indegree is 0, add it to visitNext
        if (newIndegree == 0) {
          visitNext.push(u);
        }
      }
    }

    return sortedOrder;
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

  // Compute and store each vertex's in-degree
  private static Map<Character, Integer> genInDegreeMap(
          char[] vertices, char[][] edges) {
    //maps any vertex to its indegree value
    Map<Character, Integer> indegree = new HashMap<>();

    for (int i = 0; i < vertices.length; i++) {
      indegree.put(vertices[i], 0);
    }

    for (int i = 0; i < edges.length; i++) {
      char v = edges[i][1];
      indegree.put(v, indegree.get(v) + 1);
    }

    return indegree;
  }

  /** compare the student's and key's solution.
   * @param key        a string that stores the key solution.
   * @param student    a string that stores the student solution.
   */
  public static void verify(String key, String student) {
    System.out.println("Student : " + student);
    System.out.println("Key     :     " + key);
    if (student.equals(key)) {
      System.out.println("Implementation is correct!");
    } else {
      System.out.println("Test failed.");
    }
  }

  /**
   * A demo program that verifies the implementation.
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

    System.out.println("\n=====Topological Sort=====");
    List<Character> sort = Topological.sort(vertices, edges);
    verify("[A, B, G, D, C, L, K, H, F, E, I, M, J]", sort.toString());
  }
}
