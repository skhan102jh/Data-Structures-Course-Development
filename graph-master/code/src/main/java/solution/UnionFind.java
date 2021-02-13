package solution;


/**
 * An implementation of union-find data structure with
 * path compression and union-by-size based on the demo
 * and pseudo-code you've seen in class (on slides).
 */

public class UnionFind {
  public int numVertex;
  int[] root;
  int[] size;

  /**
   * UnionFind Constructor.
   * @param numV the integer number of vertices
   */
  public UnionFind(int numV) {
    numVertex = numV;
    root = new int[numV];
    size = new int[numV];

    //DONE: initialize arrays
    for (int i = 0; i < numV; i++) {
      root[i] = i;
      // size is used to keep track of the size of the subtree
      size[i] = 1;
    }

  }

  /**
   * Union operation: union the two subtrees the input vertices.
   * @param a first vertex in integer
   * @param b second vertex in integer
   */
  public void union(int a, int b) {
    //DONE: implement union with union-by-size
    int ap = find(a);
    int bp = find(b);
    // union-by-size

    // if ap is bigger than bp
    if (size[ap] >= size[bp]) {
      // assign ap as the root of bp
      root[bp] = ap;
      size[ap] += size[bp];   // add size of bp to the size of ap
      size[bp] = 0;           // set the size of bp to 0
    } else {
      // assign bp as the root of ap
      root[ap] = bp;
      size[bp] += size[ap];   // add size of ap to the size of bp
      size[ap] = 0;           // set the size of ap to 0
    }
  }

  /**
   * Find operation: find the root of the input vertex.
   * @param x the input vertex
   * @return the root of the input vertex
   */
  public int find(int x) {
    //DONE: implement find with path compression
    if (root[x] == x) {
      return x;
    }
    int myRoot = find(root[x]);

    // once you have the myRoot, the path compression occurs
    // in the second half of the recursion
    root[x] = myRoot;   // path compression
    return myRoot;
  }

  @Override
  public String toString() {
    String rootString = "[";
    for (int i = 0; i < root.length - 1; i++) {
      rootString = rootString + root[i] + ", ";
    }
    rootString = rootString + root[root.length - 1] + "]";
    return rootString;
  }

}


