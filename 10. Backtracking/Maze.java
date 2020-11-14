package classFiles;
public class Maze
{
	public static void main(String[] args) {
		SolveMaze obj = new SolveMaze();
		if(obj.maze_util(0, 0)){
			System.out.println("Yes");
			obj.printSol();
		}
		else
			System.out.println("No");
	}
}
class SolveMaze
{
	int n = 4;
	int [][]maze = {{1, 1, 1, 0}, {1, 0, 0, 1}, {0, 1, 0, 0}, {1, 1, 1, 1}};
	int sol[][] = new int[n][n];
	boolean isValid(int i, int j){
		if(i<n && j<n && maze[i][j] == 1)
			return true;
		return false;
	}
	boolean maze_util(int i, int  j){
		if(i==n-1 && j==n-1){
			sol[i][j] = 1;
			return true;
		}
		if(isValid(i, j)){
			sol[i][j] = 1;
			if(maze_util(i, j+1))
				return true;
			else if(maze_util(i+1, j))
				return true;
			sol[i][j] = 0;
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