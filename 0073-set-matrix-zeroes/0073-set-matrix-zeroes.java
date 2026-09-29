class Solution {
    public void setZeroes(int[][] matrix) {
        // int[] row=new int[matrix.length];
        // int[] col=new int[matrix[0].length];
        // for(int i=0;i<matrix.length;i++){
        //     for(int j=0;j<matrix[0].length;j++){
        //         if(matrix[i][j]==0){
        //             row[i]=1;
        //             col[j]=1;
        //         }
        //     }
        // }
        //  for(int i=0;i<matrix.length;i++){
        //     for(int j=0;j<matrix[0].length;j++){
        //         if(row[i]==1|| col[j]==1){
        //             matrix[i][j]=0;
        //         }
        //     }
        // }
        int n=matrix.length;
        int m=matrix[0].length;
        boolean firstRowZero=false;
        boolean firstColZero=false;
        //check if 1st row has a zero
        for(int j=0;j<m;j++){
            if(matrix[0][j]==0){
                firstRowZero=true;
            }
        }
        //check if 1st column has zero
        for(int i=0;i<n;i++){
            if(matrix[i][0]==0){
                firstColZero=true;
            }
        }
        //check for all other rows and mark the first row and col
        for(int i=1;i<n;i++){
            for(int j=1;j<m;j++){
                if(matrix[i][j]==0){
                    matrix[i][0]=0;
                    matrix[0][j]=0;
                }
            }
        }
        //now the marked rows an cols shd be used to make zeroes
        for(int i=1;i<n;i++){
            for(int j=1;j<m;j++){
                if(matrix[i][0]==0 ||
                    matrix[0][j]==0){
                    matrix[i][j]=0;
                }
            }
        }
        if(firstRowZero)
        {
           for(int j=0;j<m;j++){
            matrix[0][j]=0;
           }
        }
        if(firstColZero){
            for(int i=0;i<n;i++){
                matrix[i][0]=0;

            }
        }

    }
}