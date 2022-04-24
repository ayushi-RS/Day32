/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
   public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
	   //Create stack for tracking each lavel node
	   Stack<TreeNode> currLevel=new Stack<>();
	   Stack<TreeNode> nextLevel=new Stack<>();
	   List<List<Integer> > ans = new ArrayList<>();
        if(root==null)
	        return ans;
	   
	   currLevel.push(root);
	   boolean ltr=true;
	   List<Integer> tempAns=new ArrayList<>();
	   while(!currLevel.isEmpty() ){
	       TreeNode temp = currLevel.pop();
	       tempAns.add(temp.val);
	       if(ltr){
	           if(temp.left!=null)
	            nextLevel.push(temp.left);
	            if(temp.right!=null)
	            nextLevel.push(temp.right);
	       }else{
	            if(temp.right!=null)
	            nextLevel.push(temp.right);
	            if(temp.left!=null)
	            nextLevel.push(temp.left);
	       }
	       //swap betwween stack
	       if(currLevel.isEmpty() ){
	           Stack<TreeNode> tempst=currLevel;
	           currLevel=nextLevel;
	           nextLevel=tempst;
	           ltr=!ltr;
               ans.add(tempAns);
               tempAns=new ArrayList<>();
	       }
	       
	   }
	   return ans;
    }
}