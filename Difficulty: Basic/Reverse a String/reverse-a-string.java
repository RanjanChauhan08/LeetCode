class Solution {
    public static String reverseString(String s) {
        int i=0;
        int j=s.length()-1;
        char[]str=s.toCharArray();
        while(i<j){
            char temp=str[i];
            str[i]=str[j];
            str[j]=temp;
            i++;j--;
        }
        String st="";
        for(char ch:str)st=st+ch;
        return st;
    }
}