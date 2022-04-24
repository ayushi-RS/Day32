class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> levels = new ArrayList<>();
        
        if (root == null) {
            return levels;
        }
        
        Queue<TreeNode> queue = new ArrayDeque<>();
        TreeNode levelMarker = new TreeNode(-10001);
        queue.add(root);
        queue.add(levelMarker);
        List<Integer> level = new ArrayList<>();
        while (queue.size() > 0) {
            TreeNode top = queue.remove();
            if (top.equals(levelMarker)) {
                levels.add(level);
                if (queue.size() > 0) {
                    queue.add(levelMarker);
                }
                level = new ArrayList<>();
                
            } else {
                level.add(top.val);
                if (top.left != null) {
                    queue.add(top.left);
                }
                if (top.right != null) {
                    queue.add(top.right);
                }
            }
        }
        return levels;
    }
}