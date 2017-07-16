/*
PROLEM 54
Given a matrix of m x n elements (m rows, n columns), return all elements of the
 matrix in spiral order.

For example,
Given the following matrix:

[
 [ 1, 2, 3 ],
 [ 4, 5, 6 ],
 [ 7, 8, 9 ]
]
You should return [1,2,3,6,9,8,7,4,5].
--------------------------------------------------------------------------------
border conditions!!
time complexity: O(n)
*/





public class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> list = new ArrayList<>();
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return list;
        }
        
        int i = 0, j = 0;
        int[] rangeI = new int[2], rangeJ = new int[2];
        rangeI[1] = matrix.length;
        rangeI[0] = 0;
        rangeJ[0] = 0;
        rangeJ[1] = matrix[0].length;
        while(isValid(i, rangeI) && isValid(j, rangeJ)) {
            int jj = rangeJ[0];
            while(isValid(jj, rangeJ)) {
                System.out.println("1");
                list.add(matrix[i][jj]);
                jj++;
            } 
            jj--;
            rangeI[0]++;
            
            int ii = rangeI[0];
            while (isValid(ii, rangeI) && isValid(jj, rangeJ)) {
                // System.out.println("2");
                list.add(matrix[ii][jj]);
                ii++;
            }
            ii--;
            rangeJ[1]--;
            
            int jjj = rangeJ[1] - 1;
           while (isValid(jjj, rangeJ) && isValid(ii, rangeI)) {
               // System.out.println("3");
                list.add(matrix[ii][jjj]);
                jjj--;
            }  
            jjj++;
            rangeI[1]--;
            
            int iii = rangeI[1] - 1;
            while(isValid(iii, rangeI) && isValid(jjj, rangeJ)) {
                // System.out.println("4");
                list.add(matrix[iii][jjj]);
                iii--;
            } 
            iii++;
            rangeJ[0]++;
            
            i = rangeI[0];
            j = rangeJ[0];
        }
        return list;
    }
    
    private boolean isValid(int i, int[] rangeI) {
        if (i < rangeI[1] && i >= rangeI[0]) {
            return true;
        }
        return false;
    }
}