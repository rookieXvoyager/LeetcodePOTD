import java.util.*;
class TransformedArray3379 {
    public static int[] constructTransformedArray(int[] nums) {
        int [] result = new int[nums.length];
        for ( int i=0;i<nums.length;i++)
        {
            if (nums[i]>0)
            {
            int move_by=nums[i]%nums.length;

                if (i+move_by>=nums.length)
                {
                    result[i]=nums[i+move_by-nums.length];
                }
                else{
                    result[i]=nums[i+move_by];
                }
            }else if (nums[i]<0)
            {
                int move_by =(nums[i])%nums.length;
                if(i+move_by<0)
                {
                    result[i]=nums[nums.length+(i+move_by)];
                }else {
                    result[i]=nums[i+move_by];
                }

            }else{
                result[i]=nums[i];
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner (System.in);
        System.out.println("Enter arr seperated by spaces: ");
        String [] inp = sc.nextLine().split(" ");
        int [] arr = new int[inp.length];
        for (int i=0;i<inp.length;i++)
        {
            arr[i]=Integer.parseInt(inp[i]);
        }
        System.out.println("The transformed array is :");
            int [] transformed =constructTransformedArray(arr);
        for(int i=0;i<arr.length;i++)
        {
            if(i==arr.length-1)
            {System.out.print(transformed[i]);
            }
            else{
                System.out.print(transformed[i]+", ");
            }
        }
    }
}