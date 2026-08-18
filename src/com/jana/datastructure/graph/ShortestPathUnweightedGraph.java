package com.jana.datastructure.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ShortestPathUnweightedGraph {

	private static void printShortestDistance(List<List<Integer>> graph, int S, int D, int V) {
		List<Integer> parent = new ArrayList<>(Collections.nCopies(V, -1));

		// dist[] array stores the distance of nodes from S
		List<Integer> distance = new ArrayList<>(Collections.nCopies(V, Integer.MAX_VALUE));

		// Function call to find the distance of all nodes and their parent nodes
		bfs(graph, S, distance, parent);

		if (distance.get(D) == Integer.MAX_VALUE) {
			System.out.println("Source and Destination are not connected");
			return;
		}
		// List path stores the shortest path
		List<Integer> path = new ArrayList<>();
		int currNode = D;
		path.add(D);
		while (parent.get(currNode) != -1) {
			path.add(parent.get(currNode));
			currNode = parent.get(currNode);
		}

		// Printing path from source to destination in reverse
		System.out.print("\nOutput: ");
		for (int i = path.size() - 1; i >= 0; i--) {
			System.out.print(path.get(i) + " ");
		}
	}

	private static void bfs(List<List<Integer>> graph, int S, List<Integer> distance, List<Integer> parent) {

		Queue<Integer> q = new LinkedList<>();
		// Mark the distance of the source node as 0
		distance.set(S, 0);

		q.add(S);

		while (!q.isEmpty()) {
			int curr = q.poll();
			for (int x : graph.get(curr)) {
				// Check if the neighboring node is not visited
				if (distance.get(x) == Integer.MAX_VALUE) {
					// Mark the current node as the parent of the neighboring node
					parent.set(x, curr);
					// Mark the distance of the neighboring node as the distance of the current
					// node + 1
					distance.set(x, distance.get(curr) + 1);
					q.add(x);
				}
			}
		}
		for (int d = 0; d < distance.size(); d++) {
			System.out.print(d + "->" + distance.get(d) + " ");
		}
	}

	public static void main(String[] args) {

		int V = 8;
		int S = 2, D = 7;

		List<List<Integer>> edges = Arrays.asList(Arrays.asList(0, 1), Arrays.asList(1, 2), Arrays.asList(0, 3),
				Arrays.asList(3, 4), Arrays.asList(4, 7), Arrays.asList(3, 7), Arrays.asList(5, 7), Arrays.asList(4, 5),
				Arrays.asList(4, 6), Arrays.asList(5, 6));

		List<List<Integer>> graph = new ArrayList<>(V);
		for (int i = 0; i < V; i++) {
			graph.add(new ArrayList<>());
		}

		for (List<Integer> edge : edges) {
			graph.get(edge.get(0)).add(edge.get(1));
			graph.get(edge.get(1)).add(edge.get(0));
		}

		printShortestDistance(graph, S, D, V);

	}

}
