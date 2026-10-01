class Solution {
    public void nextPermutation(int[] nums) {
        int n=nums.length;
        int i=n-2;
        while(i>=0 && nums[i]>=nums[i+1]){
            i--;
        }
        //i value is the index to be swapped
        if(i>=0){
            int j=n-1;
            while(nums[j]<=nums[i]){
                j--;
            }
            //just swap the digits 
            swap(nums,i,j);
        }
        //reverse the indexes after i
        reverse(nums,i+1,n-1);
    }
    
        
        private void swap(int[] muns,int i,int j){
            int temp=muns[i];
            muns[i]=muns[j];
            muns[j]=temp;
        }
        private void reverse(int[] muns,int i,int j){
            while(i<j){
                swap(muns,i,j);
                i++;
                j--;
            }

        }
}  
    
