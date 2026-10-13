class Solution {
    public List<Integer> majorityElement(int[] nums) {
        ArrayList<Integer> ans=new ArrayList<>();
        HashMap<Integer,Integer> map=new HashMap<>();
        int n=nums.length;
        for(int num:nums){
            map.put(num,map.getOrDefault(num,0)+1);            
        }
        for(Map.Entry<Integer,Integer> it: map.entrySet()){
            if(it.getValue()>n/3){
                ans.add(it.getKey());
            }
        }
        return ans;
    }
}