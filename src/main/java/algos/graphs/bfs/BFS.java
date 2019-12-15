package algos.graphs.bfs;

import java.util.Iterator;
import java.util.LinkedList;

public class BFS {
  // Directed Graph is a function of pair of sets holding numberOfVertices and directed edges
  private int numberOfVertices;
  private LinkedList<Integer>[] adjustancyList;

  public BFS(int numberOfVertices) {
    this.numberOfVertices = numberOfVertices;
    adjustancyList = new LinkedList[numberOfVertices];
    for (int i = 0; i < numberOfVertices; i++) {
      adjustancyList[i] = new LinkedList<Integer>();
    }
  }

  public boolean addEdge(int vertice, int neighbour) {
    return adjustancyList[vertice].add(neighbour);
  }

  public boolean isReachable(int sourceVertice, int destinationVertice) {
    // We need to ensure vertices are not visited twice
    // Mark all the vertices as not visited(By default set as false)
    boolean[] visited = new boolean[numberOfVertices];
    // Create a queue for BFS
    LinkedList<Integer> bfsQueue = new LinkedList<Integer>();

    visited[sourceVertice] = true;
    bfsQueue.add(sourceVertice);

    Iterator<Integer> adjustancyListIterator;
    while (bfsQueue.size() != 0) {
      int node = bfsQueue.poll();
      adjustancyListIterator = adjustancyList[node].iterator();
      while (adjustancyListIterator.hasNext()) {
        int neighbourNode = adjustancyListIterator.next();
        if (destinationVertice == neighbourNode) {
          return true;
        }
        // Below step is important as we do not want re-visit the last Node again.
        // This could lead to infinite loop
        if (!visited[neighbourNode]) {
          visited[neighbourNode] = true;
          bfsQueue.add(neighbourNode);
        }

      }
    }

    return false;
  }

  public static void main(String args[]) {
    // Create a graph given in the above diagram
    // Use paper pencil to visualize
    BFS bfsGraph = new BFS(4);
    bfsGraph.addEdge(0, 1);
    bfsGraph.addEdge(0, 2);
    bfsGraph.addEdge(1, 2);
    bfsGraph.addEdge(2, 0);
    bfsGraph.addEdge(2, 3);
    bfsGraph.addEdge(3, 3);

    int u = 1;
    int v = 3;
    if (bfsGraph.isReachable(u, v))
      System.out.println("There is a path from " + u + " to " + v);
    else
      System.out.println("There is no path from " + u + " to " + v);;

    u = 3;
    v = 1;
    if (bfsGraph.isReachable(u, v))
      System.out.println("There is a path from " + u + " to " + v);
    else
      System.out.println("There is no path from " + u + " to " + v);;

  }
}
