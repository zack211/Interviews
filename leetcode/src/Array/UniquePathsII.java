package Array;

/**
 * Follow up for "Unique Paths": Now consider if some obstacles are added to the
 * grids. How many unique paths would there be? An obstacle and empty space is
 * marked as 1 and 0 respectively in the grid. For example, There is one
 * obstacle in the middle of a 3x3 grid as illustrated below. [ [0,0,0],
 * [0,1,0], [0,0,0] ] The total number of unique paths is 2. Note: m and n will
 * be at most 100.
 * 
 * @author heguangliu
 * 
 */
public class UniquePathsII {
	// bad version
	public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
		// Start typing your Java solution below
		// DO NOT write main() function
		int m = obstacleGrid.length;
		int n = obstacleGrid[0].length;
		int[][] matrix = new int[m + 1][n + 1];
		for (int i = 0; i <= m; i++)
			for (int j = 0; j <= n; j++)
				matrix[i][j] = -1;
		return uniquePathsWithObstaclesHelper(matrix, m, n, obstacleGrid);
	}

	public static int uniquePathsWithObstaclesHelper(int[][] matrix, int a,
			int b, int[][] obstacleGrid) {
		 if (a < 1 || b < 1){
			 return 0;
		 } 
		 if(obstacleGrid[a-1][b-1] == 1)
			 return 0;
		if (a == 1 && b == 1) {   
			return 1;
		}else {
			if (matrix[a - 1][b] == -1)
				matrix[a - 1][b] = uniquePathsWithObstaclesHelper(matrix,
						a - 1, b, obstacleGrid);
			if (matrix[a][b - 1] == -1)
				matrix[a][b - 1] = uniquePathsWithObstaclesHelper(matrix, a,
						b - 1, obstacleGrid);
			return matrix[a - 1][b] + matrix[a][b - 1];
		}
	}

	public static void main(String[] args) {
		int[][] test = { { 1 } };
		System.out.println(uniquePathsWithObstacles(test));
	}

}