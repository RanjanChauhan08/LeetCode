1class Solution {
2    public String reverseWords(String s) {
3        s=s.trim();
4        String str="";
5        for(int i=s.length()-1;i>=0;i--){
6            if(s.charAt(i)==' '){
7                int j=i+1;
8                String miniStr="";
9                while(j<s.length() && s.charAt(j)!=' '){
10                    miniStr=miniStr+s.charAt(j);
11                    j++;
12                }
13                str+=miniStr+" ";
14                while(i>=1 && s.charAt(i-1)==' ')i--;
15            }
16            else if(i==0){
17                int j=i;
18                String miniStr="";
19                while(j<s.length() && s.charAt(j)!=' '){
20                    miniStr=miniStr+s.charAt(j);
21                    j++;
22                }
23                str+=miniStr;
24            }
25        }
26        return str;
27    }
28}