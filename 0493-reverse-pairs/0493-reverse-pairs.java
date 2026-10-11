class Solution {
    public int reversePairs(int[] nums) {
        int[] temp = new int[nums.length];
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
        int right = mid + 1;

        for (int left = low; left <= mid; left++) {

            while (right <= high &&
                   (long) nums[left] > 2L * nums[right]) {
                right++;
            }

            count += right - (mid + 1);
        }

        return count;
     }
    public void merge(int[] nums,int low,int mid,int high){
        int left=low;
        int right=mid+1;
        int count=0;int k=0;int[] temp = new int[nums.length];
       // int[] temp = new int[high-low+1];

       // ArrayList<Integer> temp=new ArrayList<>();
        while(left<=mid && right<=high){
            if(nums[left]<=nums[right]){
               temp[k++]=nums[left++];
                //left++;
            }
            else{
                temp[k++]=nums[right++];
               // count+=(mid-left+1);
               // right++;
            }
        }
        while(left<=mid){
             temp[k++]=nums[left++];
             //left++;
        }
        while(right<=high){
              temp[k++]=nums[right++];
            //  count+=(mid-left+1);
            // right++;
        }
        for(int i=low;i<=high;i++){
            nums[i]=temp[i-low];
        }
        // return count;
    }
}