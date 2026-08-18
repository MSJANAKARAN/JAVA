package com.jana.datastructure.graph;

import java.util.ArrayList;

public class TransposeGraph {

	private static int V = 5;

	@SuppressWarnings("unchecked")
	private static ArrayList<Integer>[] adj = new ArrayList[V];

	@SuppressWarnings("unchecked")
	private static ArrayList<Integer>[] trn = new ArrayList[V];

	public static void main(String[] args) {
//		Transpose of a directed graph G is another directed graph on the same set of vertices 
//		with all of the edges reversed compared to the orientation of the corresponding edges in G.

		for (int i = 0; i < V; i++) {
			adj[i] = new ArrayList<>();
			trn[i] = new ArrayList<>();

		}
		addedge(0, 1, false);
		addedge(0, 4, false);
		addedge(0, 3, false);
		addedge(2, 0, false);
		addedge(3, 2, false);
		addedge(4, 1, false);
		addedge(4, 3, false);
		printGraph(adj);
		getTranspose();
		System.out.println();
		printGraph(trn);

	}

	private static void addedge(int i, int j, boolean b) {

		if (!b) {
			adj[i].add(j);
		} else {
			trn[i].add(j);
		}
	}

	private static void printGraph(ArrayList<Integer>[] graph) {
		for (int i = 0; i < V; i++) {
			System.out.print(i + " -> ");
			for (int j : graph[i]) {
				System.out.print(j + " ");
			}
			System.out.println();
		}
	}

	private static void getTranspose() {

		for (int i = 0; i < V; i++) {
			for (int j : adj[i]) {
				addedge(j, i, true);
			}
		}
	}

}
