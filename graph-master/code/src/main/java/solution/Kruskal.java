package solution;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.Stack;

/**
 * An implementation of minimum spanning tree with Prim's algorithm
 * using adjacency list graph representation based on the demo
 * and pseudo-code you've seen in class (on slides).
 */
public class Kruskal {

  public static int totalWeight; //sum of weights in Minimum Spanning Tree
  public static char[][] spanEdgeSet; //char array representing edges in Minimum Spanning Tree

  public static void main(String[] args) {
    char[] vertices = new char[]{'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M'};

    char[][] edges = new char[][]{
        {'A', 'B'}, {'B', 'C'}, {'B', 'G'}, {'C', 'E'}, {'C', 'H'}, {'C', 'L'},
        {'D', 'C'}, {'D', 'F'}, {'E', 'I'}, {'F', 'E'}, {'F', 'J'}, {'F', 'M'},
        {'G', 'D'}, {'H', 'F'}, {'I', 'J'}, {'I', 'M'}, {'K', 'H'}, {'L', 'K'},
        {'L', 'M'}, {'M', 'J'}
    };

    int[] weights = new int[]{
        2, 4, 1, 10, 1, 5,
        1, 6, 3, 2, 4, 15,
        2, 1, 3, 2, 3, 2,
        2, 1
    };
    MST(vertices, edges, weights);

  }

  /**
   * DFS method for checking cycle
   * Check if adding an edge (v-w) creates a cycle
   * using DFS on spanEdgeSet (the set of edges T in the MST so far)
   * starting at v and check if w is reachable.
   *
   * @param incidentV character array with the two vertices of edge being evaluated
   * @return true if adding edge creates cycle, false otherwise.
   */
  private static boolean checkCycle(char[] incidentV) {
    //DONE
    char curVertex = incidentV[0];
    Set<Character> v = new HashSet<>(); //set representing vertices currently spanned by MST
    for (int i = 0; i < spanEdgeSet.length; i++) {
      v.add(spanEdgeSet[i][0]);
      v.add(spanEdgeSet[i][1]);
    }
    char[] spanVertices = new char[v.size()];
    int i = 0;
    for (Character c : v) {
      spanVertices[i] = c; //copy values in set into char array
      i = i + 1;
    }
    //generate adjacency lists for each vertex in the current MST
    Map<Character, List<Character>> outgoing = genAdjacencyMap(spanVertices, spanEdgeSet);
    Set<Character> explored = new HashSet<>();
    Stack<Character> auxiliaryStack = new Stack<>();

    auxiliaryStack.push(curVertex);
    explored.add(curVertex);

    while (!auxiliaryStack.isEmpty()) {
      curVertex = auxiliaryStack.pop();
      if (outgoing.get(curVertex) != null) {
        for (Character c : outgoing.get(curVertex)) {
          if (c == incidentV[1]) {
            return true;
          } else if (!explored.contains(c)) {
            auxiliaryStack.push(c);
            explored.add(c);
          }
        }
      }
    }
    return false;
  }

  /**
   * Minimum Spanning Tree (MST)
   * Add edges to spanEdgeSet, a set of edges that spans the graph with minimum weights.
   * Sum the weights of edges in the minimum spanning tree in the totalWeight variable.
   *
   * @param vertices an array of characters representing each vertex.
   * @param edges    a M-by-2 array of characters.
   *                 Each row represents a directed edge by indicating its
   *                 endpoints (in the first and second columns, respectively).
   * @param weights  an array of integers representing the weights of each edge.
   */
  public static void MST(char[] vertices, char[][] edges, int[] weights) {

    spanEdgeSet = new char[vertices.length - 1][2];
    totalWeight = 0;

    //DONE

    //priority queue with edges in graph, highest priority given to edges with minimum weight
    PriorityQueue<CompEdge> pq = new PriorityQueue<>();
    //add edges to the priority queue
    for (int i = 0; i < edges.length; i++) {
      pq.add(new CompEdge(edges[i][0], edges[i][1], weights[i]));
    }

    int numEdgeFound = 0; //number of edges added to MST
    while (numEdgeFound < vertices.length - 1) {
      // get the edge with the minimum weight in pq
      CompEdge removedEdge = pq.remove();
      char[] incidentV = removedEdge.getVertices();

      if (!checkCycle(incidentV)) { //if cycle is not formed, add edge to MST
        spanEdgeSet[numEdgeFound] = incidentV; //add pair of vertices (edge) to spanEdgeSet (the char array representing edges in MST)
        totalWeight += removedEdge.getWeight();
        numEdgeFound = numEdgeFound + 1;
      }
    }

  }

  // Adjacency list representation of Graph
  private static Map<Character, List<Character>> genAdjacencyMap(char[] vertices, char[][] edges) {
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

    //convert to mapping any vertex to the LIST of outgoing vertices from the original vertex
    Map<Character, List<Character>> outgoingFinal = new HashMap<>();
    for (char key : outgoing.keySet()) {
      List<Character> list = new ArrayList<Character>(outgoing.get(key));
      outgoingFinal.put(key, list);
    }

    return outgoingFinal;
  }

  /**
   * An implementation of edge object that is comparable based on its
   * weight. Allows for comparison of elements in Priority Queue.
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
