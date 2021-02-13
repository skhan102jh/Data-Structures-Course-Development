package solution;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * An implementation of BFS and DFS using adjacency
 * matrix graph representation based on the demo
 * and pseudo-code you've seen in class (on slides).
 */

public class GraphSearch {

  /**
   * Breadth-first search of graph using adjacency matrix.
   *
   * @param vertices        an N char array that holds the names of the vertices
   * @param adjacencyMatrix an N-by-N integer adjacency matrix
   *                        with a 1 to represent edges between (N) vertices
   * @param initialVertex   a character indicating the vertex to initiate the
   *                        search with
   * @return a list of vertices in order according to BFS
   */
  private static List<Character> bfs(char[] vertices,
                                     int[][] adjacencyMatrix,
                                     char initialVertex) {
    // Add vertex characters to this list as search is being conducted.
    List<Character> visited = new ArrayList<>();

    // keep track of explored vertices
    boolean[] explored = new boolean[vertices.length];

    //DONE
    List<Integer> auxiliaryQueue = new ArrayList<>();  // behaves as a queue

    int curIndex = new String(vertices).indexOf(initialVertex); // initial index
    auxiliaryQueue.add(curIndex);
    visited.add(vertices[curIndex]);
    explored[curIndex] = true;

    while (!auxiliaryQueue.isEmpty()) {
      curIndex = auxiliaryQueue.remove(0);

      //Add all adjacent neighboring vertices if not already explored
      for (int i = 0; i < vertices.length; i++) {
        if (!explored[i] && adjacencyMatrix[curIndex][i] == 1) {
          auxiliaryQueue.add(i);
          visited.add(vertices[i]);
          explored[i] = true;
        }
      }
    }


    return visited;
  }

  /**
   * Depth-first search of graph using adjacency matrix.
   *
   * @param vertices        an N char array that holds the names of the vertices
   * @param adjacencyMatrix an N-by-N integer adjacency matrix
   *                        with a 1 to represent edges between (N) vertices
   * @param initialVertex   a character indicating the vertex to initiate the
   *                        search with
   * @return a list of vertices in order according to Dfs
   */
  private static List<Character> dfs(char[] vertices,
                                     int[][] adjacencyMatrix,
                                     char initialVertex) {
    // Add vertex characters to this list as search is being conducted.
    List<Character> visited = new ArrayList<>();

    // keep track of explored vertices
    boolean[] explored = new boolean[vertices.length];

    //DONE
    Stack<Integer> auxiliaryStack = new Stack<>();

    int curIndex = new String(vertices).indexOf(initialVertex); // initial index
    auxiliaryStack.push(curIndex);
    visited.add(vertices[curIndex]);
    explored[curIndex] = true;

    while (!auxiliaryStack.isEmpty()) {
      curIndex = auxiliaryStack.pop();

      //Add all adjacent neighboring vertices if not already explored
      for (int i = 0; i < vertices.length; i++) {
        if (!explored[i] && adjacencyMatrix[curIndex][i] == 1) {
          auxiliaryStack.push(i);
          visited.add(vertices[i]);
          explored[i] = true;
        }
      }
    }


    return visited;
  }


  /** generate an N-by-N integer adjacency matrix.
   * @param vertices an array of characters representing each vertex.
   * @param edges    a M-by-2 array of characters.
   *                 Each row represents a directed edge by indicating its
   *                 endpoints (in the first and second columns, respectively).
   * @return an N-by-N integer adjacency matrix with a 1 or 0.
   */
  private static int[][] genAdjacencyMatrix(char[] vertices, char[][] edges) {
    int[][] adjacencyMatrix = new int[vertices.length][vertices.length];
    String verticesStr = new String(vertices);
    for (char[] edge : edges) {
      int firstEndpoint = verticesStr.indexOf(edge[0]);
      int secondEndpoint = verticesStr.indexOf(edge[1]);

      adjacencyMatrix[firstEndpoint][secondEndpoint] = 1;
    }
    return adjacencyMatrix;
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
   * A demo program that replicates a worksheet exercise.
   * Uses letters instead of numbers (i.e. 1=A, 2=B, etc.)
   *
   * @param args command-line arguments - not used here.
   */
  public static void main(String[] args) {
    char[] vertices = new char[]
        {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J'};

    char[][] edges = new char[][]{
        {'A', 'B'}, {'A', 'F'}, {'B', 'C'}, {'B', 'E'}, {'C', 'A'}, {'C', 'G'},
        {'C', 'H'}, {'D', 'B'}, {'D', 'I'}, {'E', 'C'}, {'E', 'F'}, {'E', 'D'},
        {'F', 'E'}, {'F', 'J'}, {'G', 'A'}, {'G', 'D'}, {'H', 'F'}, {'H', 'G'},
        {'H', 'J'}, {'I', 'G'}, {'J', 'I'}
    };

    int[][] adjacencyMatrix = genAdjacencyMatrix(vertices, edges);

    System.out.println("\n=====BFS=====");
    List<Character> visitedOrderBfs = bfs(vertices, adjacencyMatrix, 'A');
    verify("[A, B, F, C, E, J, G, H, D, I]", visitedOrderBfs.toString());

    System.out.println("\n=====DFS=====");
    List<Character> visitedOrderDfs = dfs(vertices, adjacencyMatrix, 'A');
    verify("[A, B, F, E, J, I, G, D, C, H]", visitedOrderDfs.toString());
  }
}



