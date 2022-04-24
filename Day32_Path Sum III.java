class Solution {
    public int pathSum(TreeNode root, int targetSum) {
        return helper(root, targetSum, 0, true);
        
    }
    
    public int helper(TreeNode root, int targetSum, int sumSoFar, boolean runAll){
        if(root!=null){
            sumSoFar+=root.val;
            int add=0;
            if(sumSoFar==targetSum)
                add++;
            if(runAll){
                return add+helper(root.left, targetSum, sumSoFar, true)+
                    helper(root.right, targetSum, sumSoFar, true)+
                    helper(root.left, targetSum, 0, false)+
                    helper(root.right, targetSum, 0, false);
            }
            else{
                return add+helper(root.left, targetSum, sumSoFar, false)+
                    helper(root.right, targetSum, sumSoFar, false);
            }
                
            }
        return 0;
            
    }
}