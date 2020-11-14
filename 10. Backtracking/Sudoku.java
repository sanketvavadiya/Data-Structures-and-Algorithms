package classFiles;
class Sudoku
{
	static int n;

	static boolean isValid(int i, int j, int num, int[][]grid) {
		for (int k=0; k<n; k++) {
			if(grid[i][k]==num || grid[k][j]==num)
				return false;
		}

		int s = (int)Math.sqrt(n);
		int rs = i-(i%s);
		int cs = j-(j%s);

		for (i=0; i<s; i++) {
			for(j=0;j<s;j++)
				if(grid[i+rs][j+cs] == num)
					return false;
		}
		return true;
	}

	static boolean sudokuAlgo(int [][]grid){
		int i=0, j=0;
		for (i=0; i<n; i++) {
			for (j=0; j<n; j++) {
				if(grid[i][j]==0)
					break;
			}
			if(j!=n)
				break;
		}

		// set goal
		if(i==n && j==n)
			return true;

		// make choice
		for (int num=1; num<=n; num++) {
			// validate choice
			if(isValid(i, j, num, grid)){
				grid[i][j] = num;
				// verify choice
				if(sudokuAlgo(grid))
					return true;
				// reset value because wrong value chosen
				grid[i][j] = 0;
			}
		}
		// backtrack to parent call
		return false;
	}

	static void printSudoku(int [][]grid){
		for (int i=0; i<n; i++) {
			for (int j=0; j<n; j++) {
				System.out.print(grid[i][j]+" ");
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {
		int [][]grid = {{3, 4, 1, 0}, {0, 2, 0, 0}, {0, 0, 2, 0}, {0, 1, 4, 3}};
		n = 4;
		if(sudokuAlgo(grid)){
			System.out.println("Yes");
			printSudoku(grid);
		}
		else
			System.out.print("No");
	}
}