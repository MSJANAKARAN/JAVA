package com.jana.datastructure.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class DepthFirstSearch {

	private static ArrayList<Integer> dfsConnected(ArrayList<ArrayList<Integer>> graph) {

		ArrayList<Integer> res = new ArrayList<>();
		boolean visited[] = new boolean[graph.size()];

		dfsRecursive(graph, 0, visited, res);
		return res;
	}

	private static void dfsRecursive(ArrayList<ArrayList<Integer>> graph, int i, boolean[] visited,
			ArrayList<Integer> res) {
		visited[i] = true;
		res.add(i);
		for (int x : graph.get(i)) {
			if (!visited[x]) {
				dfsRecursive(graph, x, visited, res);
			}
		}
	}

	private static ArrayList<Integer> dfsDisconnected(ArrayList<ArrayList<Integer>> graph) {
		ArrayList<Integer> res = new ArrayList<>();
		boolean visited[] = new boolean[graph.size()];
		for(int i=0;i<graph.size();i++) {
			if(!visited[i]) {
				dfsRecursive(graph, i, visited, res);
			}
		}
		return res;
	}

	private static void addEdge(ArrayList<ArrayList<Integer>> adj, int i, int j) {
		adj.get(i).add(j);
		adj.get(j).add(i);
	}

	public static void main(String[] args) {

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

		ArrayList<Integer> res = dfsConnected(connectedGraph);

		for (int i : res) {
			System.out.print(i + " ");
		}
		System.out.println();
		addEdge(disconnectedGraph, 1, 2);
		addEdge(disconnectedGraph, 5, 0);
		addEdge(disconnectedGraph, 2, 4);
		addEdge(disconnectedGraph, 3, 0);
		addEdge(disconnectedGraph, 3, 5);

		ArrayList<Integer> res1 = dfsDisconnected(disconnectedGraph);
		for (int i : res1) {
			System.out.print(i + " ");
		}
		System.out.println();
		
	}

}
