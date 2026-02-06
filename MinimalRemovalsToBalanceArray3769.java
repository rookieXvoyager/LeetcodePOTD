
import java.util.*;
import java.util.Arrays;
class MinimalRemovalsToBalanceArray3769 {
    public static int minRemoval(int[] nums, int k) {

     if (nums.length<=1) return 0;

    
    // the idea is to implement a sliding window 
    // the window within wouild keep all the elements satisfying the 

    // sorting to find the most convinient window
    Arrays.sort(nums);
    // storing the largest window
    int maxWindow=0;
    // left pointer 
    int left=0;
    for (int right=0;right<nums.length;right++)
    {
        // shift l until the required window is encountered
        while ((long)nums[left]*k<(long)nums[right])
        {
            left++;
        }
        
        maxWindow=Math.max(right-left+1, maxWindow);
    }
    return nums.length-maxWindow;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner (System.in);
        System.out.println("Enter the array seperated by spaces: ");
        String [] inp =sc.nextLine().split(" ");
        int [] nums = new int[inp.length];
        for ( int i=0;i<inp.length;i++)
        {
            nums[i]=Integer.parseInt(inp[i]);
        } 
        System.out.println("Enter the value of k:");
        int k =sc.nextInt();
        System.out.println("The minimal number of elements to remove from nums is "+minRemoval(nums, k));
    }
        
}