package com.jana.datastructure.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.TreeSet;

public class DijkstrasAlgorithm {

	public static void main(String[] args) {
//		 It finds the shortest path from a single source node to all other nodes in a 
//		 weighted graph with non-negative edge weights using a greedy approach.
//		 A priority queue (min-heap) ensures you always extract the node with the absolute shortest tentative distance first.
//		Time Complexity: O((V+E)*logV), Where E is the number of edges and V is the number of vertices.
//		Auxiliary Space: O(V+E)
		int V = 5;
		int src = 0;

//		While an ArrayList cannot hold raw primitives (like int), it can hold arrays of primitives (like int[]). This is because in Java, 
//		all arrays are treated as objects on the heap, making them perfectly legal to use inside generic collections.
		ArrayList<ArrayList<int[]>> adj = new ArrayList<>();

		for (int i = 0; i < V; i++) {
			adj.add(new ArrayList<>());
		}
		addEdge(adj, 0, 1, 4);
		addEdge(adj, 0, 2, 8);
		addEdge(adj, 1, 4, 6);
		addEdge(adj, 1, 2, 3);
		addEdge(adj, 2, 3, 2);
		addEdge(adj, 3, 4, 10);

		ArrayList<Integer> result = dijkstra(adj, src);

		for (int i : result) {
			System.out.print(i + " ");
		}
		System.out.println();

	}

	private static ArrayList<Integer> dijkstra(ArrayList<ArrayList<int[]>> adj, int src) {
		int V = adj.size();

//		Min-heap (priority queue) storing pairs of (distance, node)
		PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);

//		Distance array: stores shortest distance from source
		int[] dist = new int[V];
		Arrays.fill(dist, Integer.MAX_VALUE);

//		Distance from source to itself is 0
		dist[src] = 0;
		  // Add source: [distance, node_id]
		pq.offer(new int[] { dist[src], src });

		while (!pq.isEmpty()) {
			int[] top = pq.poll();

			int d = top[0];
			int i = top[1];

			if (d > dist[i]) {
				continue;
			}

			for (int[] p : adj.get(i)) {
				int j = p[0];
				int weight = p[1];
				// If we found a shorter path to j through i, update it

				if (dist[i] + weight < dist[j]) {
					dist[j] = dist[i] + weight;
					pq.offer(new int[] { dist[j], j });
				}
			}

		}
//		Using TreeSet
//	    int[] distances = new int[V];
//        Arrays.fill(distances, Integer.MAX_VALUE);
//        distances[src] = 0;
//
//        // TreeSet behaving as a Priority Queue with unique elements (While Priority Queue Impl has duplicates)
//		  // In a PriorityQueue, if two different nodes have the exact same distance, it doesn't care—it stores both.
//		  // In a TreeSet, if your comparator returns 0, it assumes the elements are identical and will delete or block one of them. 
//		  // If Node 2 and Node 3 both have a distance of 5, a naive comparator like (a, b) -> Integer.compare(a[1], b[1]) will cause one node to disappear completely!
//        TreeSet<int[]> treeVertices = new TreeSet<>((a, b) -> {
//            if (a[1] != b[1]) return Integer.compare(a[1], b[1]);
//            return Integer.compare(a[0], b[0]);
//        });
//
//        // Add source: [node_id, distance]
//        treeVertices.add(new int[]{src, 0});
//
//        while (!treeVertices.isEmpty()) {
//            // Poll First extracts and removes the minimum element
//            int[] current = treeVertices.pollFirst();
//            int currentNode = current[0];
//            int currentDist = current[1];
//
//            // Traverse neighbors from your ArrayList<ArrayList<int[]>> structure
//            for (int[] edge : adj.get(currentNode)) {
//                int neighbor = edge[0];
//                int weight = edge[1];
//
//                if (currentDist + weight < distances[neighbor]) {
//                    // True Decrease-Key: Remove old state from set if it exists
//                    if (distances[neighbor] != Integer.MAX_VALUE) {
//                        treeVertices.remove(new int[]{neighbor, distances[neighbor]});
//                    }
//
//                    // Update distance
//                    distances[neighbor] = currentDist + weight;
//
//                    // Insert the freshly optimized path state
//                    treeVertices.add(new int[]{neighbor, distances[neighbor]});
//                }
//            }
//        }
//        Interview Tip: In Java, PriorityQueue is usually preferred in practice. Even though it stores duplicates, its internal 
//		  array-based binary heap has much better cache locality and lower memory overhead than the node-pointer-heavy TreeSet (Red-Black Tree).
		ArrayList<Integer> result = new ArrayList<>();
		
		for(int d:dist) {
			result.add(d);
		}
		return result;
	}

	private static void addEdge(ArrayList<ArrayList<int[]>> adj, int i, int j, int weight) {

		adj.get(i).add(new int[] { j, weight });
		adj.get(j).add(new int[] { i, weight });

	}

}
