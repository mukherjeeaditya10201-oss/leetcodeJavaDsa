class Solution {
    public void rotate(int[][] matrix) {
        // int n=matrix.length;
        // int[][] temp=new int[n][n];
        // for(int i=0;i<n;i++){
        //     for(int j=0;j<n;j++){
        //         temp[j][n-1-i]=matrix[i][j];
        //     }
        // }
        // for(int i=0;i<n;i++){
        //     for(int j=0;j<n;j++){
        //         matrix[i][j]=temp[i][j];
        //     }
        // }

        //transpose and reverse
        
        //step 1: TRANSPOSE
        int n=matrix.length;
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                int temp=matrix[i][j];
                matrix[i][j]=matrix[j][i];
                matrix[j][i]=temp;
            }
        }
        //reverse each row
         for(int i=0;i<n;i++){
            int left=0;
            int right=n-1;
            while(left<right){
                int temp=matrix[i][left];
                matrix[i][left]=matrix[i][right];
                matrix[i][right]=temp;
                 left++;right--;
            }
           
         }

    }      
    }
