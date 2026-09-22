class Solution {
    public int maxNumberOfBalloons(String text) {
        HashMap <Character,Integer> map=new HashMap<>();
        for(int i=0;i<text.length();i++){
            char ch=text.charAt(i);
            map.put(ch,map.getOrDefault(ch,0)+1);

        }
        //how many copeis of each character can imake
        int ans=Integer.MAX_VALUE;
        ans=Math.min(ans,map.getOrDefault('b',0));
        ans=Math.min(ans,map.getOrDefault('a',0));
        ans=Math.min(ans,map.getOrDefault('l',0)/2);
        ans=Math.min(ans,map.getOrDefault('o',0)/2);
        ans=Math.min(ans,map.getOrDefault('n',0));

        return ans;
    }
}