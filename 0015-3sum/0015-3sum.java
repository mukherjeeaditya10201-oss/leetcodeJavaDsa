class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        int n=nums.length;
        // Set<List<Integer>> ans=new HashSet<>();
        // for(int i=0;i<n;i++){
        //     Set<Integer> set=new HashSet<>();
        //     for(int j=i+1;j<n;j++){
        //        // for brute force
        //         /*for(int k=j+1;k<n;k++){
        //             if(nums[i]+nums[j]+nums[k]==0){
        //                  List<Integer> temp=new ArrayList<>();
        //                 temp.add(nums[i]);
        //                 temp.add(nums[j]);
        //                 temp.add(nums[k]);
        //                 Collections.sort(temp);
        //                 ans.add(temp);
        //             }
        //         }*/
        //         int third=-(nums[i]+nums[j]);
        //         if(set.contains(third)){
        //             List<Integer> temp=Arrays.asList(nums[i],nums[j],third);
        //             Collections.sort(temp);
        //             ans.add(temp);
        //             // temp.add(nums[i]);
        //             // temp.add(nums[j]);
        //             // temp.add(third);
        //             // Collections.sort(temp);
        //             // ans.add(temp);
        //         }
        //         set.add(nums[j]);
        //     }
           
            
        // }
        //  return new ArrayList<>(ans);
        List<List<Integer>> ans=new ArrayList<>();
        Arrays.sort(nums);
        for(int i=0;i<n;i++){
            //skip duplicates 1st elements 
            if(i>0 && nums[i]==nums[i-1]){
                continue;

            }
            int left=i+1;
            int right=n-1;
            while(left<right){
                int sum=nums[i]+nums[left]+nums[right];
                if(sum==0){
                    ans.add(Arrays.asList(nums[i],nums[left],nums[right]));
                    //skip duplicates
                    while(left<right && nums[left]==nums[left+1]){
                        left++;
                    }
                    while(left<right && nums[right]==nums[right-1]){
                        right--;
                    }
                    left++;
                    right--;
                   
                }
                 else if (sum<0)left++;
                    else right--;

            }
        }
        return ans;

    }
}
