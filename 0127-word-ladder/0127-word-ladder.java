class pair{
    String word;
    int n;
    pair(String word,int n){
        this.word=word;
        this.n=n;
    }
}
class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if(endWord.length()!=beginWord.length())return 0;
        HashSet<String>hs=new HashSet<>();
        for(String str:wordList){
            hs.add(str);
        }
        if(hs.contains(beginWord)){
            hs.remove(beginWord);
        }
        Queue<pair>queue=new LinkedList<>();
        queue.add(new pair(beginWord,1));
        while(!queue.isEmpty()){
            int len=queue.size();
            for(int i=0;i<len;i++){
                pair p=queue.poll();
                String s=p.word;
                int n=p.n;
                if(s.equals(endWord))return n;
                for(int x=0;x<s.length();x++){
                    for(char ch='a';ch<='z';ch++){
                        String newWord="";
                        if(x==0){
                            newWord=newWord+ch+s.substring(1);
                        }
                        else{
                            newWord=newWord+s.substring(0,x)+ch+s.substring(x+1);
                        }
                        if(hs.contains(newWord)){
                            queue.add(new pair(newWord,n+1));
                            hs.remove(newWord);
                        }
                    }
                }
            }
        }
        return 0;
    }
}