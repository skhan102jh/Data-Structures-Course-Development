package starter;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

@SuppressWarnings("CheckStyle")
public class UnionFindTest {

  private UnionFind u;

  @Before
  public void setup() {
    u = new UnionFind(7);
  }

  @Test
  public void test() {

    assertEquals("[0, 1, 2, 3, 4, 5, 6]", u.toString());

    u.union(0, 5);

    assertEquals("[0, 1, 2, 3, 4, 0, 6]", u.toString());

    u.union(1, 4);

    assertEquals("[0, 1, 2, 3, 1, 0, 6]", u.toString());

    u.union(2, 3);

    assertEquals("[0, 1, 2, 2, 1, 0, 6]", u.toString());

    u.union(3, 6);      // Union-By-Size

    assertEquals("[0, 1, 2, 2, 1, 0, 2]", u.toString());

    u.union(4, 6);

    assertEquals("[0, 2, 2, 2, 1, 0, 2]", u.toString());

    u.union(0, 4);      // Path Compression

    assertEquals("[2, 2, 2, 2, 2, 0, 2]", u.toString());

  }

}
