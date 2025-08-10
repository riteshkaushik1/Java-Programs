import java.util.Scanner;

public class LongestCommonSubsequence {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        // Input number of test cases
        int T = sc.nextInt();
        sc.nextLine(); // Consume the newline
        
        // Process each test case
        while (T-- > 0) {
            // Input the two strings
            String s1 = sc.nextLine();
            String s2 = sc.nextLine();
            
            // Find the length of LCS
            System.out.println(findLCSLength(s1, s2));
        }
        
        sc.close();
    }
    
    // Function to find the length of LCS
    public static int findLCSLength(String s1, String s2) {
        int m = s1.length();
        int n = s2.length();
        
        // Create a DP table
        int[][] dp = new int[m + 1][n + 1];
        
        // Fill the DP table
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        
        // The result is stored in dp[m][n]
        return dp[m][n];
    }
}
