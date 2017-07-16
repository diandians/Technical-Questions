/*
According to the Wikipedia's article: "The Game of Life, also known simply as 
Life, is a cellular automaton devised by the British mathematician John Horton 
Conway in 1970."

Given a board with m by n cells, each cell has an initial state live (1) or dead
 (0). Each cell interacts with its eight neighbors (horizontal, vertical, 
 diagonal) using the following four rules (taken from the above Wikipedia article):

Any live cell with fewer than two live neighbors dies, as if caused by 
under-population.
Any live cell with two or three live neighbors lives on to the next generation.
Any live cell with more than three live neighbors dies, as if by over-population..
Any dead cell with exactly three live neighbors becomes a live cell, as if by 
reproduction.
Write a function to compute the next state (after one update) of the board given
 its current state.

Follow up: 
Could you solve it in-place? Remember that the board needs to be updated at the
 same time: You cannot update some cells first and then use their updated values
  to update other cells.
In this question, we represent the board using a 2D array. In principle, the 
board is infinite, which would cause problems when the active area encroaches 
the border of the array. How would you address these problems?
*/

public class Solution {
    // brute force
    public void gameOfLife(int[][] board) {
        if (board.length == 0 || board[0].length == 0) {
            return;
        }
        int n = board.length, m = board[0].length;
        int[][] temp = new int[n][m];
        int num;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                num = neighborsNum(board, i, j);
                temp[i][j] = live(num, board[i][j]);
            }
        }
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                board[i][j] = temp[i][j];
            }
        }
    }
    
    private int live (int num, int state) {
        if (state == 1) {
            if (num < 2 || num > 3) {
                return 0;
            } else {
                return 1;
            }
        }
        if (state == 0 && num == 3) {
            return 1;
        }
        return 0;
    }
    private int neighborsNum (int[][] board, int i, int j) {
        int num = 0;
        int n = board.length, m = board[0].length;
        if (i > 0) {
            num += board[i - 1][j];
            if (j > 0) {
                num += board[i - 1][j - 1];
            }
        }
        if (i + 1 < n) {
            num += board[i + 1][j];
            if (j + 1 < m) {
                num += board[i + 1][j + 1];   
            }
        }
        if (j > 0) {
            num += board[i][j - 1];
            if (i + 1 < n) {
                num += board[i + 1][j - 1];
            }
        }
        if (j + 1 < m) {
            num += board[i][j + 1];
            if (i > 0) {
                num += board[i - 1][j + 1];
            }
        }
        return num;
    }
    
    // in place
    public void gameOfLife(int[][] board) {
        int n = board.length, m = board[0].length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int num = neighborsNum(board, i, j);
                int pos = 1;
                if (board[i][j] <= 0) {
                    pos = -1;
                }
                board[i][j] = pos * num;
            }
        }
        
        for (int i = 0; i< n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] == 3 || Math.abs(board[i][j]) == 4) {
                    board[i][j] = 1;
                } else {
                    board[i][j] = 0;
                }
            }
        }
    }
    
        private int neighborsNum (int[][] board, int i, int j) {
        int num = 0;
        int n = board.length, m = board[0].length;
        if (i > 0) {
            num += adder(board[i - 1][j]);
            if (j > 0) {
                num += adder(board[i - 1][j - 1]);
            }
        }
        if (i + 1 < n) {
            num += adder(board[i + 1][j]);
            if (j + 1 < m) {
                num += adder(board[i + 1][j + 1]);   
            }
        }
        if (j > 0) {
            num += adder(board[i][j - 1]);
            if (i + 1 < n) {
                num += adder(board[i + 1][j - 1]);
            }
        }
        if (j + 1 < m) {
            num += adder(board[i][j + 1]);
            if (i > 0) {
                num += adder(board[i - 1][j + 1]);
            }
        }
        return num + 1;
    }
    
    private int adder(int x) {
        if (x <= 0) {
            return 0;
        } else {
            return 1;
        }
    }
    
    // sample solution
    public void gameOfLife(int[][] board) {
    if (board == null || board.length == 0) return;
    int m = board.length, n = board[0].length;

    for (int i = 0; i < m; i++) {
        for (int j = 0; j < n; j++) {
            int lives = liveNeighbors(board, m, n, i, j);

            // In the beginning, every 2nd bit is 0;
            // So we only need to care about when will the 2nd bit become 1.
            if (board[i][j] == 1 && lives >= 2 && lives <= 3) {  
                board[i][j] = 3; // Make the 2nd bit 1: 01 ---> 11
            }
            if (board[i][j] == 0 && lives == 3) {
                board[i][j] = 2; // Make the 2nd bit 1: 00 ---> 10
            }
        }
    }

    for (int i = 0; i < m; i++) {
        for (int j = 0; j < n; j++) {
            board[i][j] >>= 1;  // Get the 2nd state.
        }
    }
}

	public int liveNeighbors(int[][] board, int m, int n, int i, int j) {
	    int lives = 0;
	    for (int x = Math.max(i - 1, 0); x <= Math.min(i + 1, m - 1); x++) {
	        for (int y = Math.max(j - 1, 0); y <= Math.min(j + 1, n - 1); y++) {
	            lives += board[x][y] & 1;
	        }
	    }
	    lives -= board[i][j] & 1;
	    return lives;
	}


// Mao Cai: one O(n) time
// pre-neighbors + post-neighbors
public void gameOfLife(int[][] board) {
        if (board == null || board.length == 0) {
            return;
        }
        int row = board.length, col = board[0].length;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
            //    print(board);
                // board[i][j] > 0 means there was an '1' initially
                if (board[i][j] > 0) {
                    int totalNeighbors = board[i][j] - 1 + postNeighbors(board, i, j, row, col);
                 //   System.out.println("post = " + postNeighbors(board, i, j, row, col) + " total = " + totalNeighbors);
                    if (totalNeighbors == 2 || totalNeighbors == 3) {
                        board[i][j] = 1;
                    } else {
                        board[i][j] = 0;
                    }
                    // And we update its post neighbors
                    updatePostNeighbors(board, i, j, row, col);
                    continue;
                }
                
                // board[i][j] <= 0 means there was a '0' initially
                if (board[i][j] <= 0) {
                    int totalNeighbors = -board[i][j] + postNeighbors(board, i, j, row, col);
                    if (totalNeighbors == 3) {
                        board[i][j] = 1;
                    } else {
                        board[i][j] = 0;
                    }
                }
            }
        }
    }
    
    private void print(int[][] board) {
        System.out.println("******");
        for (int[] a: board) {
            System.out.println(Arrays.toString(a));
        }
    }
    
    private void updatePostNeighbors(int[][] board, int i, int j, int row, int col) {
        if (j+1 < col) {
            if (board[i][j+1] >= 1) {
                board[i][j+1]++;
            } else {
                board[i][j+1]--;
            }
        }
        
        if (i + 1 < row) {
            if (j-1 >= 0) {
                if (board[i+1][j-1] >= 1) {
                    board[i+1][j-1]++;
                }

}