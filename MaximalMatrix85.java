import java.util.*;
import java.util.Stack;

public class MaximalMatrix85 {

    public static int maximalRectangle(char[][] matrix) {
        int maxArea=0;
        int m=matrix.length, n=matrix[0].length;
        int [][] prefix = new int[m][n];
        for ( int j=0;j<n;j++)
        {
            int sum =0;
            for (int i=0;i<m;i++)
            {
                sum+=matrix[i][j]-'0';
                if (matrix[i][j]=='0')sum=0;
                prefix[i][j]=sum;
            }
        }

        for (int i =0;i<m;i++)
        {
            maxArea =Math.max(maxArea, largestRectangleArea(prefix[i]) );
        }
        return maxArea;
    }
    public static int largestRectangleArea(int [] heights){
    // previous approach took 115 ms 
    // The following is a more optimal approach using a single Stack to compute the possible
    // pse and nse
    // this approach took 73 ms
    Stack<Integer> stack =new Stack<>();
    int maxArea =0;
    for (int i=0;i<heights.length;i++)
    {
        while(!stack.isEmpty() && heights[stack.peek()]>heights[i])
        {
        int el =stack.peek();
        stack.pop();
        int nse =i, pse =stack.isEmpty()?-1:stack.peek();
        maxArea=Math.max(heights[el]*(nse-pse-1), maxArea);
        }
        stack.push(i);
    }
    while(!stack.isEmpty())
    {
        int nse=heights.length;
        int el =stack.peek();
        stack.pop();
        int pse =stack.isEmpty()?-1:stack.peek();
        maxArea=Math.max(heights[el]*(nse-pse-1),maxArea);

    }
    return maxArea;
}    
public static void main(String[] args) {
    Scanner sc =new Scanner (System.in);
    System.out.println("Enter the dimensions of the matrix:");
    String [] dim=sc.nextLine().split(" ");
    int m =Integer.parseInt(dim[0]),n=Integer.parseInt(dim[1]);
    char [][] matrix = new char[m][n];
    for (int i=0;i<m;i++)
    {
        System.out.println("Enter row "+i+" seperated by spaces");
        String [] inp=sc.nextLine().split(" ");
        for (int j=0;j<n;j++)
        {
            matrix[i][j]=inp[j].charAt(0);
        }

    }
    System.out.println("The largest maximal matrix possible is with an area of "+maximalRectangle(matrix));
}
}
