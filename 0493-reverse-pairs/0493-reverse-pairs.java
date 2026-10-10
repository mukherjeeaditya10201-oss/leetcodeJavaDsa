class Solution {
    public int reversePairs(int[] nums) {
        return mergeSort(nums,0,nums.length-1);
    }
    int mergeSort(int[] nums,int low,int high){
        if(low>=high){
            return 0;
        }
        int mid=low+(high-low)/2;
        int count=0;
        count+=mergeSort(nums,low,mid);
        count+=mergeSort(nums,mid+1,high);
        count+=countPairs(nums,low,mid,high);
        merge(nums,low,mid,high);
        return count;
    }
     private int countPairs(int[] nums, int low, int mid, int high) {

        int count = 0;
        int j = mid + 1;

        for (int i = low; i <= mid; i++) {

            while (j <= high &&
                   (long) nums[i] > 2L * nums[j]) {
                j++;
            }

            count += j - (mid + 1);
        }

        return count;
     }
    public void merge(int[] nums,int low,int mid,int high){
        int left=low;
        int right=mid+1;
        int count=0;
        ArrayList<Integer> temp=new ArrayList<>();
        while(left<=mid && right<=high){
            if(nums[left]<=nums[right]){
                temp.add(nums[left]);
                left++;
            }
            else{
                temp.add(nums[right]);
               // count+=(mid-left+1);
                right++;
            }
        }
        while(left<=mid){
             temp.add(nums[left]);
             left++;
        }
        while(right<=high){
             temp.add(nums[right]);
            //  count+=(mid-left+1);
             right++;
        }
        for(int k=low;k<=high;k++){
            nums[k]=temp.get(k-low);
        }
        // return count;
    }
}