class Solution {
    public String reverseWords(String s) {
        String str="";
        Boolean bt=false;
        for(int i=s.length()-1;i>=0;i--){
            if(i==0 && s.charAt(i)!='.'){
                String miniStr="";
                int j=i;
                while(j<s.length() && s.charAt(j)!='.'){
                    miniStr=miniStr+s.charAt(j);
                    j++;
                }
                str=str+miniStr;
            }
            else if(s.charAt(i)=='.' && bt){
                String miniStr="";
                int j=i+1;
                while(j<s.length() && s.charAt(j)!='.'){
                    miniStr=miniStr+s.charAt(j++);
                }
                str=str+miniStr+".";
                bt=false;
            }
            else if((s.charAt(i)!='.')){
                bt=true;
            }
        }
        String ans="";
        if(str.charAt(str.length()-1)=='.' && str.charAt(0)=='.'){
            ans=str.substring(1,str.length()-1);
        }
        else if(str.charAt(str.length()-1)=='.' ){
            ans=str.substring(0,str.length()-1);
        }
        else if(str.charAt(0)=='.'){
            ans=str.substring(1,str.length());
        }
        else{
            ans=str;
        }
        return ans;
    }
}
