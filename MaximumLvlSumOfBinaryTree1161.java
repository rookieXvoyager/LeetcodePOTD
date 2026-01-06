import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class TreeNode{
    int val;
    TreeNode left, right;
    TreeNode(){}
    TreeNode(int val){
        this.val=val;
    }
    TreeNode(int val, TreeNode left, TreeNode right)
    {
        this.val=val;
        this.left=left;
        this.right=right;
    }
}
public class MaximumLvlSumOfBinaryTree1161 {
     public static int maxLevelSum(TreeNode root) {
        if (root==null) return 0;
        Queue <TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        HashMap<Integer,Integer> map=new HashMap<>();
        int lvl=1;
        while(!queue.isEmpty())
        {
            int size =queue.size();
            int lvlSum=0;
            for(int i=0;i<size;i++)
            {
                TreeNode curr =queue.poll();
                lvlSum+=curr.val;
                if(curr.left!=null)queue.offer(curr.left);
                if(curr.right!=null)queue.offer(curr.right);

            }
            map.put(lvl++,lvlSum);
            
        }       
        int maxLvl=-1,maxSum=Integer.MIN_VALUE;
        for(int el:map.keySet())
        {
            if(map.get(el)>maxSum)
            {
                maxLvl=el;
                maxSum=map.get(el);
            }

        }
        return maxLvl;

    }
    static TreeNode constructTree(Integer [] roots)
    {
        if(roots.length==0)return null;
        TreeNode root =new TreeNode(roots[0]);
        Queue <TreeNode> queue =new LinkedList<>();
        queue.offer(root);
        int idx=1;
        while(!queue.isEmpty())
        {
            TreeNode curr=queue.poll();
            if(idx<roots.length && roots[idx]!=null)
            {
                curr.left=new TreeNode(roots[idx]);
                queue.offer(curr.left);
            }
            idx++;
            if(idx<roots.length && roots[idx]!=null)
            {
                curr.right=new TreeNode(roots[idx]);
                queue.offer(curr.right);
            }
            idx++;
        }
        return root;

    }

    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        System.out.println("Enter tree node values seperated by space:");
        String [] inp =sc.nextLine().split(" ");
        Integer [] roots =new Integer[inp.length];
        int index=0;
        for(String str:inp)
        {
            if(str.equalsIgnoreCase("null"))
            {
                roots[index++]=null;
            }else{
                roots[index++]=Integer.parseInt(str);
            }
        }
        TreeNode root =constructTree(roots);
       
        System.out.println("The tree level at which the level sum is maximal is:"+maxLevelSum(root));
    }
}
