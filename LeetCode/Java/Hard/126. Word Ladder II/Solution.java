class pair{
    String str;
    ArrayList<String>arr;
    pair(String str,ArrayList<String>arr){
        this.str=str;
        this.arr=arr;
    }
}
class Solution {
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        List<List<String>>ans=new ArrayList<>();
        Queue<String>queue=new LinkedList<>();
        queue.add(beginWord);
        Map<String,Integer>map=new HashMap<>();
        map.put(beginWord,1);
        Set<String>set=new HashSet<>();
        int wordLen=endWord.length();
        while(!queue.isEmpty()){
            int size=queue.size();
            ArrayList<String>s=new ArrayList<>();
            for(int m=0;m<size;m++){
                String str=queue.poll();
                int steps=map.get(str)+1;
                for(int i=0;i<wordLen;i++){
                    for(int j=0;j<26;j++){
                        char[]arr=str.toCharArray();
                        arr[i]=(char)('a'+j);
                        String newStr=new String(arr);
                        if(!set.contains(newStr) && doesContains(wordList,newStr)){
                            if(!map.containsKey(newStr)){
                                map.put(newStr, steps);
                                s.add(newStr);
                                queue.add(newStr);
                            }
                        }
                    }
                }
            }
            addInSet(set,s);
        }
        if(map.containsKey(endWord)==true){
            List<String>seq=new ArrayList<>();
            seq.add(endWord);
            dfs(endWord,beginWord,seq,ans,map);
        }
        return ans;
    }
    public void dfs(String endWord,String beginWord,List<String>seq,List<List<String>>ans,Map<String,Integer>map){
        if(endWord.equals(beginWord)){
            Collections.reverse(seq);
            ans.add(new ArrayList<>(seq));
            Collections.reverse(seq);
            return;
        }
        for(int i=0;i<endWord.length();i++){
            for(int j=0;j<26;j++){
                char[]arr=endWord.toCharArray();
                arr[i]=(char)('a'+j);
                String st=new String(arr);
                int step=map.get(endWord);
                if(map.containsKey(st) && map.get(st)==step-1){
                    seq.add(st);
                    dfs(st,beginWord,seq,ans,map);
                    seq.remove(seq.size()-1);
                }
            }
        }
    }
    public boolean doesContains(List<String>wordList,String newStr){
        for(String str:wordList){
            if(str.equals(newStr))return true;
        }
        return false;
    }
    public void addInSet(Set<String>set,ArrayList<String>t){
        for(String str:t){
            set.add(str);
        }
    }
}