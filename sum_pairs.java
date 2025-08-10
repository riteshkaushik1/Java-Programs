import java.util.Scanner;

public class sum_pairs {
    
    // Function to find number of distinct pairs with sum K
    public static int sum_pairs(int[] arr, int N, int K) {
        int left = 0;
        int right = N - 1;
        int count = 0;

        // Two pointer approach
        while (left < right) {
            int sum = arr[left] + arr[right];

            if (sum == K) {
                count++;
                left++;
                right--;

                // Ensure pairs are distinct by skipping duplicates
                while (left < right && arr[left] == arr[left - 1]) {
                    left++;
                }
                while (left < right && arr[right] == arr[right + 1]) {
                    right--;
                }
            } else if (sum > K) {
                right--; // Move left pointer to increase sum
            } else {
                left++; // Move right pointer to decrease sum
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        // Number of test cases
        int T = sc.nextInt();
        
        while (T-- > 0) {
            // For each test case
            int N = sc.nextInt(); // Number of elements in array
            int K = sc.nextInt(); // Target sum
            
            // Input array
            int[] arr = new int[N];
            for (int i = 0; i < N; i++) {
                arr[i] = sc.nextInt();
            }

            // Find and print number of pairs
            System.out.println(sum_pairs(arr, N, K));
        }

        sc.close();
    }
}

