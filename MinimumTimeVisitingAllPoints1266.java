import java.util.*;

class MinimumTimeVisitingAllPoints1266 {
    public static int minTimeToVisitAllPoints(int[][] arr) {
        int minTime = 0;
        // The most optimal way to travel between two points is diagonally
        // Bcoz it enables simulataneous travel in both x and y directions in 1 unit
        // time
        // once travelled diagonally, next traversal could be perfomed in the direction
        // remaining i.e. either x axis or y-axis
        for (int i = 0; i < arr.length - 1; i++) {
            int dx = Math.abs(arr[i + 1][0] - arr[i][0]), dy = Math.abs(arr[i + 1][1] - arr[i][1]);
            int diagDist = Math.min(dx, dy);
            minTime += diagDist;
            minTime += Math.max(dx, dy) - diagDist;

        }
        return minTime;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the no. of points: ");
        int n = sc.nextInt();
        sc.nextLine();
        int[][] points = new int[n][2];
        for (int i = 0; i < n; i++) {
            System.out.print("Enter point x" + i + " y" + i + ": ");
            points[i][0] = sc.nextInt();
            points[i][1] = sc.nextInt();
        }
        System.out.println(
                "The minimum time to covered all the points in order is:" + minTimeToVisitAllPoints(points) + " units");

    }
}