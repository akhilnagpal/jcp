package algos.graphs.bfs;

import java.util.Iterator;
import java.util.LinkedList;
// Reference
// https://www.geeksforgeeks.org/find-if-there-is-a-path-between-two-vertices-in-a-given-graph/
// https://hackernoon.com/graphs-in-cs-and-its-traversal-algorithms-cfee5533f74e
// https://stackabuse.com/graphs-in-java-breadth-first-search-bfs/
// Below algorithm just checks if the two nodes are connected in a directed acyclic graph
// It uses principle of recursion and ensures nodes are not visited twice.

public class DFS {
  // Directed Graph is a function of pair of sets holding numberOfVertices and directed edges
  private int numberOfVertices;
  private LinkedList<Integer>[] adjustancyList;

  @SuppressWarnings("unchecked")
public DFS(int numberOfVertices) {
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
    visited[sourceVertice] = true;

    Iterator<Integer> adjustancyListIterator = adjustancyList[sourceVertice].iterator();
    while (adjustancyListIterator.hasNext()) {
      int destinationNode = adjustancyListIterator.next();
      if (destinationNode == destinationVertice) {
        return true;
      }
      if (!visited[destinationNode]) {
        // Only recurse if node not all already visited
        boolean checkNode = isReachable(sourceVertice, destinationNode);
        if (checkNode) {
          return true;
        }
      }
    }
    return false;
  }

  public static void main(String[] args) {
    // Create a graph given in the above diagram
    // Use paper pencil to visualize
    DFS bfsGraph = new DFS(4);
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
      System.out.println("There is no path from " + u + " to " + v);

    u = 3;
    v = 1;
    if (bfsGraph.isReachable(u, v))
      System.out.println("There is a path from " + u + " to " + v);
    else
      System.out.println("There is no path from " + u + " to " + v);

  }
}
