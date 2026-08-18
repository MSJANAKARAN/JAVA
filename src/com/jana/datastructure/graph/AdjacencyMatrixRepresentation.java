package com.jana.datastructure.graph;

import java.util.ArrayList;

public class AdjacencyMatrixRepresentation {

	private static ArrayList<ArrayList<Integer>> createUndirectedGraph(int V, int[][] edges) {

		ArrayList<ArrayList<Integer>> mat = new ArrayList<>();

		for (int i = 0; i < V; i++) {
			ArrayList<Integer> arr = new ArrayList<>();
			for (int j = 0; j < V; j++) {
				arr.add(0);
			}
			mat.add(arr);
		}
		for (int[] it : edges) {
			int u = it[0];
			int v = it[1];
			mat.get(u).set(v, 1);
			// since the graph is undirected
			mat.get(v).set(u, 1);

		}
		return mat;
	}

	private static ArrayList<ArrayList<Integer>> createDirectedGraph(int V, int[][] edges) {

		ArrayList<ArrayList<Integer>> mat = new ArrayList<>();

		for (int i = 0; i < V; i++) {
			ArrayList<Integer> arr = new ArrayList<>();
			for (int j = 0; j < V; j++) {
				arr.add(0);
			}
			mat.add(arr);
		}
		for (int[] it : edges) {
			int u = it[0];
			int v = it[1];
			mat.get(u).set(v, 1);

		}
		return mat;
	}

	public static void main(String[] args) {
//		An adjacency matrix is a way of representing a graph as a boolean matrix of (0's and 1's).
//		Let's assume there are n vertices in the graph So, create a 2D matrix adjMat[n][n] having dimension n x n.
//		If there is an edge from vertex i to j, mark adjMat[i][j] as 1. 
//		If there is no edge from vertex i to j, mark adjMat[i][j] as 0.

		int V = 4;
		int[][] edges = { { 2, 1 }, { 1, 3 }, { 0, 3 }, { 2, 0 } };
//		2 - 1
//		|	|
//		0 -	3
		ArrayList<ArrayList<Integer>> mat1 = createUndirectedGraph(V, edges);

		System.out.println("Adjacency Matrix Representation Undirected:");

		for (int i = 0; i < V; i++) {
			for (int j = 0; j < V; j++) {
				System.out.print(mat1.get(i).get(j) + " ");
			}
			System.out.println();
		}

		ArrayList<ArrayList<Integer>> mat2 = createDirectedGraph(V, edges);

		System.out.println("Adjacency Matrix Representation Directed:");

		for (int i = 0; i < V; i++) {
			for (int j = 0; j < V; j++) {
				System.out.print(mat2.get(i).get(j) + " ");
			}
			System.out.println();
		}

	}

}
