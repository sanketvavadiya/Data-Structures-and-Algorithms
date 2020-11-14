package classFiles;
class SolveQueen
{
	int n;
	short board[][];
	short sol[][];
	SolveQueen(int n){
		this.n = n;
		board = new short[n][n];
		sol = new short[n][n];
	}

	boolean isValid(int row, int col){
		for (int i=0; i<col; i++) {
			if(sol[row][i]==1)
				return false;
		}

		for (int i=row, j=col; i>=0 && j>=0; i--, j--) {
			if(sol[i][j]==1)
				return false;
		}

		for (int i=row, j=col; i<n && j>=0; i++,j--) {
			if(sol[i][j]==1)
				return false;
		}

		return true;
	}

	boolean queenAlgo(int col){
		if(col == n)
			return true;
		for (int i=0; i<n; i++) {
			if(isValid(i, col)){
				sol[i][col] = 1;
				if(queenAlgo(col+1))
					return true;
				else
					sol[i][col] = 0;
			}
		}
		return false;
	}

	void printSol(){
		for (int i=0; i<n; i++) {
			for (int j=0; j<n; j++) {
				System.out.print(sol[i][j]+" ");
			}
			System.out.println();
		}
	}
}

public class NQueens
{
	public static void main(String[] args) {
		SolveQueen obj = new SolveQueen(5);
		if(obj.queenAlgo(0)){
			System.out.println("Yes");
			obj.printSol();
		}
		else
			System.out.print("No");
	}
}