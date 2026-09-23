class Solution {
    public String longestPalindrome(String s) {
        int start=0;
        int maxLen=1;
        if(s.length()<2)
        return s;
        for(int i=0;i<s.length();i++){
        //odd length palindrome
        int l1=expand(s,i,i);
        //even langth palindrome
        int l2=expand(s,i,i+1);
        int len=Math.max(l1,l2);
        if(len>maxLen){
            maxLen=len;
            start=i-(len-1)/2;
        }        
        
    }
      return s.substring(start,start+maxLen);
    }
    public int expand(String s, int left, int right){
        while(left>=0 && right < s.length() && s.charAt(left)==s.charAt(right)){
            left--;
            right++;
        }
        return right-left-1;
    }
}