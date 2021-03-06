package solution;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class KruskalTest {

  private char[] vertices;
  private char[][] edges;
  private int[] weights;
  private char[][] keyMST;
  private int keyTotalWeight;

  @Before
  public void setup() {
    vertices = new char[]{'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M'};

    edges = new char[][]{
        {'A', 'B'}, {'B', 'C'}, {'B', 'G'}, {'C', 'E'}, {'C', 'H'}, {'C', 'L'},
        {'D', 'C'}, {'D', 'F'}, {'E', 'I'}, {'F', 'E'}, {'F', 'J'}, {'F', 'M'},
        {'G', 'D'}, {'H', 'F'}, {'I', 'J'}, {'I', 'M'}, {'K', 'H'}, {'L', 'K'},
        {'L', 'M'}, {'M', 'J'}
    };

    weights = new int[]{
        2, 4, 1, 10, 1, 5,
        1, 6, 3, 2, 4, 15,
        2, 1, 3, 2, 3, 2,
        2, 1
    };

        /*keyMST = new char[][]{
                {'A', 'B'}, {'B', 'G'}, {'G', 'D'}, {'D', 'C'}, {'C', 'H'}, {'H', 'F'},
                {'K', 'H'}, {'F', 'E'}, {'M', 'I'}, {'L', 'K'}, {'L', 'M'}, {'M', 'J'}
        };*/

    keyMST = new char[][]{
        {'B', 'G'}, {'C', 'H'}, {'M', 'J'}, {'D', 'C'}, {'H', 'F'}, {'L', 'M'},
        {'I', 'M'}, {'L', 'K'}, {'F', 'E'}, {'G', 'D'}, {'A', 'B'}, {'E', 'I'}
    };

    keyTotalWeight = 20;

    Kruskal.MST(vertices, edges, weights);
  }

  @Test
  public void test() {
    assertEquals(keyTotalWeight, Kruskal.totalWeight);
    assertEquals(vertices.length - 1, Kruskal.spanEdgeSet.length);

    boolean match;
    for (char[] keyEdge : keyMST) {

      match = false;
      for (char[] edge : Kruskal.spanEdgeSet) {
        if ((keyEdge[0] == edge[0] && keyEdge[1] == edge[1]) ||
            (keyEdge[0] == edge[1] && keyEdge[1] == edge[0])) {
          match = true;
          break;
        }
      }

      assertTrue(match);
    }
  }

}