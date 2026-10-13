class Solution {
    public void inOrder(TreeNode root,boolean[]bt,double[]max){
        if(root==null)return;
        inOrder(root.left,bt,max);
        if(max[0]>=root.val){
            bt[0]=false;
        }
        else{
            max[0]=root.val;
        }
        inOrder(root.right,bt,max);
    }
    public boolean isValidBST(TreeNode root) {
        if(root==null)return true;
        if(root.left==null && root.right==null)return true;
        boolean[]bt={true};
        double[]max={-21474836490d};
        inOrder(root,bt,max);
        return bt[0];
    }
}