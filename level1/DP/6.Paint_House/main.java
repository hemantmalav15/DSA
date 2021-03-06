import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int arr[][] = new int[n][3];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 3; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        int dp[][] = new int[n][3];
        dp[0][0] = arr[0][0]; // if we paint first house with Red Color
        dp[0][1] = arr[0][1]; // if we paint first house with Blue Color
        dp[0][2] = arr[0][2]; // if we paint first house with Green Color

        for (int i = 1; i < dp.length; i++) {
            // if we want to paint curr house with Red then previous must not paint with
            // Red so it can be paint with either green or blue thats why we calculate
            // min of (Green,Blue)
            dp[i][0] = arr[i][0] + Math.min(dp[i - 1][1], dp[i - 1][2]);
            dp[i][1] = arr[i][1] + Math.min(dp[i - 1][0], dp[i - 1][2]);
            dp[i][2] = arr[i][2] + Math.min(dp[i - 1][0], dp[i - 1][1]);
        }
        System.out.println(Math.min(dp[n - 1][0], Math.min(dp[n - 1][1], dp[n - 1][2])));
    }
}