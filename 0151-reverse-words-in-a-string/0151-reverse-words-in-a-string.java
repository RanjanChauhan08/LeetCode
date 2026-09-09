class Solution {
    public String reverseWords(String s) {
        s=s.trim();
        String str="";
        for(int i=s.length()-1;i>=0;i--){
            if(s.charAt(i)==' '){
                int j=i+1;
                String miniStr="";
                while(j<s.length() && s.charAt(j)!=' '){
                    miniStr=miniStr+s.charAt(j);
                    j++;
                }
                str+=miniStr+" ";
                while(i>=1 && s.charAt(i-1)==' ')i--;
            }
            else if(i==0){
                int j=i;
                String miniStr="";
                while(j<s.length() && s.charAt(j)!=' '){
                    miniStr=miniStr+s.charAt(j);
                    j++;
                }
                str+=miniStr;
            }
        }
        return str;
    }
}