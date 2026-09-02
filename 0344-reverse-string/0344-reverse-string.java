class Solution {
    public void reverseString(char[] s) {
        int l=0;
        int e=s.length-1;
        while(l<=e){
            char ch=s[l];
            s[l]=s[e];
            s[e]=ch;
            e--;
            l++;
        }
    }
}