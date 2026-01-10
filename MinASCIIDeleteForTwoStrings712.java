import java.util.*;

class MinASCIIDeleteForTwoStrings712 {

    // The approach is to solve using memoization using dp approach as
    // the max string size could be 10^3 hence an O(n^2) solution is acceptable
    // there could be two states while deleting characters in the sequence
    // i) the characters are same - in which u forward both the pointers
    // ii) they are dissimilar in which you can
    // a) either move the pointer ahead in the left or right string
    // b the decision is made on the fact that the movement which leads to minimal
    // decision is taken

    public int minimumDeleteSum(String s1, String s2) {
        int m = s1.length();
        int n = s2.length();
        // dp to handle the values using memoization
        int[][] dp = new int[m][n];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        // using helper function to recurisvely perform dp
        return solve(0, 0, s1.toCharArray(), s2.toCharArray(), dp);
    }

    static int solve(int i, int j, char[] s1, char[] s2, int[][] dp) {
        // if both the pointers reach end simul

        if (i == s1.length && j == s2.length)
            return 0;
        // if there are still characters remaining in either of the strings
        if (s1.length == i) {
            int ans = 0;
            while (j < s2.length)
                ans += (int) s2[j++];
            return ans;
        } else if (s2.length == j) {
            int ans = 0;
            while (i < s1.length)
                ans += (int) s1[i++];
            return ans;
        }
        // update the dp
        if (dp[i][j] != -1)
            return dp[i][j];
        // if the compared characters are equal
        if (s1[i] == s2[j]) {
            dp[i][j] = solve(i + 1, j + 1, s1, s2, dp);
            return dp[i][j];
        } else {
            // if unequal then perform the operation with minimal cost
            dp[i][j] = Math.min(solve(i + 1, j, s1, s2, dp) + (int) s1[i], solve(i, j + 1, s1, s2, dp) + s2[j]);
            return dp[i][j];

        }

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        MinASCIIDeleteForTwoStrings712 obj = new MinASCIIDeleteForTwoStrings712();
        System.out.println("Enter String s1:");
        String s1 = sc.nextLine();
        System.out.println("Enter String s2: ");
        String s2 = sc.nextLine();
        System.out.println("The minimum value value of ASCII characters to make the strings equal is:"
                + obj.minimumDeleteSum(s1, s2));
    }
}
