/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {
    String str="";
    public String in_helper(TreeNode node) {
        if (node == null) return "";
        String left = in_helper(node.left);
        String right = in_helper(node.right);
        return left + node.val + "," + right;
    }
    public String pre_helper(TreeNode node) {
        if (node == null) return "";
        String left = pre_helper(node.left);
        String right = pre_helper(node.right);
        return node.val + "," + left + right;
    }
    public String serialize(TreeNode root) {
        if (root == null) return "#";
        return root.val + "," 
            + serialize(root.left) + ","
            + serialize(root.right);
    }
    public int findChar(char ch,String data){
        for(int i=0;i<data.length();i++){
            if(data.charAt(i)==ch)return i;
        }
        return -1;
    }
    public TreeNode deserialize(String data) {
    if (data.equals("#"))
        return null;

    String[] arr = data.split(",");
    Queue<String> queue = new LinkedList<>();

    for (String s : arr) {
        queue.add(s);
    }

    return build(queue);
}

public TreeNode build(Queue<String> queue) {

    String s = queue.poll();

    if (s.equals("#"))
        return null;

    TreeNode node = new TreeNode(Integer.parseInt(s));

    node.left = build(queue);
    node.right = build(queue);

    return node;
}
    public TreeNode helper(int[]preorder,int[]inorder,int preS,int preE,int inS,int inE){
        if(preS>preE)return null;
        TreeNode root=new TreeNode(preorder[preS]);
        if(preS==preE)return root;
        int target=preorder[preS];
        int ind=-1;
        for(int i=inS;i<=inE;i++){
            if(inorder[i]==target){
                ind=i;
            }
        }
        int l=ind-(inS);
        TreeNode left=helper(preorder,inorder,preS+1,preS+l,inS,inS+l-1);
        TreeNode right=helper(preorder,inorder,preS+l+1,preE,inS+l+1,inE);
        root.left=left;
        root.right=right;
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));