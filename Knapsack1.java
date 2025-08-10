public class Knapsack1 {

    public static int knapsack(int[] wt, int[] val, int W, int n) {
        if (n == 0 || W == 0) {
            return 0;
        }
        if (wt[n - 1] <= W) {
            return Math.max(val[n - 1] + knapsack(wt, val, W - wt[n - 1], n - 1),
                    knapsack(wt, val, W, n - 1));
        } else {
            return knapsack(wt, val, W, n - 1);
        }
    }

    public static void main(String[] args) {
        int val[] = {  60, 100, 120 };
        int wt[] = { 10, 20, 30 };
        int W = 50;
        int n = val.length;

        int max_val = knapsack(wt, val, W, n);
        System.out.println("Maximum value that can be put in a knapsack of weight " + W + " is " + max_val);
    }
}