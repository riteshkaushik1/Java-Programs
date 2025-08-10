import java.util.Arrays;

public class knapsack2 {
    static int[][] memo;
    public static int knapsack(int[] wt, int[] val, int W, int n) {
        // Base case: If no items or weight is 0, max value is 0
        if (n == 0 || W == 0) {
            return 0;
        }

        // Check if the subproblem has already been solved
        if (memo[n][W] != -1) {
            return memo[n][W];
        }

        // If the weight of the nth item is less than or equal to the remaining capacity
        if (wt[n - 1] <= W) {
            // Store the maximum of including or excluding the nth item in the memo table
            memo[n][W] = Math.max(
                    val[n - 1] + knapsack(wt, val, W - wt[n - 1], n - 1),
                    knapsack(wt, val, W, n - 1)
            );
        } else {
            // Otherwise, exclude the nth item
            memo[n][W] = knapsack(wt, val, W, n - 1);
        }

        // Return the result for the current subproblem
        return memo[n][W];
    }

    public static void main(String[] args) {
        int[] val = {60, 100, 120};
        int[] wt = {10, 20, 30};
        int W = 50;
        int n = val.length;

        // Initialize the memoization table with -1, meaning uncomputed values
        memo = new int[n + 1][W + 1];
        for (int[] row : memo) {
            Arrays.fill(row, -1);
        }

        // Compute the maximum value that can be put in a knapsack of weight W
        int maxVal = knapsack(wt, val, W, n);
        System.out.println("Maximum value that can be put in a knapsack of weight " + W + " is " + maxVal);
    }
    
}
