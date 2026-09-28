class Solution {
    public int[] singleNumber(int[] nums) {
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int x: nums){
            map.put(x,map.getOrDefault(x,0)+1);
        }
        // int[] ans = new int[nums.length];
        // int i=0;
        ArrayList<Integer> ans=new ArrayList<>();
        for(int key:map.keySet()){
            if(map.get(key)==1){
                ans.add(key);
                
            }
        }
        return ans.stream().mapToInt(Integer::intValue).toArray();
    }
}