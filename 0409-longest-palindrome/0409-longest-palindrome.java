class Solution {
    public int longestPalindrome(String s) {
         HashMap<Character,Integer> map=new HashMap<>();
         for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            map.put(ch,map.getOrDefault(ch,0)+1);

         }
         boolean hasOdd=false;
         int length=0;
         for(int count:map.values()){
            length=length+(count/2)*2;
            if(count%2==1)hasOdd=true;

         }
         if(hasOdd)length++;
         return length;
    }
}