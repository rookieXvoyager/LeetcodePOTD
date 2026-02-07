import java.util.*;
public class MinimumDeletionsToMakeStringBalanced1653 {
 

    public static  int minimumDeletions(String s) {
        // the idea here is to determine a partition for every element in the array where 
        //  all elements on left are assumed as a 
        //  all on right are assumed to be b
        //  if not , increase their count 
        //  min of sum of bs on left and as on right will give us the eventual no. of removals req
        //  the track the no. of a's , we build a prefix array of count from right
            if (s.length()<=1)return 0;
        int [] as = new int[s.length()];
        for ( int i=s.length()-2;i>=0;i--)
        {
            as[i]=as[i+1];
            if (s.charAt(i+1)=='a')
            as[i]+=1;
        }

        //  now iterate from left to find the count 
        int bCount =0;
        int toRemove=Integer.MAX_VALUE;
        for (int i=0;i<s.length();i++)
        {
            toRemove=Math.min(bCount+as[i], toRemove);
            if(s.charAt(i)=='b')bCount++;
        }
        return toRemove;

    }
    public static void main(String[] args) {
        Scanner sc = new Scanner (System.in);
        System.out.println("Enter the string:");
        System.out.println("The minimal no. of removals required are: "+minimumDeletions(sc.nextLine()));
    }

}
