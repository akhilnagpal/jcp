package application.findallpaths.bloomberg;

/**
* Given a directed graph, a source vertex ‘s’ and a destination vertex ‘d’, print all paths from given ‘s’ to ‘d’. 
**/
/* package whatever; // don't place package name! */

/* package whatever; // don't place package name! */

import java.util.*;

/* Name of the class has to be "Main" only if the class is public. */
public class Graph
{	private int vNumber;
	private ArrayList[] adj; 
	
	public Graph(int V){
		this.vNumber = V;
		adj = new ArrayList[V];
		for(int i=0; i<V; i++)
			adj[i] = new ArrayList<Integer>();
	}
	
	public void addEdge(int v, int w){
		adj[v].add(w);
	}
	
//	public void DFSUtil(int v, Boolean[] visited){
//		visited[v] = true;
//		System.out.println(v+" ");
//		
//		ArrayList<Integer> list = adj[v];
//		for(Integer i: list){
//			if(!visited[i])
//				DFSUtil(i,visited);
//		}
//	}
//	
//	public void DFS(int v){
//		Boolean[] visited = new Boolean[vNumber];
//		for(int i=0; i<vNumber; i++)
//			visited[i] = false;
//		
//		DFSUtil(v,visited);
//	}
	
	public void printPaths(int s, int d){
		Boolean[] visited = new Boolean[vNumber];
		int[] path = new int[vNumber];
		int path_index = 0;
		
		for(int i=0; i<vNumber; i++){
			visited[i] =false;
		}
		
		printPathsUtil(s,d,visited,path,path_index);
	}
	
	public void printPathsUtil(int s, int d, Boolean[] visited, int[] path, int path_index){
			visited[s] = true;
			path[path_index] = s;
			path_index++;
		
		if(s==d){
			for(int i=0; i<path_index; i++)
				System.out.print(path[i] + " ");
			System.out.println();
			
		}
		else{
			ArrayList<Integer> list = adj[s];
			for(Integer i: list){
				if(!visited[i])
					printPathsUtil(i,d,visited,path,path_index);
			}
		}
		
		path_index--;
		visited[s]=false;
	}
	public static void main (String[] args) throws java.lang.Exception
	{  
		Graph g = new Graph(4);
		g.addEdge(0, 1);
    	g.addEdge(0, 2);
    	g.addEdge(0, 3);
    	g.addEdge(2, 0);
    	g.addEdge(2, 1);
    	g.addEdge(1, 3);
 		
 		int s = 2, d = 3;
		System.out.println("Print all paths from " + s + " to " + d);
		g.printPaths(s,d);
	}
}
