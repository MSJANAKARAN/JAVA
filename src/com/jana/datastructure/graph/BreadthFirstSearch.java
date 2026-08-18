package com.jana.datastructure.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BreadthFirstSearch {

	private static ArrayList<Integer> bfsConnected(ArrayList<ArrayList<Integer>> graph) {

		ArrayList<Integer> res = new ArrayList<>();
		boolean[] visited = new boolean[graph.size()];

		Queue<Integer> q = new LinkedList<>();
		int src = 0;
		visited[src] = true;
		q.add(src);
		while (!q.isEmpty()) {
			int node = q.poll();
			res.add(node);
//			for (int i = 0; i < graph.get(node).size(); i++) {
//				if (!visited[graph.get(node).get(i)]) {
//					visited[graph.get(node).get(i)] = true;
//					q.add(graph.get(node).get(i));
//				}
//			}

			for (int i : graph.get(node)) {
				if (!visited[i]) {
					visited[i] = true;
					q.add(i);
				}
			}
		}
		return res;
	}
	
	private static ArrayList<Integer> bfsDisconnected(ArrayList<ArrayList<Integer>> graph) {
		ArrayList<Integer> res = new ArrayList<>();
		boolean[] visited = new boolean[graph.size()];

		for(int i=0;i<graph.size();i++) {
			if(!visited[i]) {
				Queue<Integer> q = new LinkedList<>();
				q.add(i);
				visited[i]=true;
				while (!q.isEmpty()) {
					int node = q.poll();
					res.add(node);

					for (int x : graph.get(node)) {
						if (!visited[x]) {
							visited[x] = true;
							q.add(x);
						}
					}
				}
			}
		}
		return res;
	}

	private static void addEdge(ArrayList<ArrayList<Integer>> adj, int i, int j) {
		adj.get(i).add(j);
		adj.get(j).add(i);
	}

	public static void main(String[] args) {
//		Breadth First Search (BFS) is a graph traversal algorithm that starts from a source node 
//		and explores the graph level by level. First, it visits all nodes directly adjacent to the source. 
//		Then, it moves on to visit the adjacent nodes of those nodes, and 
//		this process continues until all reachable nodes are visited.

//		Popular graph algorithms like Dijkstra's shortest path, Kahn's Algorithm, and Prim's algorithm are based on BFS.

		int V = 6;
		ArrayList<ArrayList<Integer>> connectedGraph = new ArrayList<>();
		ArrayList<ArrayList<Integer>> disconnectedGraph = new ArrayList<>();

		for (int i = 0; i < V; i++) {
			connectedGraph.add(new ArrayList<>());
			disconnectedGraph.add(new ArrayList<>());
		}

		addEdge(connectedGraph, 0, 1);
		addEdge(connectedGraph, 0, 2);
		addEdge(connectedGraph, 1, 3);
		addEdge(connectedGraph, 2, 4);
		addEdge(connectedGraph, 4, 5);
		addEdge(connectedGraph, 3, 5);

		ArrayList<Integer> res = bfsConnected(connectedGraph);

		for (int i : res) {
			System.out.print(i + " ");
		}
		System.out.println();
		addEdge(disconnectedGraph, 1, 2);
		addEdge(disconnectedGraph, 5, 0);
		addEdge(disconnectedGraph, 2, 4);
		addEdge(disconnectedGraph, 3, 0);
		addEdge(disconnectedGraph, 3, 5);

		ArrayList<Integer> res1 = bfsDisconnected(disconnectedGraph);
		for (int i : res1) {
			System.out.print(i + " ");
		}
		System.out.println();

	}
	

}
