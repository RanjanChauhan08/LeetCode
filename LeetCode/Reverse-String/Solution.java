1class Solution {
2    public void reverseString(char[] s) {
3        int l=0;
4        int e=s.length-1;
5        while(l<=e){
6            char ch=s[l];
7            s[l]=s[e];
8            s[e]=ch;
9            e--;
10            l++;
11        }
12    }
13}