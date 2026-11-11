import java.util.*;

class DisjointSet {
    int[] parent;
    int[] rank;

    DisjointSet(int n) {
        parent = new int[n];
        rank = new int[n];

        for (int i = 0; i < n; i++) {
            parent[i] = i;
            rank[i] = 0;
        }
    }

    int findUPar(int node) {

        if (node == parent[node]) {
            return node;
        }

        return parent[node] = findUPar(parent[node]);
    }

    void unionByRank(int u, int v) {

        int ulp_u = findUPar(u);
        int ulp_v = findUPar(v);

        if (ulp_u == ulp_v) {
            return;
        }

        if (rank[ulp_u] < rank[ulp_v]) {
            parent[ulp_u] = ulp_v;
        }

        else if (rank[ulp_v] < rank[ulp_u]) {
            parent[ulp_v] = ulp_u;
        }

        else {
            parent[ulp_v] = ulp_u;
            rank[ulp_u]++;
        }
    }

    boolean isConnected(int u, int v) {
        return findUPar(u) == findUPar(v);
    }
}
class Solution {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        int n=accounts.size();
        DisjointSet ds=new DisjointSet(n);
        HashMap<String,Integer>mpp=new HashMap<>();
        for(int i=0;i<n;i++){
            for(int j=1;j<accounts.get(i).size();j++){
                String mail=accounts.get(i).get(j);
                if(mpp.containsKey(mail)){
                    ds.unionByRank(i, mpp.get(mail));
                }
                else{
                    mpp.put(mail, i);
                }
            }
        }
        List<List<String>>ans=new ArrayList<>();
        for(int i=0;i<n;i++)ans.add(new ArrayList<>());
        for(Map.Entry<String,Integer> entry : mpp.entrySet()){
            String mail = entry.getKey();
            int key = entry.getValue();

            int ulp = ds.findUPar(key);
            ans.get(ulp).add(mail);
        }
        List<List<String>>m=new ArrayList<>();
        for(int i=0;i<n;i++){
            if(ans.get(i).size()==0)continue;
            String name=accounts.get(i).get(0);
            ArrayList<String>miniAns=new ArrayList<>();
            miniAns.add(name);
            List<String>mails=ans.get(i);
            Collections.sort(mails);
            miniAns.addAll(mails);
            m.add(miniAns);
        }
        return m;
    }
}