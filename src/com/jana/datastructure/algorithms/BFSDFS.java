package com.jana.datastructure.algorithms;

public class BFSDFS {

	public static void main(String[] args) {

//		Tree / Graph / Grid / Connected components / shortest path
//		Binary Tree Traversal

//		Preorder  → Root Left Right
//		Inorder   → Left Root Right
//		Postorder → Left Right Root

//		Number of Islands
		char[][] grid = { { '1', '1', '0', '0', '0' }, { '1', '1', '0', '0', '0' }, { '0', '0', '1', '0', '0' },
				{ '0', '0', '0', '1', '1' } };
		System.out.println("Number of Islands: " + numIslands(grid));
		
//		BFS Shortest Path
//		For an unweighted graph:
//		com.jana.datastructure.graph.ShortestPathUnweightedGraph
	}

	static int numIslands(char[][] grid) {
		int count = 0;
		int m=grid.length;
		int n=grid[0].length;
		for(int i=0;i<m;i++) {
			for(int j=0;j<n;j++) {
				if(grid[i][j]=='1') {
					count++;
					dfsIsland(grid,i,j);
				}
			}
		}
		return count;
	}
	
	static void dfsIsland(char[][] grid,int i, int j) {
		if(i<0 || j<0 || i>=grid.length || j>=grid[0].length || grid[i][j]=='0') {
			return;
		}
		
		grid[i][j]='0';
		
		dfsIsland(grid,i+1,j);
		dfsIsland(grid,i-1,j);
		dfsIsland(grid,i,j+1);
		dfsIsland(grid,i,j-1);

	}
}
