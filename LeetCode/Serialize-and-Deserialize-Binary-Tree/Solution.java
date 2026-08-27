1/**
2 * Definition for a binary tree node.
3 * public class TreeNode {
4 *     int val;
5 *     TreeNode left;
6 *     TreeNode right;
7 *     TreeNode(int x) { val = x; }
8 * }
9 */
10public class Codec {
11    String str="";
12    public String in_helper(TreeNode node) {
13        if (node == null) return "";
14        String left = in_helper(node.left);
15        String right = in_helper(node.right);
16        return left + node.val + "," + right;
17    }
18    public String pre_helper(TreeNode node) {
19        if (node == null) return "";
20        String left = pre_helper(node.left);
21        String right = pre_helper(node.right);
22        return node.val + "," + left + right;
23    }
24    public String serialize(TreeNode root) {
25        if (root == null) return "#";
26        return root.val + "," 
27            + serialize(root.left) + ","
28            + serialize(root.right);
29    }
30    public int findChar(char ch,String data){
31        for(int i=0;i<data.length();i++){
32            if(data.charAt(i)==ch)return i;
33        }
34        return -1;
35    }
36    public TreeNode deserialize(String data) {
37    if (data.equals("#"))
38        return null;
39
40    String[] arr = data.split(",");
41    Queue<String> queue = new LinkedList<>();
42
43    for (String s : arr) {
44        queue.add(s);
45    }
46
47    return build(queue);
48}
49
50public TreeNode build(Queue<String> queue) {
51
52    String s = queue.poll();
53
54    if (s.equals("#"))
55        return null;
56
57    TreeNode node = new TreeNode(Integer.parseInt(s));
58
59    node.left = build(queue);
60    node.right = build(queue);
61
62    return node;
63}
64    public TreeNode helper(int[]preorder,int[]inorder,int preS,int preE,int inS,int inE){
65        if(preS>preE)return null;
66        TreeNode root=new TreeNode(preorder[preS]);
67        if(preS==preE)return root;
68        int target=preorder[preS];
69        int ind=-1;
70        for(int i=inS;i<=inE;i++){
71            if(inorder[i]==target){
72                ind=i;
73            }
74        }
75        int l=ind-(inS);
76        TreeNode left=helper(preorder,inorder,preS+1,preS+l,inS,inS+l-1);
77        TreeNode right=helper(preorder,inorder,preS+l+1,preE,inS+l+1,inE);
78        root.left=left;
79        root.right=right;
80        return root;
81    }
82}
83
84// Your Codec object will be instantiated and called as such:
85// Codec ser = new Codec();
86// Codec deser = new Codec();
87// TreeNode ans = deser.deserialize(ser.serialize(root));