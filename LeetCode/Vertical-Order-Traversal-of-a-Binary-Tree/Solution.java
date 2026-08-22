1/**
2 * Definition for a binary tree node.
3 * public class TreeNode {
4 *     int val;
5 *     TreeNode left;
6 *     TreeNode right;
7 *     TreeNode() {}
8 *     TreeNode(int val) { this.val = val; }
9 *     TreeNode(int val, TreeNode left, TreeNode right) {
10 *         this.val = val;
11 *         this.left = left;
12 *         this.right = right;
13 *     }
14 * }
15 */
16class pair{
17    int index;
18    int row;
19    TreeNode node;
20
21    pair(int index, int row, TreeNode node) {
22        this.index = index;
23        this.row = row;
24        this.node = node;
25    }
26}
27class Position {
28    int index;
29    int row;
30
31    Position(int index, int row) {
32        this.index = index;
33        this.row = row;
34    }
35}
36class Solution {
37    public List<List<Integer>> verticalTraversal(TreeNode root) {
38        List<List<Integer>>ans=new ArrayList<>();
39        if(root==null)return ans;
40        Queue<pair>queue=new LinkedList<>();
41        queue.add(new pair(0,0,root));
42        Map<Position, ArrayList<Integer>> mpp = new TreeMap<>(
43            (a, b) -> {
44                if (a.index != b.index)
45                    return Integer.compare(a.index, b.index);
46                return Integer.compare(a.row, b.row);
47            }
48        );
49        while(!queue.isEmpty()){
50            int len=queue.size();
51            for(int i=0;i<len;i++){
52                pair p=queue.poll();
53                TreeNode node=p.node;
54                int index=p.index;
55                int row=p.row;
56                Position position=new Position(index,row);
57                if(mpp.get(position)==null){
58                    mpp.put(position,new ArrayList<>());
59                    mpp.get(position).add(node.val);
60                }
61                else{
62                    mpp.get(position).add(node.val);
63                }
64                if(node.left!=null){
65                    queue.add(new pair(index-1,row+1,node.left));
66                }
67                if(node.right!=null){
68                    queue.add(new pair(index+1,row+1,node.right));
69                }
70            }
71        }
72        int prevIndex = Integer.MIN_VALUE;
73
74        for (Map.Entry<Position, ArrayList<Integer>> entry : mpp.entrySet()) {
75
76            Position pos = entry.getKey();
77            ArrayList<Integer> arr = entry.getValue();
78
79            if (pos.index != prevIndex) {
80                ans.add(new ArrayList<>());
81                prevIndex = pos.index;
82            }
83
84            Collections.sort(arr);
85
86            ans.get(ans.size() - 1).addAll(arr);
87        }
88        return ans;
89    }
90}