package com.jana.datastructure.graph;

import java.util.ArrayList;

public class AdjacencyListRepresentation {

	private static ArrayList<ArrayList<Integer>> createUndirectedGraph(int V, int[][] edges) {

		ArrayList<ArrayList<Integer>> mat = new ArrayList<>();

		for (int i = 0; i < V; i++) {
			mat.add(new ArrayList<>());
		}
		for (int[] it : edges) {
			int u = it[0];
			int v = it[1];

			mat.get(u).add(v);
			mat.get(v).add(u);

		}
		return mat;
	}

	private static ArrayList<ArrayList<Integer>> createDirectedGraph(int V, int[][] edges) {

		ArrayList<ArrayList<Integer>> mat = new ArrayList<>();

		for (int i = 0; i < V; i++) {
			mat.add(new ArrayList<>());
		}
		for (int[] it : edges) {
			int u = it[0];
			int v = it[1];

			mat.get(u).add(v);

		}
		return mat;
	}

	public static void main(String[] args) {

		int V = 4;
		int[][] edges = { { 0, 3 }, { 0, 1 }, { 1, 2 }, { 0, 2 } };
//		1 - 2
//		| /
//		0 - 3

		ArrayList<ArrayList<Integer>> mat1 = createUndirectedGraph(V, edges);

		System.out.println("Adjacency List Representation Undirected:");

		for (int i = 0; i < V; i++) {
			System.out.print(i + " ");

			for (int j : mat1.get(i)) {
				System.out.print(j + " ");
			}
			System.out.println();
		}

		ArrayList<ArrayList<Integer>> mat2 = createDirectedGraph(V, edges);

		System.out.println("Adjacency List Representation Directed:");

		for (int i = 0; i < V; i++) {
			System.out.print(i + " ");

			for (int j =0;j<mat2.get(i).size();j++) {
				System.out.print(mat2.get(i).get(j) + " ");
			}
			System.out.println();
		}
	}

}
