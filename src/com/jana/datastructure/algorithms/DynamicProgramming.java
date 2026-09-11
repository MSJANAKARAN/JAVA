package com.jana.datastructure.algorithms;

import java.util.Arrays;

public class DynamicProgramming {

	public static void main(String[] args) {
//		Optimal answer + repeated subproblems + choices
//		Think: Can I reuse previous answers?

//		Climbing Stairs
//      You can climb 1 or 2 steps.
		int n = 5;
		int[] dp = new int[n + 1];
		Arrays.fill(dp, -1);
		System.out.println(climbingStairsTD(n, dp));
		System.out.println(climbingStairsBU(n));

//		House Robber
//		Cannot rob adjacent houses.
		int[] arr = { 1, 2, 4, 6, 5 };
		System.out.println("House Robber: " + houseRobber(arr));

//		Unique Paths with Obstacles
		int[][] grid = new int[][] { { 1, 1, 1 }, { 1, 1, 1 }, { 0, 1, 1 } };

		System.out.println("Unique Paths with Obstacles: " + getPaths(grid));

	}

	static int climbingStairsTD(int n, int[] dp) {
		if (n == 0 || n == 1)
			return 1;

		if (dp[n] != -1)
			return dp[n];

		return dp[n] = climbingStairsTD(n - 1, dp) + climbingStairsTD(n - 2, dp);
	}

	static int climbingStairsBU(int n) {
		int[] dp = new int[n + 1];
		dp[0] = 1;
		dp[1] = 1;

		for (int i = 2; i <= n; i++) {
			dp[i] = dp[i - 1] + dp[i - 2];
		}
		return dp[n];
////		Space optimized solution to store values of last two states 
//        int prev1 = 1;
//        int prev2 = 1;
//  
//        for (int i = 2; i <= n; i++) {
//            int curr = prev1 + prev2;
//            prev2 = prev1;
//            prev1 = curr;
//        }
////        In last iteration final value of curr is stored in prev.
//        return prev1;
	}

	static int houseRobber(int[] arr) {

		int prev2 = 0;
		int prev1 = 0;

		for (int money : arr) {
			int current = Math.max(prev1, prev2 + money);
			prev2 = prev1;
			prev1 = current;
		}
		return prev1;
	}

	static int getPaths(int[][] grid) {
		int m = grid.length;
		int n = grid[0].length;

		int[][] dp = new int[m][n];
		if (grid[0][0] == 1) {
			return 0;
		}

		dp[0][0] = 1;
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (grid[i][j] == 1) {
					dp[i][j] = 0;
					continue;
				}

				if (i > 0) {
					dp[i][j] += dp[i - 1][j];
				}
				if (j > 0) {
					dp[i][j] += dp[i][j - 1];
				}
//				Literally dp[i][j] = dp[i-1][j] + dp[i][j-1], only to handle i or j when 0
			}
		}
		return dp[m - 1][n - 1];
	}
}
