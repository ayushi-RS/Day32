class BSTIterator {
List<Integer> tt = new ArrayList();
int index=0;
public BSTIterator(TreeNode root) {
    tt = inorder(root);
}
public int next() {
    int oldIndex = index;
    index++;
    if(oldIndex > tt.size() ) return 0;
    return tt.get(oldIndex);
}

public boolean hasNext() {
    return index<tt.size();
}

private List<Integer> inorder(TreeNode root){
    if(root == null) return null;
    inorder(root.left);
    tt.add(root.val);
    inorder(root.right);
    return tt;
}}
