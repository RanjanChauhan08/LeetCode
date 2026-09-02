1class Solution {
2    public boolean check(String str){
3        if(str.length()<=1)return true;
4        char[]st=str.toCharArray();
5        int low=0;
6        int high=str.length()-1;
7        while(low<=high){
8            if(st[low]==st[high]){
9                low++;
10                high--;
11            }
12            else return false;
13        }
14        return true;
15    }
16    public boolean isPalindrome(String s) {
17        char[]st=s.toCharArray();
18        String str="";
19        for(int i=0;i<st.length;i++){
20            if((st[i]>='a' && st[i]<='z') || (st[i]>='0' && st[i]<='9')){
21                str=str+st[i];
22            }
23            else if(st[i]>='A' && st[i]<='Z'){
24                str=str+(char)(st[i]+32);
25            }
26        }
27        return check(str);
28    }
29}